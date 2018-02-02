package com.Thread.Demo;

public class PriorityDemo implements Runnable {
	/*
	 * �߳����ȼ�
	 */
	Thread t;
	private volatile boolean running = true;
	long check = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);// ���ص�ǰ����ִ���̶߳��������
		PriorityDemo hi = new PriorityDemo(Thread.NORM_PRIORITY + 2);// Ĭ��ֵ+2�����ȼ�
		PriorityDemo lo = new PriorityDemo(Thread.NORM_PRIORITY - 2);// Ĭ��ֵ-2�����ȼ�
		hi.start();
		lo.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hi.stop();
		lo.stop();
		try {
			hi.t.join();// �ȴ��߳���ֹ
			lo.t.join();// �ȴ��߳���ֹ
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Low-Prority:" + lo.check);
		System.out.println("High-Prority:" + hi.check);
	}

	public PriorityDemo(int p) {
		// TODO Auto-generated constructor stub
		t = new Thread(this);
		t.setPriority(p);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (running) {
			check++;
		}
	}

	public void stop() {
		running = false;
	}

	public void start() {
		t.start();
	}

}
