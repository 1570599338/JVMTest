package com.lquan.jvm.op1.test;

/**
 * 此代码演示了两点
 * 1、对象可以被GC时自我拯救
 * 2、这种自救的机会只有一次，因为一个对象finalized（）方法最多只会被系统自动调用一次
 * @author liuquan
 *
 */
public class FinalizedEscapeGC {

	public static FinalizedEscapeGC save_hook=null;
	
	public void isAlive(){
		System.out.println("yes,I am still alive :)");
	}
	
	
	
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method executed!");
		FinalizedEscapeGC.save_hook = this;
	}

	public static void main(String[] args) throws Throwable {
		save_hook = new FinalizedEscapeGC();
		
		// 对象第一次成功拯救自己
		save_hook = null;
		System.out.println("GC 开始了");
		System.gc();
		System.out.println("GC 结束了");
		
		// 因为finalize方法优先级很低，所以展示0.5秒以等待
		Thread.sleep(500);
		
		 if(save_hook!=null){
			save_hook.isAlive(); 
		 }else{
			 System.out.println("no,I am dead :(");
		 }
		
		 
		// 第二次自救失败 
		save_hook = null;
		System.gc();
		
		// 因为finalize方法优先级很低，所以展示0.5秒以等待
		Thread.sleep(500);
		
		 if(save_hook!=null){
			save_hook.isAlive(); 
		 }else{
			 System.out.println("no,I am dead :(");
		 }
		
		
	}
}
