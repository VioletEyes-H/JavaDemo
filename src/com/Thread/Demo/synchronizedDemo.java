package com.Thread.Demo;

/*
 * �����߳�---�߳�ͬ��
 * ���ã���һ���߳����ڶ�ȡ������Դʱ����һ���̴߳��ڵȴ�״̬
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
		synchronized (this) {// ����synchronized����ͬ������
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
		/* ��ͨ��ʽ�﷨��
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
