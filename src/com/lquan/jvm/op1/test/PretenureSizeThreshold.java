package com.lquan.jvm.op1.test;

/**
 * 大对象直接进入老年区
 * @author liuquan
 *
 */
public class PretenureSizeThreshold {
	
	private static final int _1MB=1024*1024;

	/**
	 * VM 参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M  -XX:+PrintGCDetails  -XX:SurvivorRatio=8 
	 * -XX:PretenureSizeThreshold=3145728
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] allocation1;
		allocation1 = new byte[4*_1MB];

	}

}
