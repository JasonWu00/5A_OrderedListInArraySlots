import java.util.Arrays; //importing Arrays so I can use a useful method

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
  public void add(int value){//to be used by the user
    int position = findProperIndex(elements, value, size());
    add(position, value);
    filledElements++;
  }

  public void testing(int value) {
    System.out.println(findProperIndex(elements, 3, size()));
  }

  private int findProperIndex(int[] array, int value, int currentPosition) {//helper method
    int position = currentPosition;
    int output = currentPosition;
    int newCurrentPosition = 0;
    //int[] frontHalf = Arrays.copyOfRange(array, 0, array.length/2 );
    //int[] backHalf = Arrays.copyOfRange(array, (array.length/2 + 1), array.length);

    //special cases: if array has only 0 or 1 elements
    if (size() == 0)
      output = 0;
    else if (size() == 1) {
      if (array[0] > value)
        output = 0;
      else
        output = 1;
    }
    else {
      int[] frontHalf = Arrays.copyOfRange(array, 0, array.length/2 );
      int[] backHalf = Arrays.copyOfRange(array, array.length/2 +1, array.length);

      if (elements[position] <= value && elements[position+1] >= value) {
        if (elements[position] > value) {
          output = position;
        }
        else {
          output = position + 1;
        }
      }

      else if (elements[position] < value && elements[position+1] < value){ //recursive case
        newCurrentPosition = (int) (output * 0.5);
        output += findProperIndex(frontHalf, value, newCurrentPosition);
      }
      else{
        newCurrentPosition = (int) (output * 0.5);
        output = findProperIndex(backHalf, value, newCurrentPosition);
      }
    }
    return output;
  }

  private void add( int index, int value) { //helper function, cannot be declared by user
    int[] modified = new int[elements.length + 1];
    for(int elemIndex = 0; elemIndex - 1 <= filledElements ; elemIndex++) {
      //loop to fill in new ArrayList with new value at index given
      if (filledElements == elements.length) expand();
      if (elemIndex < index) //when the index is not reached yet
        modified[elemIndex] = elements[elemIndex];
      if (elemIndex == index) { //when index is reached
        modified[elemIndex] = value;
      }
      if (elemIndex > index)//after index reached
        modified[elemIndex] = elements[elemIndex-1];
        //shifts the index over.
    }
    elements = modified;
  }

}
