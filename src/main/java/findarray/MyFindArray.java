package findarray;

import java.util.Arrays;

public class MyFindArray implements FindArray {

  @Override
  public int findArray(int[] array, int[] subArray) {
    if (array == null) {
      throw new NullPointerException("array is null");
    }

    if (subArray == null) {
      throw new NullPointerException("subArray is null");
    }
    
    if (array == subArray 
        || subArray.length == 0
        || Arrays.equals(array, subArray)) {
      return 0;
    }
    
    if (array.length < subArray.length) {
      return -1;
    }
    
    for (int i = 0; i < array.length; i++) {
      main:
      if (array[i] == subArray[0]) {
        for (int subIdx = 1; subIdx < subArray.length; subIdx++) {
          if (i + subIdx > (array.length - 1) 
              || array[i + subIdx] != subArray[subIdx]) {
            break main;
          }
        }
        return i;
      }
    }
    
    return -1;
  }

}
