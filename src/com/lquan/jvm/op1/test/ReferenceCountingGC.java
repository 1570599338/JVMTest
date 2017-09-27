package com.lquan.jvm.op1.test;

import com.sun.webkit.graphics.Ref;

/**
 * 循环引用问题
 * @author liuquan
 *
 */
public class ReferenceCountingGC {
	
	public Object instance = null;
	
	private static final int _1MB = 1024*1024;
	
	/**
	 * 这个成员属性的唯一一一就是占点内存，以便能在GC日志中看清是否被回收过
	 */
	private byte[] bigSize = new byte[2*_1MB];
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();
		objA.instance = objB;
		objB.instance = objA;
		
		System.out.println("最大内存："+Runtime.getRuntime().maxMemory());
		System.out.println("可用内存："+Runtime.getRuntime().freeMemory());
		System.out.println("最大内存："+Runtime.getRuntime().totalMemory());
		
		
		objA =null;
		objB= null;
		System.gc();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
