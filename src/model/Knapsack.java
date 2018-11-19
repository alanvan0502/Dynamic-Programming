package model;

import java.util.Scanner;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        
        int[][] V = new int[w.length + 1][W + 1];
        for (int i = 0; i <= w.length; i++) {
            V[i][0] = 0;
        }
        for (int j = 0; j <= W; j++) {
            V[0][j] = 0;
        }

        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= W; j++) {
                V[i][j] = V[i - 1][j];
                if (w[i - 1] <= j) {
                    int val = V[i - 1][j - w[i - 1]] + w[i - 1];
                    if (V[i][j] < val)
                        V[i][j] = val;
                }
            }
        }

        return V[w.length][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}


