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

    public static int climbStairsAlt(int n) {
        int[] steps = new int[n+1];

        steps[1] = 1;
        steps[0] = 1;

        for (int i = 2 ; i <= n; i++) {
            if (i - 1 >=0) {
                steps[i] += steps[i - 1];
            }
            if (i - 2 >= 0) {
                steps[i] += steps[i - 2];
            }

        }
        return steps[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairsAlt(2));
        System.out.println(climbStairsAlt(3));
        System.out.println(climbStairsAlt(4));
        System.out.println(climbStairsAlt(5));
        System.out.println(climbStairsAlt(6));
        
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(6));
    }
}