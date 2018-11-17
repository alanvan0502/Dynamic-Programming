package model;

import java.util.Scanner;

public class EditDistanceSubmit {
    
    public static int EditDistance(String s, String t) {
        char[] A = s.toCharArray();
        char[] B = t.toCharArray();
        int[][] D = new int[A.length + 1][B.length + 1];
        for (int i = 0; i <= A.length; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j <= B.length; j++) {
            D[0][j] = j;
        }
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                int insertion = D[i][j - 1] + 1;
                int deletion = D[i - 1][j] + 1;
                int match = D[i - 1][j - 1];
                int mismatch = D[i - 1][j - 1] + 1; // +1 if symbol replacing is allowed
                // +2 if symbol replace is NOT allowed

                if (A[i-1] == B[j-1])
                    D[i][j] = Math.min(Math.min(insertion, deletion), match);
                else
                    D[i][j] = Math.min(Math.min(insertion, deletion), mismatch);
            }
        }
        return D[A.length][B.length];
    }
 
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }
}
