package ru.thread;

public class Main {
	
	private static int number;

	public static void main(String[] args) {
		Thread t1 = new Thread(new Worker("1"));
		Thread t2 = new Thread(new Worker("2"));
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(number);
		

	}
	
	
	
	public static synchronized void  increaseNumber() {
		number++;
		
	}



	

}
