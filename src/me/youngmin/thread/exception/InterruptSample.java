package me.youngmin.thread.exception;

public class InterruptSample {
    public static void main(String[] args) {
        InfiniteThread infinite = new InfiniteThread();
        infinite.start();
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println("generated exception!");
        }
        System.out.println("isInterrupted="+infinite.isInterrupted());
        infinite.interrupt();
        System.out.println("isInterrupted="+infinite.isInterrupted());
        infinite.setFlag(false); // 무한루프 안돌기 위해서 flag를 false로 변경
    }
}
