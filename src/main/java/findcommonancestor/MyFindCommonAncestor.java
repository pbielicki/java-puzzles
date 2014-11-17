package findcommonancestor;

import java.util.Arrays;

public class MyFindCommonAncestor implements FindCommonAncestor {

  @Override
  public String findCommonAncestor(String[] commitHashes, 
      String[][] parentHashes,
      String commitHash1,
      String commitHash2) {
    
    if (commitHashes == null || parentHashes == null 
        || commitHash1 == null || commitHash2 == null
        || commitHashes.length != parentHashes.length) {
      
      throw new IllegalArgumentException();
    }
    
    if (commitHash1 == commitHash2 || commitHash1.equals(commitHash2)) {
      return commitHash1;
    }
    
    for (int i = 0; i < commitHashes.length; i++) {
      if (commitHash1.equals(commitHashes[i])) {
        commitHash1 = older(commitHashes, i, parentHashes[i]);
      }
      
      if (commitHash2.equals(commitHashes[i])) {
        commitHash2 = older(commitHashes, i, parentHashes[i]);
      }
      
      if (commitHash1 == null || commitHash2 == null) {
        throw new IllegalArgumentException("no common ancestor");
      }
      
      if (commitHash1.equals(commitHash2)) {
        return commitHash1;
      }
    }
    
    throw new IllegalArgumentException("no common ancestor");
  }
  
  /**
   * Is this method needed?
   * 
   *     E-F
   *    /   \
   * A-B-C-D-G
   *         
   * What is a common ancestor for G and F? F or B?
   * This method will return B.
   */
  String older(String[] commitHashes, 
      int idx,
      String[] parentHashes) {
    
    if (parentHashes == null) {
      return null;
    }
    
    if (parentHashes.length == 1) {
      return parentHashes[0];
    }
    
    // start from the oldest
    for (int i = commitHashes.length - 1; i >= idx; i--) {
      if (parentHashes[0].equals(commitHashes[i])) {
        return parentHashes[0];
      }

      if (parentHashes[1].equals(commitHashes[i])) {
        return parentHashes[1];
      }
    }

    throw new IllegalArgumentException("commit(s) '" + Arrays.toString(parentHashes) + "' not found");
  }

}