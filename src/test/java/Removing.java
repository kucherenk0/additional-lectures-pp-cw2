import ru.mipt.ExternalTree;

public class Removing implements Runnable{
    private final ExternalTree tree;
    private final int[] keys;

    public Removing(ExternalTree tree, int[] keys) {
        this.tree = tree;
        this.keys = keys;
    }

    @Override
    public void run() {
        for(int key: keys) {
            tree.remove(key);
        }
    }
}
