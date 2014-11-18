package flatten;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import flatten.Tree.Node;

public class MyFlattenTreeTest {

  FlattenTree<Object> flatten = new MyFlattenTree<>();
  
  @Test
  public void testFlattenInOrder() {
    Tree<Object> tree = Node.tree(1, Node.tree(5, 4, 9), 6);
    assertThat(flatten.flattenInOrder(tree), is(equalTo(Arrays.asList(1, 5, 4, 9, 6))));
    
    tree = new Node<>(Node.tree(1, null, null), Node.tree(5, 4, 9), Node.tree(6, null, null));
    assertThat(flatten.flattenInOrder(tree), is(equalTo(Arrays.asList(1, 5, 4, 9, 6))));
  }

}
