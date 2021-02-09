package com.adam.app;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;


public class IterateMe implements Runnable {

    // create copy on write array list
    private static final CopyOnWriteArrayList<String> sNames = new CopyOnWriteArrayList<String>();
    
    static {
        sNames.add("Snoopy");
        sNames.add("Scott");
        sNames.add("doremi");
        sNames.add("adam");
        sNames.add("bill");
        
    }
    
    private String mThreadName;
    private boolean mGotoSleep;
    
    public IterateMe(String name, boolean sleep) {
        this.mThreadName = name;
        this.mGotoSleep = sleep;
    }
    
    public static CopyOnWriteArrayList<String> getNameList() {
        return sNames;
    }
    
    public void setGoToSleep(boolean set) {
        this.mGotoSleep = set;
    }
    
    
    @Override
    public void run() {
        // go to sleep
        if (this.mGotoSleep == true) {
            try {
                Utils.info(this.mThreadName + " sleep...");
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        Utils.info(this.mThreadName + " name list =============================");
        
        Iterator<String> it = sNames.iterator();
        while (it.hasNext()) {
            Utils.info(this.mThreadName + " " + it.next());
        }
    }

}
