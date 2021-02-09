package com.adam.app;

import java.util.Comparator;

public class AlphDesc implements Comparator<PersonBean> {

    @Override
    public int compare(PersonBean arg0, PersonBean arg1) {
        // TODO Auto-generated method stub
        int cop = arg0.getAge() - arg1.getAge();
        
        if(cop != 0) {
            return cop;
        }
        
        
        return arg1.getName().compareTo(arg0.getName());
    }

}
