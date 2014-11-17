package flatten;

import java.util.ArrayList;
import java.util.List;

public class MyFlattenTree<T> implements FlattenTree<T> {

  @Override
  public List<T> flattenInOrder(Tree<T> tree) {
    if (tree == null) {
      throw new IllegalArgumentException("tree is null");
    }
    
    final List<T> list = new ArrayList<>();
    try {
      if (tree.get().isLeft()) {
        tree.get().ifLeft(new Function<T, T>() {
          @Override
          public T apply(T p) {
            if (p instanceof Tree) {
              // this handles trees built this way:
              // Node.tree(1, Node.tree(5, 4, 9), 6);
              list.addAll(flattenInOrder((Tree<T>) p));
            } else {
              list.add(p);
            }
            return null;
          }
        });
      } else {
        tree.get().ifRight(new Function<Triple<Tree<T>>, T>() {
          @Override
          public T apply(Triple<Tree<T>> p) {
            list.addAll(flattenInOrder(p.left()));
            list.addAll(flattenInOrder(p.middle()));
            list.addAll(flattenInOrder(p.right()));
            return null;
          }
        });
      }
    } catch (IllegalArgumentException e) {
      // ugly hack
      // this handles trees built this way:
      // new Node<>(Node.tree(1, null, null), Node.tree(5, 4, 9), Node.tree(6, null, null));
    }
    return list;
  }
}