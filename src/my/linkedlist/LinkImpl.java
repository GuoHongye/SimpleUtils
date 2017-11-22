package my.linkedlist;

public class LinkImpl implements ILink { // 先定义标准后再做子类
	private class Node { // 链表需要节点类，但是该类只为链表服务
		private Object data; // 要保存的数据内容
		private Node next; // 保存下一个节点信息

		public Node(Object data) {
			this.data = data;
		}

		// 第1次调用：this = LinkImpl.root
		// 第2次调用：this = LinkImpl.root.next
		public void addNode(Node newNode) {
			if (this.next == null) { // 当前节点下一个为null
				this.next = newNode; // 保存新节点
			} else { // 当前节点之后不为null
				this.next.addNode(newNode);
			}
		}

		// 第1次调用：this = LinkImpl.root
		// 第2次调用：this = LinkImpl.root.next
		public void toArrayNode() { // 递归调用
			LinkImpl.this.retData[LinkImpl.this.foot++] = this.data; // 取出当前节点数据
			if (this.next != null) { // 还有下一个节点
				this.next.toArrayNode();
			}
		}

		public boolean containsNode(Object obj) {
			if (obj.equals(this.data)) { // 当前节点数据符合于查询内容
				return true;
			} else { // 如果不是则应该继续向下判断
				if (this.next != null) { // 有后续节点
					return this.next.containsNode(obj);
				} else { // 没有后续节点
					return false;
				}
			}
		}

		public Object getNode(int index) {
			if (LinkImpl.this.foot++ == index) {
				return this.data; // 返回当前数据
			} else {
				if (this.next != null) {
					return this.next.getNode(index);
				} else {
					return null;
				}
			}
		}

		public void setNode(int index, Object data) {
			if (LinkImpl.this.foot++ == index) {
				this.data = data;
			} else {
				if (this.next != null) {
					this.next.setNode(index, data);
				}
			}
		}

		// 第1次调用：this = LinkImpl.root.next、previousNode = LinkImpl.root
		// 第2次调用：this = LinkImpl.root.next.next、previousNode = LinkImpl.root.next
		public void removeNode(Node previousNode, Object obj) {
			if (this.data.equals(obj)) { // 当前节点为要删除节点
				previousNode.next = this.next; // 空出当前节点
			} else {
				this.next.removeNode(this, obj);
			}
		}
	}

	// ============== 华丽丽的分割线 ===================== //
	private Node root; // 根节点
	private int count = 0; // 统计元素个数
	private int foot = 0; // 返回数据的控制脚标
	private Object retData[]; // 定义一个返回的数组

	public void add(Object obj) { // 牵扯到节点关系
		if (obj == null) { // 现在没有数据保存
			return; // 方法执行结束
		}
		Node newNode = new Node(obj); // 创建了一个新的节点
		if (this.root == null) { // 当前没有根节点
			this.root = newNode; // 第一个节点设置为根节点
		} else {
			this.root.addNode(newNode); // 交给Node负责
		}
		this.count++; // 当节点保存完毕之后就可以进行数据增加了
	}

	public boolean isEmpty() {
		return this.count == 0;
	}

	public int size() {
		return this.count;
	}

	public void clean() {
		this.root = null; // 其所占引用全部成为垃圾
		this.count = 0; // 元素的保存个数清0
	}

	public Object[] toArray() {
		if (this.root == null) { // 现在没有数据
			return new Object[0]; // 没有数据返回
		}
		this.retData = new Object[this.count];// 根据已有的数据个数开辟数组
		this.foot = 0; // 脚标重置
		this.root.toArrayNode(); // 交给Node类负责
		return this.retData;
	}

	public boolean contains(Object obj) { // 必须保证链表数据
		if (this.root == null || obj == null) { // 没有根节点 = 没有数据
			return false;
		}
		return this.root.containsNode(obj); // 交由Node类负责
	}

	public Object get(int index) {
		if (index >= this.count) { // 要获取的索引数大于保存的元素个数；
			return null; // 没有该数据
		}
		this.foot = 0; // 重置foot的脚标
		return this.root.getNode(index); // 交由Node类负责
	}

	public void set(int index, Object obj) {
		if (index >= this.count) { // 要获取的索引数大于保存的元素个数；
			return; // 没有该数据
		}
		this.foot = 0; // 重置foot的脚标
		this.root.setNode(index, obj); // 交由Node类负责
	}

	public void remove(Object obj) {
		if (this.contains(obj)) { // 要删除的节点存在
			if (this.root.data.equals(obj)) { // 要删除的是根节点
				this.root = this.root.next; // 根节点的下一个为新的根节点
			} else {
				this.root.next.removeNode(this.root, obj); // 从根节点下一个开始
			}
			this.count--; // 保存的元素个数要减少
		}
	}
}
