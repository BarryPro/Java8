package org.demo.others;

public class TestMinorGC {
    public Object instance = null;
    private static final int _1M = 1024*1024;

    private byte[] bigSize = new byte[2*_1M];

    public static void main(String[] args) {
        testGC();
    }

    public static void testGC(){
    	TestMinorGC objA = new TestMinorGC();
    	TestMinorGC objB = new TestMinorGC();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }
}
