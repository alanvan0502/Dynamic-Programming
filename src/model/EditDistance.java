package model;

public class EditDistance {
    
    /**
     * Find the minimum edit distance from String A to String B
     * @param A
     * @param B
     * @return
     */
    private static int editDistance(char[] A, char[] B) {
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
                // +Integer.Max_VALUE if symbol replace is NOT allowed
                
                if (A[i-1] == B[j-1])
                    D[i][j] = Math.min(Math.min(insertion, deletion), match);
                else
                    D[i][j] = Math.min(Math.min(insertion, deletion), mismatch);
            }
        }
        return D[A.length][B.length];
    }
    
    private static void outputAlignment(char[] A, char[] B, int[][] D, int i, int j) {
        if (i == 0 && j == 0) {
            return;
        }
        if (i > 0 && D[i][j] == D[i-1][j] + 1) {
            outputAlignment(A, B, D, i-1, j);
            System.out.print(A[i-1]);
            System.out.println();
            System.out.print("-");
        } else if (j > 0 && D[i][j] == D[i][j-1] + 1) {
            outputAlignment(A, B, D, i, j-1);
            System.out.print("-");
            System.out.println();
            System.out.print(B[j-1]);
        } else {
            outputAlignment(A, B, D, i-1, j-1);
            System.out.print(A[i-1]);
            System.out.print(B[j-1]);
        }
    }

    public static void main(String[] args) {
        char[] bread = new char[] {'b','r','e','a','d'};
        char[] really = new char[] {'r','e','a','l','l','y'};

        int d1 = editDistance(bread, really);
        System.out.println(d1);
    }
}
