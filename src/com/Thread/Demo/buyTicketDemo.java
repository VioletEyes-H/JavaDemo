package com.Thread.Demo;

public class buyTicketDemo implements Runnable {
	int five = 2, ten = 0, twenty = 0;
	Thread one, two;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new buyTicketDemo();

	}

	public buyTicketDemo() {
		// TODO Auto-generated constructor stub
		one = new Thread(this);
		two = new Thread(this);
		two.start();
		one.start();

	}

	public void Conductor(int money) {
		synchronized (this) {
			if (money == 5) {
				five += 1;
				System.out.println("您给的钱刚好够门票费");
			} else if (money == 20) {
				while (five < 3) {
					try {
						wait();// 若参数为20，线程等待
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				five -= 2;
				twenty += 1;
				System.out.println("您的钱购买了一张门票，实收20元，找您15元");
			}
			notifyAll();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (Thread.currentThread() == one) {
			this.Conductor(5);
		} else if (Thread.currentThread() == two) {
			this.Conductor(20);
		}
	}
}
