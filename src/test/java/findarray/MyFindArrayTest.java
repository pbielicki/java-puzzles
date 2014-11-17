package findarray;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyFindArrayTest {

  FindArray fa = new MyFindArray();

  @Test
  public void testFindArray() {
    assertEquals(2, fa.findArray(new int[] { 4, 9, 3, 7, 8 }, new int[] { 3, 7 }));
    assertEquals(0, fa.findArray(new int[] { 1, 3, 5 }, new int[] { 1 }));
    assertEquals(-1, fa.findArray(new int[] { 7, 8, 9 }, new int[] { 8, 9, 10 }));
    assertEquals(2, fa.findArray(new int[] { 4, 9, 3, 7, 3, 7, 3, 7, 8 }, new int[] { 3, 7 }));
    assertEquals(6, fa.findArray(new int[] { 4, 9, 3, 7, 3, 7, 3, 7, 8 }, new int[] { 3, 7, 8 }));
  }

  @Test
  public void testEmptyArray() {
    assertEquals(-1, fa.findArray(new int[0], new int[] { 1, 2 }));
  }
  
  @Test(expected = NullPointerException.class)
  public void testNullArray() {
    assertEquals(-1, fa.findArray(null, new int[] { 1, 2 }));
  }

  @Test(expected = NullPointerException.class)
  public void testNullArrays() {
    assertEquals(-1, fa.findArray(null, null));
  }

  
  @Test
  public void testEmptySubArray() {
    assertEquals(0, fa.findArray(new int[] { 1, 2 }, new int[0]));
  }

  @Test(expected = NullPointerException.class)
  public void testNullSubArray() {
    fa.findArray(new int[] { 1, 2 }, null);
  }

  @Test
  public void testSubArrayLonger() {
    assertEquals(-1, fa.findArray(new int[] { 1 }, new int[] { 1, 2, 3, 4 }));
  }

  @Test
  public void testSameOrEqualArrays() {
    int[] array = new int[] { 1, 2, 3, 4 };
    assertEquals(0, fa.findArray(array, array));
    assertEquals(0, fa.findArray(array, new int[] { 1, 2, 3, 4 }));
    assertEquals(0, fa.findArray(new int[0], new int[0]));
    array = new int[0];
    assertEquals(0, fa.findArray(array, array));
  }
}
