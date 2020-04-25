package me.youngmin.thread.sleep;

public class Sleep extends Thread {

    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Somebody stopped me T T");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
