package my.linkedlist;

public interface ILink {
	public void add(Object obj); // 实现链表数据追加
	public int size(); // 取得链表元素个数
	public boolean isEmpty(); // 判断是否为空链表
	public void clean(); // 清空链表
	public Object[] toArray(); // 以对象数组的形式返回链表数据
	public boolean contains(Object obj); // 判断指定内容是否存在，需要equals()支持
	public Object get(int index); // 取得指定索引对应的数据
	public void set(int index, Object obj); // 修改指定索引数据
	public void remove(Object obj); // 删除数据
}
