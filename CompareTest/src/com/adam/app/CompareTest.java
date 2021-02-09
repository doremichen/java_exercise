package com.adam.app;

import java.util.Arrays;

public class CompareTest {

    public void compare() {
        PersonBean[]  p = {
                new PersonBean(20, "Tom"),
                new PersonBean(100, "Jeff"),
                new PersonBean(61, "Peter"),
                new PersonBean(20, "Bush")
        };
        
        System.out.println("before sort: " + Arrays.toString(p));
        
        AlphDesc desc = new AlphDesc();
        Arrays.sort(p, desc);
        
        System.out.println("after sort: " + Arrays.toString(p));
        
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CompareTest ct = new CompareTest();
        ct.compare();
    }

}
