package com.lquan.jvm.op1.test;

/**
 * 长期存活的对象进入老年区
 * @author liuquan
 *
 */
public class PretenureSizeThrreshold {
	
	private static final int _1MB=1024*1024;

	/**
	 * VM 参数：-verbose：gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
	 * -XX:MaxTenuringThreshold=1
	 * -XX:+PrintTenuringDistribution
	 * @param args
	 */
	public static void main(String[] args) {
		byte[] allocation1,allocation2,allocation3;
		allocation1 = new byte[4*_1MB];
		allocation2 = new byte[4*_1MB];
		allocation3 = null;
		allocation3 = new byte[4*_1MB];

	}
	
	
	

}
