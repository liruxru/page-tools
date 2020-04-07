package com.mt.tlstools;

public class FloatTest {

    public static void main(String[] args) {
        Float aFloat= 80.0f;
        System.out.println(Float.isFinite(aFloat));
        System.out.println(Float.isNaN(aFloat));
        System.out.println(Float.isInfinite(aFloat));
    }
}
