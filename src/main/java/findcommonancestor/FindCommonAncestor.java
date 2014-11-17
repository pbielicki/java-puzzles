package findcommonancestor;

public interface FindCommonAncestor {
  String findCommonAncestor(String[] commitHashes, String[][] parentHashes, String commitHash1, String commitHash2);
}
