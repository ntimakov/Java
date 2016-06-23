package ru.thread;

public class Worker implements Runnable {
	private String name;

	public Worker(String name){
		this.name=name;
	}
	
	@Override
	public void run() {
		for(int i=0;i<2000;i++){
			Main.increaseNumber();
		}
		System.out.println("Завершился поток номер: "+name);

	}
	

}
