package com.Collection.Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SetTest {
	/*
	 * Set
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetTest st = new SetTest();
		st.testAdd();
		st.testListContains();
		st.testForEach();
		// 创建一个学生对象
		Student student = new Student("10", "小明");
		System.out.println("欢迎学生：" + student.getName() + "选课！");
		// 创建一个Scanner对象，用来接收键盘输入的课程id
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			System.out.println("请输入课程ID：");
			String courseId = in.next();
			for (Course cr : st.coursesSelect) {
				if (cr.getId().equals(courseId)) {
					student.courses.add(cr);
				}
			}
		}
		// 打印输出学生所选的课程
		for (Course cr : student.courses) {
			System.out.println("选择了课程：" + cr.getId() + "：" + cr.getName());
		}
		/*
		 * Set方法只能调用foreach还有iterator方法。不能调用get方法
		 * 因为Set方法是无序的
		 * Set中的元素是不可重复的
		 * 无论添加多少次最终只会保留一个该对象
		 * 并且保留的是第一次添加的那一个
		 * 可以添加一个null值
		 */
	}

	public List<Course> coursesSelect;

	public SetTest() {
		coursesSelect = new ArrayList<Course>();
	}

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

	public void testForEach() {
		System.out.println("有如下课程待选（通过ForEach遍历数组）：");
		for (Object obj : coursesSelect) {
			Course cr = (Course) obj;
			System.out.println("课程：" + cr.getId() + "." + cr.getName());
		}
	}
	/*
	 * 测试List的contains放大
	 */
	public void testListContains()
	{
		//取得备选课程序列的第0个元素
		Course course = coursesSelect.get(0);
		//打印输出CoursesSelect是否包含course对象
		System.out.println("取得课程："+course.getName());
		System.out.println("备选课程中是否包含课程："+course.getName()+","+coursesSelect.contains(course));
		
	}

}
