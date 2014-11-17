package findcommonancestor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyFindCommonAncestorTest {
  
  FindCommonAncestor fca = new MyFindCommonAncestor();
  
  /**    E-F
   *    /   \
   * A-B-C-D-G
   */
  String[] hashes1 = {"G", "F", "E", "D", "C", "B", "A"};
  String[][] parents1 = {{"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null};

  /**    E-F
   *    /   \
   * A-B-C-D-G-------K
   *      \         /
   *       X---Y---Z
   *        \     /
   *         Q-P-R
   */
  String[] hashes2 = {"K", "R", "P", "Q", "Z", "Y", "X", "G", "F", "E", "D", "C", "B", "A"};
  String[][] parents2 = {{"G", "Z"}, {"P"}, {"Q"}, {"X"}, {"R", "Y"}, {"X"}, {"C"}, {"F","D"},{"E"}, {"B"}, {"C"}, {"B"}, {"A"}, null};

  /**    
   * A-B-C-D-E
   */
  String[] hashes3 = {"E", "D", "C", "B", "A"};
  String[][] parents3 = {{"D"},{"C"}, {"B"}, {"A"}, null};

  
  
  @Test
  public void testFindCommonAncestor() {
    assertEquals("B", fca.findCommonAncestor(hashes1, parents1, "D", "F"));
    assertEquals("B", fca.findCommonAncestor(hashes1, parents1, "F", "D"));
    assertEquals("B", fca.findCommonAncestor(hashes1, parents1, "C", "E"));
    assertEquals("B", fca.findCommonAncestor(hashes1, parents1, "E", "C"));

    assertEquals("B", fca.findCommonAncestor(hashes1, parents1, "C", "B"));
    assertEquals("B", fca.findCommonAncestor(hashes1, parents1, "G", "E"));
    assertEquals("B", fca.findCommonAncestor(hashes1, parents1, "G", "F"));

    assertEquals("X", fca.findCommonAncestor(hashes2, parents2, "Y", "P"));
    assertEquals("C", fca.findCommonAncestor(hashes2, parents2, "K", "P"));
    assertEquals("G", fca.findCommonAncestor(hashes2, parents2, "K", "G"));
    assertEquals("D", fca.findCommonAncestor(hashes2, parents2, "K", "D"));
    assertEquals("B", fca.findCommonAncestor(hashes2, parents2, "K", "F"));
    assertEquals("C", fca.findCommonAncestor(hashes2, parents2, "K", "Y"));
    assertEquals("C", fca.findCommonAncestor(hashes2, parents2, "Z", "G"));
    assertEquals("B", fca.findCommonAncestor(hashes2, parents2, "R", "F"));
    assertEquals("B", fca.findCommonAncestor(hashes2, parents2, "B", "Z"));

    assertEquals("C", fca.findCommonAncestor(hashes3, parents3, "D", "C"));

    assertEquals("A", fca.findCommonAncestor(hashes3, parents3, "A", "B"));
    assertEquals("A", fca.findCommonAncestor(hashes3, parents3, "A", "A"));
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testNoCommonAncestor() {
    assertEquals("A", fca.findCommonAncestor(hashes3, parents3, "A", "WW"));
  }
}
