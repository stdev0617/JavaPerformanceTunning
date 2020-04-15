package me.youngmin.thread.sleep;

public class Application {
    public static void main(String[] args) {
        Sleep s = new Sleep();
        s.start();
        try{
            int cnt=0;
            while(cnt<5) {
                s.join(1000); // 1초씩 기다린다.
                cnt++;
                System.out.format("%d second waited\n", cnt);
            }
            if(s.isAlive()) { // 스레드가 살아있는지 확인한다.
                s.interrupt();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
