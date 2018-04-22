package 牛客算法班.第三期.basic_class_05;

public class Code_01_前缀树 {

	/**
	 * Node 结构，前缀树的节点结构
	 * 字母用边来标记，千万不要放在节点上，不然很烦！！！
	 */
	public static class TrieNode {
		//可以通过添加属性进行功能的扩充
		public int pass;// 有多少数据项经过该节点
		public int end;// 有多少数据项以该点结尾
		public TrieNode[] nexts;// 有多少条路，也可以设计成map结构
//		public HashMap<Integer, TrieNode> nexts;

		public TrieNode() {
			pass = 0;
			end = 0;
			nexts = new TrieNode[26];// 认为都是小写字母，所以只有26个字母，字母用边来标记，千万不要放在节点上，不然很烦。
		}
	}

	/**
	 * 前缀树
	 */
	public static class Trie {
		private TrieNode root;// 一定有一个头结点

		public Trie() {
			root = new TrieNode();
		}

		/**
		 * 插入单词
		 * 每次插入单词都是从头结点开始比对字符，注意：字符是用边来表示的
		 * @param word
		 */
		public void insert(String word) {
			if (word == null) {
				return;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;// 字符在nexts路中的索引
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					node.nexts[index] = new TrieNode();
				}
				node = node.nexts[index];
				node.pass++;//这条语句放这里感觉root的pass就是一直为0了，我感觉还是放到上一句好，但是对其他部分有影响
			}
			node.end++;
		}

		/**
		 * 在前缀树中删除单词
		 * @param word
		 */
		public void delete(String word) {
			if (search(word)!=0) { //只有可以找到这个单词才可以删除
				char[] chs = word.toCharArray();
				TrieNode node = root;
				int index = 0;// 确定是哪一条边
				for (int i = 0; i < chs.length; i++) {
					index = chs[i] - 'a';
					if (node.nexts[index].pass-- == 1) {// 如果这个边不被其他单词用到，说明就是要删除的这个单词
						node.nexts[index] = null;
						return;
					}
					node = node.nexts[index];
				}
				node.end--;
			}
		}

		/**
		 * 返回 该字符串出现了多少次
		 * @param word
		 * @return
		 */
		public int search(String word) {
			if (word == null) {
//				return false;
				return 0;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
//					return false;
					return 0;
				}
				node = node.nexts[index];
			}
//			return node.end != 0;
			return node.end;
		}

		/**
		 * 有多少个单词 前缀是 pre
		 * @param pre
		 * @return
		 */
		public int prefixNumber(String pre) {
			if (pre == null) {
				return 0;
			}
			char[] chs = pre.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.pass;
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		trie.insert("zuo");
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuoa");
		trie.insert("zuoac");
		trie.insert("zuoab");
		trie.insert("zuoad");
		trie.delete("zuoa");
		System.out.println(trie.search("zuoa"));
		System.out.println(trie.prefixNumber("zuo"));

	}

}
