package com.Thread.Demo;

/*
 * 共享线程---线程同步
 * 作用：当一个线程正在读取共享资源时，另一个线程处于等待状态
 */
public class synchronizedDemo implements Runnable {
	int i = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		synchronizedDemo c = new synchronizedDemo();
		new Thread(c).start();
		new Thread(c).start();
	}

	/* synchronized */ public void count() {
		synchronized (this) {// 调用synchronized方法同步处理
			i++;
			System.out.println(Thread.currentThread().getName() + ":" + i);
			try {
				Thread.sleep(1000);
				i++;
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
		/* 普通形式语法：
		 * synchronized(Object) 
		 * { 
		 * 		//statements to be synchronized 
		 * }
		 */
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		count();
	}

}
