package 牛客算法班.第三期.advanced_class_05;

/**
 * 某位程序想出了一个压缩字符串的方法， 压缩后的字符串如下:
 3{a}2{bc}， 3{a2{c}}， 2{abc}3{cd}ef， 现在 需要你写一个解
 压的程序， 还原原始的字符串。 如: s = "3{d}2{bc}", return
 "dddbcbc". s = "3{a2{d}}", return "addaddadd". s =
 "2{efg}3{cd}ef", return "efgefgcdcdcdef". 重复次数可以
 确保是一个正整数。


 1+3*(4+2*(3+5))+2 这种表达式计算也可以使用这种递归的思想。

 */
public class Code_04_Decompress_String {

	public static String decompress(String decompressStr) {
		char[] chs = decompressStr.toCharArray();
		return process(chs, 0).str;
	}

	public static class ReturnData {
		public String str;
		public int end;

		public ReturnData(String str, int nextIndex) {
			this.str = str;
			this.end = nextIndex;
		}
	}

	public static ReturnData process(char[] chs, int index) {
		StringBuilder res = new StringBuilder();
		int times = 0;
		while (index < chs.length && chs[index] != '}') {
			if (chs[index] == '{') {
				ReturnData returnData = process(chs, index + 1);
				res.append(getTimesString(times, returnData.str));
				times = 0;
				index = returnData.end + 1;
			} else {
				if (chs[index] >= '0' && chs[index] <= '9') {
					times = times * 10 + chs[index] - '0';
				}
				if (chs[index] >= 'a' && chs[index] <= 'z') {
					res.append(String.valueOf(chs[index]));
				}
				index++;
			}
		}
		return new ReturnData(res.toString(), index);
	}

	public static String getTimesString(int times, String base) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < times; i++) {
			res.append(base);
		}
		return res.toString();
	}

	public static void main(String[] args) {
		String test1 = "3{a}2{bc}";
		String test2 = "3{a2{c}}";
		String test3 = "2{abc}3{cd}ef";
		System.out.println(decompress(test1));
		System.out.println(decompress(test2));
		System.out.println(decompress(test3));

	}

}
