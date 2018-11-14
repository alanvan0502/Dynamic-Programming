package model;

import java.util.Scanner;

public class CoinChange {
    
    public static int recursiveChange(int money, int[] coins) {
        if (money == 0) {
            return 0;
        }
        int minNumCoins = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (money >= coins[i]) {
                int numCoins = recursiveChange(money - coins[i], coins);
                if (numCoins + 1 < minNumCoins && numCoins != Integer.MAX_VALUE) {
                    minNumCoins = numCoins + 1;
                }
            }
        }         
        return minNumCoins;
    }
    
    public static int dpChange(int amount, int[] coins) {

        int[] minNumCoins = new int[amount + 1];
        
        for (int i = 1; i <= amount; i++)
            minNumCoins[i] = Integer.MAX_VALUE;
        
        for (int i = 0; i <= amount; i++) {
            for (int coin: coins) {
                if (i + coin <= amount) {
                    if (minNumCoins[i] != Integer.MAX_VALUE) {
                        minNumCoins[i + coin] = Math.min(minNumCoins[i+coin], minNumCoins[i] + 1);
                    }    
                }
            }
        }
        return minNumCoins[amount];
    }
    
    public static int getChange(int m) {
        return getChangeHelp(m, new int[] {1, 3, 4});
    }

    private static int getChangeHelp(int m, int[] coins) {
        int[] count = new int[m+1];
        count[0] = 0;
        for (int i = 1; i < count.length; i++) {
            count[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < count.length; i++) {
            for (int coin: coins) {
                if (i + coin <= m && count[i] != Integer.MAX_VALUE) {
                        if (count[i] != Integer.MAX_VALUE)
                            count[i+coin] = Math.min(count[i]+1, count[i+coin]);
                }
            }          
        }
        
        return count[m];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}