package com.adam.app;

import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainTest {

    private static final int THREAD_NUM = 3;
    
    public static void main(String[] args) {
        // Executor
        ExecutorService service = Executors.newFixedThreadPool(THREAD_NUM);
        
        // Build array of iterateMe task
        IterateMe[] tasks = new IterateMe[THREAD_NUM];
        for (int i = 0; i < THREAD_NUM; i++) {
            tasks[i] = new IterateMe("Thread_" + i, false);
        }
        
        // show original content
        Utils.info("Show original name content =============== ");
        for (String name: IterateMe.getNameList()) {
            Utils.info(name);
        }
        
        // Execute tasks 0
        service.submit(tasks[0]);
        // add string
        IterateMe.getNameList().addIfAbsent("tom");
        
        // task1 sleep
        tasks[1].setGoToSleep(true);
        // Execute task 1
        service.submit(tasks[1]);
        // remove string
        IterateMe.getNameList().remove("adam");
        
        // Execute task 2
        service.submit(tasks[2]);
        
        
        // try to remove when iterating
        Iterator<String> it = IterateMe.getNameList().iterator();
        while (it.hasNext()) {
            // wait 1 sec
            try
            {
                Thread.sleep(1000L);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            // remove element in copy on write list
            IterateMe.getNameList().remove("doremi");
            it.next();
        }
        Utils.info("Test end ===============================");
        service.shutdown();

    }

}
