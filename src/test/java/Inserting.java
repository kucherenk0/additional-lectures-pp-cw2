import ru.mipt.ExternalTree;
import ru.mipt.entities.Node;

public class Inserting implements Runnable{
    private final ExternalTree tree;
    private final int[] keys;

    public Inserting(ExternalTree tree, int[] keys) {
        this.tree = tree;
        this.keys = keys;
    }

    @Override
    public void run() {
        for(int key: keys) {
            tree.insert(new Node(key));
        }
    }
}
