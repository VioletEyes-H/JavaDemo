package com.Collection.Demo;

/*
 * 备选课程类
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ListTest {
	/*
	 * 用于存放备选课程的list
	 */
	private List<Object> coursesSelect;

	public ListTest() {
		coursesSelect = new ArrayList<>();// 初始化list接口
	}

	/*
	 * 用于往coursesSelect中添加备选课程
	 */
	public void testAdd() {
		// 创建一个课程对象，并通过调用add方法，添加到备选课程list中
		Course cr1 = new Course("1", " C语言");
		coursesSelect.add(cr1);
		Course temp1 = (Course) coursesSelect.get(0);
		System.out.println("添加了课程：" + temp1.getId() + "：" + temp1.getName());
		Course[] course = { new Course("2", "离散数学"), new Course("3", "汇编语言") };
		coursesSelect.addAll(1, Arrays.asList(course));// 将集合在下标1的位置插入数组
		Course temp2 = (Course) coursesSelect.get(1);
		Course temp3 = (Course) coursesSelect.get(2);
		System.out.println(
				"选了两门课程：\n" + temp2.getId() + "：" + temp2.getName() + "\n" + temp3.getId() + "：" + temp3.getName());
	}

	/*
	 * 取得list中的元素的方法
	 */
	public void testGet() {
		int size = coursesSelect.size();
		System.out.println("有如下课程待选：");
		for (int i = 0; i < size; i++) {
			Course cr = (Course) coursesSelect.get(i);
			System.out.println("课程：" + cr.getId() + "." + cr.getName());
		}
	}

	/*
	 * 通过迭代器来遍历list
	 */
	public void testIterator() {
		// 通过集合的iterator的方法，取得迭代器的实例
		Iterator<Object> it = coursesSelect.iterator();
		System.out.println("有如下课程待选（通过迭代器遍历数组）：");
		while (it.hasNext()) {
			Course cr = (Course) it.next();
			System.out.println("课程：" + cr.getId() + "." + cr.getName());
		}
	}

	/*
	 * 通过for each方法访问集合
	 */
	public void testForEach() {
		System.out.println("有如下课程待选（通过ForEach遍历数组）：");
		for (Object obj : coursesSelect) {
			Course cr = (Course) obj;
			System.out.println("课程：" + cr.getId() + "." + cr.getName());
		}
	}

	/*
	 * 修改List中的元素
	 */
	public void testModify() {
		coursesSelect.set(2, new Course("4", "毛概"));
	}

	/*
	 * 删除List中的元素
	 */
	public void testRemove() {
		// Course cr = (Course) coursesSelect.get(2);
		// System.out.println("我是课程：" + cr.getId() + ":" + cr.getName() +
		// "，我即将被删除");
		// coursesSelect.remove(cr);

		// System.out.println("即将删除2位置上的课程");
		// coursesSelect.remove(2);

		System.out.println("即将删除1位置和2位置上的课程");
		Course[] courese = { (Course) coursesSelect.get(1), (Course) coursesSelect.get(2) };
		coursesSelect.removeAll(Arrays.asList(courese));
		System.out.println("成功删除课程");
	}

	/*
	 * 在list中添加一些奇怪的东西
	 */
	public void testType() {
		System.out.println("能否往list中添加一些奇怪的东西？");
		coursesSelect.add("我不是课程，我只是一个字符串");
		
		
	}

	public static void main(String[] args) {
		ListTest lt = new ListTest();
		lt.testAdd();
		lt.testType();
		// lt.testGet();//遍历list
		// lt.testIterator();//使用迭代器遍历list
		// lt.testModify();//更新list内容
		// lt.testRemove();//删除list指定内容
		 lt.testForEach();//使用for each遍历list

	}
}
