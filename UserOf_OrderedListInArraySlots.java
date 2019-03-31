public class UserOf_OrderedListInArraySlots {
  private static OrderedListInArraySlots list;

  public static void main(String[] commandLine) {
    list = new OrderedListInArraySlots();

    System.out.println( "number of elements: " + list.size() );
    System.out.println( "empty list: " + list);
    list.testing(2);

    int elemIndex;
    for( elemIndex = 0; elemIndex < 5; elemIndex++ ) {
        list.addLinear( elemIndex); // differs from index, but similar
        System.out.println( "number of elements: " + list.size() );
    }

    System.out.println("initial population of " + list.size() + " elements:");
    System.out.println( list + System.lineSeparator());
  }
}
