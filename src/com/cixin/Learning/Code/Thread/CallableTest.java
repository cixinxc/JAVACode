package com.cixin.Learning.Code.Thread;

import java.util.*;
import java.util.concurrent.*;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> tasks = new ArrayList<>();
        for(int i=0;i<5;i++) {
            tasks.add(exec.submit(new TaskWithResult(i)));
        }
        Thread.interrupted();
        List<String> results = new ArrayList<>();
        while (!tasks.isEmpty()) {
            for(int i = 0;i<tasks.size();i++) {
                if(tasks.get(i).isDone()) {
                    System.out.println(tasks.get(i%2).isCancelled());
                    results.add(tasks.get(i).get());
                    System.out.println(tasks.get(i).get());
                    tasks.remove(i);
                    i--;
                }ArrayList<Integer> l = new ArrayList<>(10);
            }
        }

        exec.shutdown();
    }

}

class CallableTests implements Callable {

    @Override
    public Object call() throws Exception {
        return null;
    }
}

class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000*(5-id%2));
        return "result of TaskWithResult " + id;
    }
}