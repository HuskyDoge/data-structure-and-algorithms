/**
 * @author Jialun Li on 2019-02-23
 */
public class Scratch {
    public static void main(String[] args) {
        System.out.println(true ^ false);
        System.out.println(true ^ true);
        System.out.println(false ^ false);
        System.out.println(false ^ true);


        int key = 54969038;
        int cipher = 1469821 ^ key;
        System.out.println(cipher ^ key);


        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(25));


        System.out.println(101 ^ 11001);

        System.out.println(Integer.toBinaryString(28));

        System.out.println(Math.pow(2, 32) / 2); // int 一个32种
        System.out.println(Integer.MAX_VALUE);
        System.out.println(1 << 30);
    }
}
