package model;
import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence_naive(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }
    
    private static List<Integer> optimalSequence(int n){
        
        List<Integer> sequence = new ArrayList<>();
        int[] seq = new int[n+1];
        
        int[] count = new int[n+1];
        count[0] = 0;
        count[1] = 0;
        for (int i = 2; i < count.length; i++) {
            count[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 1; i <= n; i++) {
            if (count[i] != Integer.MAX_VALUE) {
                if (i * 3 <= n) {
                    if (count[i] + 1 <= count[i * 3]) {
                        seq[i * 3] = 3;
                        count[i * 3] = count[i] + 1;
                    }
                }
                if (i * 2 <= n) {
                    if (count[i] + 1 <= count[i * 2]) {
                        seq[i * 2] = 2;
                        count[i * 2] = count[i] + 1;
                    }
                }
                if (i + 1 <= n) {
                    if (count[i] + 1 <= count[i + 1]) {
                        seq[i + 1] = 1;
                        count[i + 1] = count[i] + 1;
                    }
                }
            }
        }
        int total = n;
        sequence.add(total);
        while (total > 1) {
            if (seq[total] == 1) {
                total -= 1;
                sequence.add(total);
            }
            if (seq[total] == 2) {
                total /= 2;
                sequence.add(total);
            }
            if (seq[total] == 3) {
                total /= 3;
                sequence.add(total);
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimalSequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

