package iteration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.Test;

public class MyFolderTest {

  Folder<String, Integer> folder = new MyFolder<>();

  @Test
  public void testFold() {
    Queue<String> queue = new ArrayDeque<String>();
    queue.offer("1234");
    queue.offer("12345");
    queue.offer("123456");
    queue.offer("1234567");
    queue.offer("123456789");

    assertThat(folder.fold(0, queue, (t, u) -> u + t.length()), is(equalTo(31)));
  }

}
