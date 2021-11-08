package com.dima;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyMapTest {

    @Test
    public void size() {
        MyMap testable = new MyMap();
        String key = "a";
        Double value = 1.1;
        for (int i = 0; i < 5; i++) {
            testable.put(key,value);
            key += "a";
            value++;
        }
        int realLen = testable.size();
        int len = 5;
        assertEquals(realLen, len);
    }

    @Test
    public void isEmpty() {
        MyMap testable = new MyMap();
        assertTrue(testable.isEmpty());
    }

    @Test
    public void containsKey() {
        MyMap testable = new MyMap();
        String key = "a";
        Double value = 1.1;
        for (int i = 0; i < 5; i++) {
            testable.put(key,value);
            key += "a";
            value++;
        }
        assertTrue(testable.containsKey("a"));
    }

    @Test
    public void containsValue() {
        MyMap testable = new MyMap();
        String key = "a";
        Double value = 1.0;
        for (int i = 0; i < 5; i++) {
            testable.put(key,value);
            key += "a";
            value++;
        }
        boolean check = testable.containsValue(1.0);
        assertTrue(check);
    }

    @Test
    public void get() {
        MyMap testable = new MyMap();
        String key = "a";
        Double value = 1.1;
        for (int i = 0; i < 5; i++) {
            testable.put(key,value);
            key += "a";
            value++;
        }
        Double getted = testable.get("aa");
        boolean check = false;
        if(getted == 2.1) check = true;
        assertTrue(check);
    }

    @Test
    public void put() {
        MyMap testable = new MyMap();
        String key = "a";
        Double value = 1.1;
        testable.put(key,value);
        double checker = testable.get("a");
        boolean check = checker == 1.1;
        assertTrue(check);
    }

    @Test
    public void remove() {
        MyMap testable = new MyMap();
        String key = "a";
        Double value = 1.1;
        testable.put(key,value);
        testable.put("key",2.0);
        testable.remove("key");
        boolean check = testable.size()==1;
        assertTrue(check);
    }
}