package org.demo.others;

import org.junit.Test;

public class ThreadTest {
	public static void main(String[] args) {
		Stest stest = new Stest();
		Thread tt = new Thread(stest);
		tt.start();
		tt.setPriority(Thread.MAX_PRIORITY);
		
		
		for(int i = 0;i<100;i++){
			System.out.println("main"+i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}

class Stest implements Runnable{
	@Test
	@Override
	public void run() {
		for(int i = 0;i<100;i++){
			System.out.println("thread"+i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		}
		
}