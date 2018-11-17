package model;

public class PaintHouse {

    private static int paint(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        } 
        if (costs.length == 1){
            return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);

        } else {
            for (int i = 1; i < costs.length; i++) {
                costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
                costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
                costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
            }
            return Math.min(Math.min(costs[costs.length-1][0], costs[costs.length-1][1]), costs[costs.length-1][2]);
        }
    }

    public static void main(String[] args) {
        int[] h1 = new int[] {17, 2, 17};
        int[] h2 = new int[] {16, 16, 5};
        int[] h3 = new int[] {14, 3, 19};
        int[][] costs1 = new int[][] {h1, h2, h3};

        System.out.println(paint(costs1));

        int[] h11 = new int[] {2, 4, 6};
        int[] h21 = new int[] {2, 5, 7};
        int[] h31 = new int[] {4, 5, 7};
        int[][] costs2 = new int[][] {h11, h21, h31};

        System.out.println(paint(costs2));

        int[] h13 = new int[] {1, 2, 3};
        int[][] costs3 = new int[][] {h13};
        System.out.println(paint(costs3));

        int[] h14 = new int[] {2, 3, 4};
        int[] h24 = new int[] {3, 2, 4};
        int[][] costs4 = new int[][] {h14, h24};
        System.out.println(paint(costs4));

        int[] h15 = new int[] {2, 3, 4};
        int[] h25 = new int[] {3, 2, 4};
        int[] h35 = new int[] {3, 2, 4};
        int[][] costs5 = new int[][] {h15, h25, h35};
        System.out.println(paint(costs5));

        int[] h16 = new int[] {3, 5, 3};
        int[] h26 = new int[] {6, 17, 6};
        int[] h36 = new int[] {7, 13, 18};
        int[] h46 = new int[] {9, 10, 18};
        int[][] costs6 = new int[][] {h16, h26, h36, h46};
        System.out.println(paint(costs6));

        int[] h17 = new int[] {5, 8, 6};
        int[] h27 = new int[] {19, 14, 13};
        int[] h37 = new int[] {7, 5, 12};
        int[] h47 = new int[] {14, 15, 17};
        int[] h57 = new int[] {3, 20, 10};
        int[][] costs7 = new int[][] {h17, h27, h37, h47, h57};
        System.out.println(paint(costs7));
    }
}
