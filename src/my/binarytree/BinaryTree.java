package my.binarytree;

public class BinaryTree<T extends Comparable<T>> { // 定义一个二叉树，二叉树里面需要保存有多个节点
	private class Node { // 只要是进行数据结构的开发，必然要存在有Node类对象
		private T data; // 保存的数据类型由外部来统一设置
		private Node left;
		private Node right;

		public Node(T data) {
			this.data = data;
		}

		public void addNode(Node newNode) {
			Comparable<T> comp = newNode.data; // 取出原始的保存对象
			if (comp.compareTo(this.data) < 0) { // 判断节点间数据关系
				if (this.left == null) { // 左子树为空，可以保存
					this.left = newNode;
				} else {
					this.left.addNode(newNode); // 向左边继续进行判断
				}
			} else {
				if (this.right == null) {
					this.right = newNode;
				} else {
					this.right.addNode(newNode);
				}
			}
		}

		public void toArrayNode() {
			if (this.left != null) {
				this.left.toArrayNode();
			}
			BinaryTree.this.retData[BinaryTree.this.foot++] = this.data;
			if (this.right != null) {
				this.right.toArrayNode();
			}
		}
	}

	// --------------- 华丽丽的风格线 --------------------
	private Node root; // 根节点是关键性节点，第一个数据应该设置为根节点
	private int count; // 保存元素的个数
	private Object[] retData;
	private int foot = 0;

	public void add(T data) { // 设置要保存的数据
		if (!(data instanceof Comparable)) { // 必须保存Comparable子类型
			throw new ClassCastException("当前传入的对象不是Comparable接口子类。");
		}
		// 为了进行节点的关系处理，此处必须要将数据包装为Node类对象
		Node newNode = new Node(data);
		if (this.root == null) { // 如果现在根节点没有数据
			this.root = newNode; // 第一个节点设置为根节点
		} else { // 如果现在根节点存在
			this.root.addNode(newNode);
		}
		this.count++;
	}

	public Object[] toArray() { // 返回全部的二叉树数据
		if (this.count == 0) {
			return null; // 现在没有数据
		}
		this.foot = 0; // 重置处理脚标
		this.retData = new Object[this.count]; // 开辟返回数组
		this.root.toArrayNode();
		return this.retData;
	}

}
