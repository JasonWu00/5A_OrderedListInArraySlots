public class OrderedListInArraySlots {
  private int[] elements;     // container for the elements of the list
  private int filledElements; // the number of elements in this list

  private static final int INITIAL_CAPACITY = 10;

  public OrderedListInArraySlots(){
    elements = new int[INITIAL_CAPACITY];
  }

  public int size() {
      return filledElements;
  }

  public String toString() {
      String result = "[";
      for( int elemIndex = 0; elemIndex < filledElements; elemIndex++)
          result += elements[ elemIndex] + ",";
      return result + "]";
  }

  public int returnElement(int index) {
    return elements[index];
  }

  private void expand() {
     System.out.println( "expand... (for debugging)");
        /* S.O.P. rules for debugging:
           Working methods should be silent. But during
           development, the programmer must verify that
           this method is called when that is appropriate.
           So test using the println(), then comment it out.
           */
     int[] bigger = new int[ elements.length * 2];
     for( int elemIndex = 0; elemIndex < filledElements; elemIndex++)
         bigger[ elemIndex] = elements[ elemIndex];
     elements = bigger;
  }

  public int get( int index ) {
    return elements[index];
  }

  public int remove( int index) {
    //The idea is similar with the add(index, value) method
    //except we skip a number instead of add a number.
    int removed = elements[index];
    int[] modified = new int[elements.length - 1];
    for(int elemIndex = 0; elemIndex - 1 <= filledElements ; elemIndex++) {
      if (elemIndex < index)
        modified[elemIndex] = elements[elemIndex];
      if (elemIndex >= index)
        modified[elemIndex] = elements[elemIndex+1];

    }
    filledElements --;
    elements = modified;
    return removed;
  }
}
