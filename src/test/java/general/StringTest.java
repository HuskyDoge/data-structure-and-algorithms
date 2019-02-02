package general;

/**
 * @author Jialun Li on 19/09/2018
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = s1;
        String s3 = new String("abc3");

        System.out.println(s1);
        s1 = s3;

        System.out.println(s2);


    }
}
