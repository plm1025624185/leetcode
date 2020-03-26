数据结构与算法
====

# 目录

* <a id="#base">时间复杂度和空间复杂度分析</a> 
* <a href="#ArrayLinkedList">数组、链表、跳表的基本实现和特性</a>
* <a href="#StackQueue">栈、队列、优先队列、双端队列</a>
* <a href="#Hash">哈希表、映射、集合</a>
* <a href="#tree">树</a>
	* <a href="#binaryTreeIteration">二叉树的遍历</a>
	* <a href="#binarySearchTree">二叉搜索树</a>
	* <a href="#trie">字典树Trie</a>
* <a href="#divide">分治、回溯</a>
* <a href="#dfs">DFS(深度优先遍历)</a>
* <a href="#bfs">BFS(广度优先遍历)</a>
* <a href="#double">二分查找</a>
* <a href="#dynamic">动态规划</a>
* <a href="#tow-bfs">双向BFS</a>
* <a href="#bit">位运算</a>
* <a href="#bloom">布隆过滤器</a>
* <a href="lru">LRU Cache</a>
* <a href="#sort">排序算法</a>
* <a href="#string">字符串算法</a>

<a id="base" name="base"/>

# 时间复杂度和空间复杂度分析

参考链接：

* [如何理解算法时间复杂度的表示法](https://www.zhihu.com/question/21387264)
* [Master theorem](https://en.wikipedia.org/wiki/Master_theorem_(analysis_of_algorithms))
* [主定理](https://zh.wikipedia.org/wiki/%E4%B8%BB%E5%AE%9A%E7%90%86)

<a id="ArrayLinkedList" name="ArrayLinkedList"/>

# 数组、链表、跳表的基本实现和特性

参考链接：

* [Java ArrayList源码分析](http://developer.classpath.org/doc/java/util/ArrayList-source.html)
* [Linked List的标准实现代码](https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/)
* [Linked List示例代码](http://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/code/LinkedList.java)
* [Java LinkedList源码分析](http://developer.classpath.org/doc/java/util/LinkedList-source.html)
* [LRU Cache - Linked list: LRU缓存机制](https://leetcode-cn.com/problems/lru-cache/)
* [Redis - Skip List: 跳跃表、为啥Redis使用跳表（Skip List）而不是使用Red-Black？](https://www.zhihu.com/question/20202931)

<a id="StackQueue" name="StackQueue"/>

# 栈、队列、优先队列、双端队列

参考链接：

* [Java的PriorityQueue文档](https://docs.oracle.com/javase/10/docs/api/java/util/PriorityQueue.html)
* [Java的Stack源码](http://developer.classpath.org/doc/java/util/Stack-source.html)
* [Java的Query源码](http://fuseyism.com/classpath/doc/java/util/Queue-source.html)
* [Python的heapq](https://docs.python.org/2/library/heapq.html)
* [Python高性能的container库](https://docs.python.org/2/library/collections.html)

<a id="Hash" name="Hash"/>

# 哈希表、映射、集合

参考链接：

* [Java Set文档](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Set.html)
* [Java Map文档](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Map.html)

<a id="tree" name="tree" />

# 树

<a id="binaryTreeIteration" name="binaryTreeIteration"/>

## 二叉树的遍历

**前序遍历**

根节点----->左子树----->右子树

代码模板：

```Java
// 方式一：使用递归
public void preOrderTraverse(TreeNode node) {
	if (node != null) {
		// 对节点进行处理
		// to do something
		// 迭代左右子节点
		preOrderTraverse(node.left);
		preOrderTraverse(node.right);
	}
}

// 方式二：使用栈存放节点
public void preOrderTraverse(TreeNode root) {
	Stack<TreeNode> stack = new Stack();
    TreeNode tmp = root;
    while (tmp != null || !stack.isEmpty()) {
    	if (tmp != null) {
        	// 处理当前节点
            // to do something
            stack.push(tmp);
            tmp = tmp.left;
        } else {
            TreeNode node = stack.pop();
            tmp = node.right;
        }
    }
}
```

**中序遍历**

左子树----->根节点----->右子树

代码模板：

```Java
// 方式一：递归
public void inOrderTraverse(TreeNode root) {
	if (root != null) {
		// 先递归左子树
		inOrderTraverse(root.left);
		// 处理当前节点
		// to do something
		// 递归右子树
		inOrderTraverse(root.right);
	}
}

// 方式二：栈
public void inOrderTraverse(TreeNode root) {
	Stack<TreeNode> stack = new Stack<>();
    TreeNode tmp = root;
    while (tmp != null || !stack.isEmpty()) {
    	if (tmp != null) {
        	stack.push(tmp);
            tmp = tmp.left;
        } else {
            TreeNode node = stack.pop();
            // 处理节点
            // to do something
            tmp = node.right;
        }
    }
}
```

**后序遍历**

左子树----->右子树----->根节点

代码模板：

```Java
// 方式一：递归
public void postOrderTraverse(TreeNode root) {
	if (root != null) {
		// 递归左右子树
		postOrderTraverse(root.left);
		postOrderTraverse(root.right);
		// 处理当前节点
		// to do something
	}
}

// 方式二：使用栈
// 直接编写后序比较困难，这里先以根节点----->右节点----->左节点的顺序压栈，然后对其进行倒序
public void postOrderTraverse(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    List<TreeNode> list = new ArrayList<>(); // 进行辅助
    stack.push(root);
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        if (node == null) continue;
        if (node.left != null) stack.push(node.left);
        if (root.right != null) stack.push(node.right);
        list.add(node);
    }
    Collections.reverse(list);
}
```

**层次遍历**

代码模板：

```Java
public void levelTraverse(TreeNode root) {
    // 层次遍历需要使用队列进行实现
    Deque<TreeNode> deque = new LinkedList<>();
    // 初始化
    deque.addLast(root);
    // 进行遍历
    while (!deque.isEmpty()) {
        int size = deque.size();
        while (size-- > 0) {
            TreeNode node = deque.removeFirst();
            if (node == null) continue;
            // 处理当前节点
            // to do something
            deque.addLast(node.left);
            deque.addLast(node.right);
        }
    }
}
```

**二叉树例子**

![二叉树例子](http://processon.com/chart_image/5e04547ce4b0250e8af36fd7.png)

前序遍历：12457836
中序遍历：42758136
后序遍历：47852631
层次遍历：12345678

<a id="trie" name="trie" />
## 字典树Trie

**概念**

		字典树，即Trie树，又称为单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。
		它的优点是：最大限度地减少无畏的字符串比较，查询效率比哈希表高。

**代码模板**

```Java
public class Trie {
	private TrieNode root; //根节点
	
	public Trie() {
		root = new TrieNode('');
	}
	
	public void insert(String word) {
		char[] array = word.toCharArray();
		TrieNode tmp = root;
		for (int i = 0; i < array.length; i++) {
			int index = array[i] - 'a';
			if (tmp.children[index] == null) tmp.children[index] = new TrieNode(array[i]);
			tmp = tmp.children[index];
		}
		tmp.isWord = true;
	}
	
	public boolean search(String word) {
		char[] array = word.toCharArray();
		TrieNode tmp = root;
		for (char c : array) {
			if (tmp.children[c - 'a'] == null) return false;
			tmp = tmp.children[c - 'a'];
		}
		return tmp.isWord;
	}
	
	public boolean startsWith(String prefix) {
		char[] array = prefix.toCharArray();
		TrieNode tmp = root;
		for (char c : array) {
			if (tmp.children[c - 'a'] == null) return false;
			tmp = tmp.children[c - 'a'];
		}
		return true;
	}
	
	/**
	 * 使用数组实现
	 */
	private class TrieNode {
		char val;
		boolean isWord;
		TrieNode[] children;
		
		TrieNode() {
			isWord = false;
			children = new TrieNode[26];
		}
		
		TrieNode(char c) {
			isWord = false;
			children = new TrieNode[26];
			val = c;
		}
	}
}
```

<a id="divide" name="divide"/>

# 分治、回溯

<a id="dfs" name="dfs"/>

# DFS

**代码模板**

```Java
public void dfs(TreeNode node, Set visited) {
	if (visited.contains(node)) return;
	// 将节点添加到visited中
	visited.add(node)
	// do something
	dfs(node.child, visited);
}
```

<a id="bfs" name="bfs"/>

# BFS

**代码模板**

```Java
// BFS一般使用队列来存储数据
public void bfs(String begin, String end, List<String> wordList) {
	Deque<String> deque = new LinkedList<>();
	Set<String> visited = new HashSet<>();
	// init
	deque.add(begin);
	while (!deque.isEmpty()) {
		int size = deque.size();
		while (size > 0) {
			String str = deque.removeFirst();
			if (!visited.contains(str)) {
				//do something
				visited.add(str);
				deque.addLast(str);
			}
			size--;
		}
	}
}
```

<a id="double" name="double"/>
# 二分查找

**代码模板**

```Java
public int binarySearch(int[] array, int left, int right, int target) {
	while (left <= right) {
		int mid = (left + right) / 2;
		if (array[mid] == target) {
			// todo
			return mid;
		} else if (array[mid] < tartget) {
			left = mid + 1;
		} else {
			right = mid - 1;
		}
	}
}
```

<a id="dynamic" name="dynamic"/>
# 动态规划

[动态规划](https://en.wikipedia.org/wiki/Dynamic_programming)

<a id="tow-bfs" name="two-bfs"/>
# 双向BFS

**代码模板**

```Java
public int doubleBfs(String start, String end, List<String> wordList) {
	Set<String> startSet = new HashSet<>();
	Set<String> endSet = new HashSet<>();
	Set<String> visited = new HashSet<>();
	int step = 0;
	//init
	startSet.add(start);
	endSet.add(end);
	//bfs
	while (!startSet.isEmpty() && !endSet.isEmpty()) {
		//优先扩散元素少的
		if (startSet.size() > endSet.size()) {
			Set<String> tmpSet = startSet;
			startSet = endSet;
			endSet = tmpSet;
		}
		Set<String> tmpSet = new HashSet<>();
		for (String s : startSet) {
			if (endSet.contains(s)) return step + 1;//相遇说明找到最短路径
			if (!visited.contains(s)) {
				//do something
				visited.add(s);
				tmpSet.add(s);
			}
		}
		startSet = tmpSet;
		step++;
	}
}
```

<a id="bit" name="bit"/>

# 位运算

**基础**

含义|运算符|示例
:-:|:-:|:-
左移|<<|0011 => 0110
右移|>>|0011 => 0001
按位或|\||0011<br/>--------=>1011<br/>1011
按位与|&|0011<br/>--------=>0011<br/>1011
按位取反|~|0011 => 1100
按位异或(相同为零不同为一)|^|0011<br/>--------=>1000<br/>1011

<a id="questions" name="questions"/>

**XOR-异或操作特点**

* x ^ 0 = x
* x ^ 1s = ~x  //注意 1s = ~0
* x ^ (~x) = 1s
* x ^ x = 0
* c = a ^ b => a ^ c = b, b ^ c = a  //交换两个数
* a ^ b ^ c = (a ^ b) ^ c = a ^ (b ^ c) 

**指定位置的位运算**

1. 将x最右边的n位清零：x & (~0 << n)
2. 获取x的第n位值(0或者1)：(x >> n) & 1
3. 获取x的第n位的幂值：x & (1 << (n - 1))
4. 仅将第n位置为1：x | (1 << n)
5. 仅将第n位置为0：x & (~ (1 << n))
6. 将x最高位至第n位(含)清零：x & ((1 << n) - 1)
7. 将第n位至第0位(含)清零：x & (~ ((1 << (n + 1)) - 1))

**位运算实战要点**

* 判断奇偶性：
	x % 2 == 1 --> (x & 1) == 1
	x % 2 == 0 --> (x & 1) == 0
* x >> 1 --> x / 2
	即：x = x / 2; --> x = x >> 1;
	mid = (left + right) / 2; --> mid = (left + right) >> 1;
* x = x & (x - 1) 清零最低位的1
* x & -x => 得到最低位的1
* x & ~x => 0

<a id="bloom" name="bloom"/>

# 布隆过滤器

**原理和实现**

参考地址：https://www.cnblogs.com/cpselvis/p/6265825.html

**主要运用**

参考地址：https://blog.csdn.net/tianyaleixiaowu/article/details/74721877

* 缓存击穿
* 垃圾邮件识别
* 集合判重

**代码模板**

参考地址：https://github.com/lovasoa/bloomfilter/blob/master/src/main/java/BloomFilter.java
参考地址：https://github.com/Baqend/Orestes-Bloomfilter

<a id="lru" name="lru"/>

# LRU Cache

* [Understanding the Meltdown exploit](https://www.sqlpassion.at/archive/2018/01/06/understanding-the-meltdown-exploit-in-my-own-simple-words/)
* [替换算法总览](https://en.wikipedia.org/wiki/Cache_replacement_policies)
* 

<a id="sort" name="sort"/>

# 排序算法

**参考链接**

1. [十大经典排序算法](https://www.cnblogs.com/onepixel/p/7674659.html)
2. [快速排序代码示例](https://shimo.im/docs/98KjvGwwGpTpYGKy/read)
3. [归并排序代码示例](https://shimo.im/docs/YqgG6vtdKwkXJkWx/read)
4. [堆排序代码示例](https://shimo.im/docs/6kRVHRphpgjHgCtx/read)

**初级排序**

1. 选择排序（Selection Sort）

代码模板：
```Java
/**
 * 每次找最小值，然后放到待排序数组的起始位置
 * 时间复杂度：O(n^2)
 * @author 潘磊明
 * @date 2019/12/5
 */
public class SelectionSort {
    public void sort(int[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) min = j;
            }
            int tmp = array[i];
            array[i] = array[min];
            array[min] = tmp;
        }
    }
}
```

2. 插入排序（Insertion Sort）

代码模板：
```Java
/**
 * 从前到后逐步构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
 * 时间复杂度：O(n^2)
 * @author 潘磊明
 * @date 2019/12/5
 */
public class InsertionSort {
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            while (j >= 0 && array[j] > array[j + 1]) {
                int tmp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = tmp;
                j--;
            }
        }
    }
}
```

3. 冒泡排序（Bubble Sort）

代码模板：
```Java
/**
 * 嵌套循环，每次查看相邻的元素，如果逆序则交换
 * 时间复杂度：O(n^2)
 * @author 潘磊明
 * @date 2019/12/5
 */
public class BubbleSort {
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
}
```

<a id="string" name="string"/>

# 字符串算法

* [Sunday算法](https://blog.csdn.net/u012505432/article/details/52210975)
* [Rabin-Karp 代码示例](https://shimo.im/docs/KXDdkT99TVtXvTXP/read)
* [字符串匹配的 KMP 算法](http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html)