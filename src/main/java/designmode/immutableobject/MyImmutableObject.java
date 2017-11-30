package designmode.immutableobject;

/**
 * @author Jialun Li on 30/11/2017
 */
public class MyImmutableObject {
    private final int[] myArray;
    public MyImmutableObject(int[] anArray) {
      this.myArray = anArray.clone(); // Right
//        this.myArray = anArray; // Wrong
    }
    public String toString() {
        StringBuffer sb = new StringBuffer("Numbers are: ");
        for (int i = 0; i < myArray.length; i++) {
            sb.append(myArray[i] + " ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] array = {1,2};
        MyImmutableObject myImmutableRef = new MyImmutableObject(array) ;
        System.out.println("Before constructing " + myImmutableRef);
        array[1] = 5; // change (i.e. mutate) the element
        System.out.println("After constructing " + myImmutableRef);
//        myImmutableRef.myArray = new int[10]; 如果用了final就无法赋值。
//        System.out.println("after assign values " + myImmutableRef);
    }
}
