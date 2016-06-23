package ru.atconsulting;

import java.util.ArrayList;
import java.util.Random;

public class Main {
	private static ArrayList<Mobile> mobiles = new ArrayList<Mobile>();
	private static Random r= new Random();
	
	public static void main(String[] args){
		for(int i=0; i<20; i++){
			mobiles.add(new Mobile(r.nextInt(999),i+"asdf"));
		}
		for(Mobile m: mobiles){
			System.out.println(m.getNumber()+"  "+m.getName());
		}
		
		
	}

}
