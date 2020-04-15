package me.youngmin.thread.exception;

public class InfiniteThread extends Thread {

    int value = Integer.MIN_VALUE;
    private boolean flag = true;

    public void run() {
        while(flag) {
            value++;
            if(value==Integer.MAX_VALUE) {
                value = Integer.MIN_VALUE;
                System.out.println("MAX_VALUE reached !!!");
            }
            try {
                Thread.sleep(0,1);
            } catch (Exception e) {
                break;
            }
        }
    }
    public void setFlag(boolean flag) { // 무한루프를 안돌기 위해서 이 메서드 추가
        this.flag = flag;
    }
}
