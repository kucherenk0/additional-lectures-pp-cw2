package ru.mipt;

import ru.mipt.entities.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ThreadRunner {
    private int keyLimit = 100_000;

    private  void prepopulate(ExternalTree tree) {
        Random r = new Random();
        double threshold = 0.5;
        for(int i = 1; i <= keyLimit; i++) {
            double p = r.nextDouble();
            if(p > threshold) {
                tree.insert(new Node(i));
            }
        }
    }

    public void run(int n) throws InterruptedException {
        ExternalTree tree = new ExternalTree();
        prepopulate(tree);

        List<Executor> executors = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            executors.add(new Executor(tree));
        }

        List<Thread> threads = executors.stream().map(Thread::new).collect(Collectors.toList());

        for(Thread thread: threads) {
            thread.start();
        }

        for(Thread thread: threads) {
            thread.join();
        }

        int ops = 0;
        for(Executor e: executors) {
            ops += e.getCounter();
        }

        System.out.println("ops: " + ops);
    }
}
