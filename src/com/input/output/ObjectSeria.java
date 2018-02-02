package com.input.output;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//对象的序列化案例
public class ObjectSeria {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * 对象的序列化 ObjectOutputStream objout = new ObjectOutputStream(new
		 * FileOutputStream("file.txt")); student stu = new student("10001",
		 * "张三", 20); objout.writeObject(stu); objout.flush(); objout.close();
		 */
		/*
		 * 对象的反序列化
		 * 
		 */
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.txt"));
		student stu = (student) in.readObject();// 强制类型转换,否则会读取Object的对象
		System.out.println(stu);
		in.close();
	}

}

@SuppressWarnings("serial")
class student implements Serializable {// 对象的序列化，对象一定要实现接口
	private String num;
	private String name;
	private transient int age;// 该元素不会进行jvm默认的序列化,可以自己完成元素序列化

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "student [num=" + num + ", name=" + name + ", age=" + age + "]";
	}

	public student(String num, String name, int age) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
	}

	private void writeObject(ObjectOutputStream s) throws Exception {
		s.defaultWriteObject();//把jvm默认序列化的元素进行序列化操作		
		s.writeInt(age);//自己完成age的序列化
	}

	private void readObject(ObjectInputStream s) throws Exception {
		s.defaultReadObject();//把jvm默认序列化的元素进行反序列化的操作
		age = s.readInt();//自己完成age的反序列化操作

	}
}
