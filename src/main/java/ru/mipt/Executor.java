package ru.mipt;

import ru.mipt.entities.Node;

import java.util.Random;

public class Executor implements Runnable{
    private final ExternalTree tree;
    private final double x = 0.5;
    private int counter;
    private final long seed = 0;
    private int keyLimit = 100_000;

    public Executor(ExternalTree tree) {
        this.tree = tree;
    }

    @Override
    public void run() {
        Random r = new Random();
        r.setSeed(seed);
        long startTime = System.currentTimeMillis();

        int duration = 5000;
        while ((System.currentTimeMillis() - startTime) < duration) {
            counter++;
            int key = r.nextInt(keyLimit);
            double p = r.nextDouble();
            if (p < x) {
                tree.insert(new Node(key));
                continue;
            }

            if(p >= x && p < 2 * x) {
                tree.remove(key);
                continue;
            }

            if(p >= 2 * x) {
                tree.contains(key);
            }
        }
    }

    public int getCounter() {
        return counter;
    }
}
