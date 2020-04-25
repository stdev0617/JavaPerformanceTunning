package me.youngmin.thread.synchronize;

public class Contribution {
    private int amount=0;
    //public void donate() {
    public synchronized void donate() {
        amount++;
    }
    public int getTotal() {
        return amount;
    }
}
