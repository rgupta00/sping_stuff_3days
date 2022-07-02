package com.demo;
class Emp{
	Emp(){
		System.out.println("ctr");
	}
	public void doWork() {
		System.out.println("doing a work");
	}
}
public class Demo {
	
	public static void main(String[] args) {
		Emp e=new Emp();
		e.doWork();
		e.doWork();
		
	}

}
