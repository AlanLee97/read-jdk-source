package test.lang;

public class TestString {
    public static void main(String[] args) {
        String str = new String("abc");
        String str4 = new String("abc");
        String str2 = "abc";
        String str3 = "abc";
        System.out.println(str.length());
        System.out.println(str.hashCode());
        System.out.println(str.indexOf('a'));
        System.out.println(str.equals(str2));
        System.out.println(str2 == str3);
        System.out.println(str == str4);

    }
}
