package com;

import com.interfaces.InShowFirst;
import com.interfaces.InShowSec;

public class Demo implements Runnable{
	
	private Thread t;
	
	

	public Demo() {
		t = new Thread(this);
		t.start();
	}



	@Override
	public void run() {
		for(int i=0;i<10;i++) {
    		System.out.println("inside main demo thread "+i);
    		try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}	}



	
}
