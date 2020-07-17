package test.lang;

public class TestThread {
    public static void main(String[] args) {
//        Thread thread = new Thread(new MyThread(), "Thread-A");
//        thread.start();
        System.out.println(System.currentTimeMillis());
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("我是" + Thread.currentThread().getName());
    }
}
