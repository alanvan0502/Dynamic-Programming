package tests;

import org.junit.jupiter.api.Test;

import model.CoinChange;

import static org.junit.Assert.*;

public class TestCoinChange {
    
//    @Test
//    public void testRecursiveChange() {
//        int min = CoinChange.recursiveChange(9, new int[] {3, 4, 8});
//        System.out.println(min);
//    }
    
    @Test
    public void testDPChange() {
        int min = CoinChange.dpChange(32, new int[] {1, 8, 20});
        System.out.println(min);
    }
}
