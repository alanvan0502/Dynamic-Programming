package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
      String[] numArr = exp.split("[-+*]");
      long[] nums = new long[numArr.length];
      for (int i = 0; i < nums.length; i++) {
          nums[i] = Long.parseLong(numArr[i]);
      }
      
      String[] opArr = exp.split("[0-9]");
      List<Character> opList = new ArrayList<>();
      for (String o: opArr) {
          if (o.length() != 0) {
              opList.add(o.charAt(0));
          }
      }
      
      char[] ops = new char[opList.size()];
      for (int i = 0; i < opList.size(); i++) {
          ops[i] = opList.get(i);
      }
      
      long[][] m = new long[nums.length+1][nums.length+1];
      long[][] M = new long[nums.length+1][nums.length+1];
      
      for (int i = 1; i <= nums.length; i++) {
          m[i][i] = nums[i-1];
          M[i][i] = nums[i-1];
      }
      
      for (int s = 1; s <= nums.length - 1; s++) {
          for (int i = 1; i <= nums.length - s; i++) {
              int j = i + s;
              long[] minMax = minAndMax(M, m, i, j, ops);
              m[i][j] = minMax[0];
              M[i][j] = minMax[1];
          }
      }
      
      return M[1][nums.length];
    }
    
    private static long[] minAndMax(long[][] M, long[][]m, int i, int j, char[] ops) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int k = i; k <= j-1; k++) {
            long a = eval(M[i][k], M[k+1][j], ops[k-1]);
            long b = eval(M[i][k], m[k+1][j], ops[k-1]);
            long c = eval(m[i][k], M[k+1][j], ops[k-1]);
            long d = eval(m[i][k], m[k+1][j], ops[k-1]);
            min = Math.min(Math.min(Math.min(Math.min(min, a), b), c), d);
            max = Math.max(Math.max(Math.max(Math.max(max, a), b), c), d);
        }
        return new long[] {min, max};
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}
