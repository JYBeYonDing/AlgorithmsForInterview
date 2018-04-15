package 牛客算法班.第三期.basic_class_05;

public class Code_01_前缀树 {

	/**
	 * Node 结构，前缀树的节点结构
	 */
	public static class TrieNode {
		public int pass;
		public int end;
		public TrieNode[] nexts;
//		public HashMap<Integer, TrieNode> nexts;

		public TrieNode() {
			pass = 0;
			end = 0;
			nexts = new TrieNode[26];// 认为都是小写字母，只有26个字母
		}
	}

	public static class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			if (word == null) {
				return;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					node.nexts[index] = new TrieNode();
				}
				node = node.nexts[index];
				node.pass++;
			}
			node.end++;
		}

		public void delete(String word) {
			if (search(word)!=0) { //只有可以找到这个单词才可以删除
				char[] chs = word.toCharArray();
				TrieNode node = root;
				int index = 0;
				for (int i = 0; i < chs.length; i++) {
					index = chs[i] - 'a';
					if (node.nexts[index].pass-- == 1) {
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
