package me.youngmin.thread.synchronize;

public class ContributionStatic {
    private static int amount=0;
    public void donate(){
        amount++;
    }
    public int getTotal(){
        return amount;
    }
}
