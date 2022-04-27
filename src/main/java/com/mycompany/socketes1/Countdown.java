package com.mycompany.socketes1;

public class Countdown extends Thread {
	
	private int time; 
	private boolean flag = false;  
	
	public Countdown(int time) {
		this.time = time; 
	}
	
	@Override
	public void run() {
		
		while(time>=0) {
			while(!flag) {
				System.out.println(time);
				time = time - 1; 
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void stopThread() {
		flag = true; 
	}

}