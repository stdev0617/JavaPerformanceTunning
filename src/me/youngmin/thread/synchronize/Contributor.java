package me.youngmin.thread.synchronize;

public class Contributor extends Thread {

    private ContributionStatic myContribution;
    private String myName;

    public Contributor(ContributionStatic contribution, String name){
        myContribution=contribution;
        myName = name;
    }
    public void run() {
        for(int loop = 0; loop < 1000; loop++) {
            myContribution.donate();
        }
        System.out.format("%s total=%d\n",myName,myContribution.getTotal());
    }
}
