package me.youngmin.thread.synchronize;

public class ContributeTest {
    public static void main(String[] args) {
        Contributor[] crs = new Contributor[10];
//        Contribution group = new Contribution();
        // 기부자와 기부단체 초기화
        for(int loop=0; loop<10; loop++){
            ContributionStatic group = new ContributionStatic();
            crs[loop] = new Contributor(group, " Contributor"+loop);
        }
        //기부 실행
        for(int loop=0; loop<10; loop++) {
            crs[loop].start();
        }
    }
}
