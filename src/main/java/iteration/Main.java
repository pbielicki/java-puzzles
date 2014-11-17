package iteration;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Folder<String, Integer> fold = new MyFolder<String, Integer>();
    
    Queue<String> queue = new ArrayDeque<String>();
    queue.offer("dupa");
    queue.offer("dupa1");
    queue.offer("dupa21");
    queue.offer("dupa234");
    queue.offer("dupa12666");

    System.out.println(fold.fold(1, queue, new Function2<String, Integer, Integer>() {
      @Override
      public Integer apply(String t, Integer u) {
        return u + t.length();
      }
    }));
    
  }

}
