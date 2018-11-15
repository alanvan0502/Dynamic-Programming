package model;

public class ClimbingStairs {

    public static int climbStairs(int n) {
        int[] stepLens = new int[] {1, 2};
        int[] steps = new int[n+1];

        steps[1] = 1;
        steps[0] = 1;

        for (int i = 2 ; i <= n; i++) {
            for (int stepLen: stepLens) {
                if (i - stepLen >=0) {
                    steps[i] += steps[i - stepLen];
                }
            }
        }
        return steps[n];
    }

    public static void main(String[] args) {
        //        System.out.println(climbStairs(2));
        //        System.out.println(climbStairs(3));
                System.out.println(climbStairs(4));
        //        System.out.println(climbStairs(5));
        //        System.out.println(climbStairs(6));
    }
}