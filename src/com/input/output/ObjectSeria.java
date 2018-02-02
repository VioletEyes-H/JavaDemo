package com.input.output;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//��������л�����
public class ObjectSeria {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * ��������л� ObjectOutputStream objout = new ObjectOutputStream(new
		 * FileOutputStream("file.txt")); student stu = new student("10001",
		 * "����", 20); objout.writeObject(stu); objout.flush(); objout.close();
		 */
		/*
		 * ����ķ����л�
		 * 
		 */
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.txt"));
		student stu = (student) in.readObject();// ǿ������ת��,������ȡObject�Ķ���
		System.out.println(stu);
		in.close();
	}

}

@SuppressWarnings("serial")
class student implements Serializable {// ��������л�������һ��Ҫʵ�ֽӿ�
	private String num;
	private String name;
	private transient int age;// ��Ԫ�ز������jvmĬ�ϵ����л�,�����Լ����Ԫ�����л�

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
		s.defaultWriteObject();//��jvmĬ�����л���Ԫ�ؽ������л�����		
		s.writeInt(age);//�Լ����age�����л�
	}

	private void readObject(ObjectInputStream s) throws Exception {
		s.defaultReadObject();//��jvmĬ�����л���Ԫ�ؽ��з����л��Ĳ���
		age = s.readInt();//�Լ����age�ķ����л�����

	}
}
