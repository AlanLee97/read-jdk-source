package test.lang;

public class TestObject {
    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println(obj.toString());

        System.out.println(obj.getClass());
        System.out.println(obj.equals(obj));
        System.out.println(obj.hashCode());

    }



}
