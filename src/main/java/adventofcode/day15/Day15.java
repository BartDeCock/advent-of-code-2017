package adventofcode.day15;

import static java.lang.Long.toBinaryString;

public class Day15 {

    private static final int FACTOR_A = 16807;
    private static final int FACTOR_B = 48271;
    private static final int DIVIDOR = 2147483647;
    private static final int MOD_A = 4;
    private static final int MOD_B = 8;
    private int count;
    private long valueA;
    private long valueB;

    int calculatePart1(int startA, int startB) {
        count = 0;
        valueA = startA * FACTOR_A % DIVIDOR;
        valueB = startB * FACTOR_B % DIVIDOR;

        String lastA = getLast16(valueA);
        String lastB = getLast16(valueB);
        if (lastA.equals(lastB)) count++;

        for (int i = 1; i < 40000000; i++) {
            valueA = valueA * FACTOR_A % DIVIDOR;
            valueB = valueB * FACTOR_B % DIVIDOR;

            lastA = getLast16(valueA);
            lastB = getLast16(valueB);
            if (lastA.equals(lastB)) count++;
        }
        return count;
    }

    int calculatePart2(int startA, int startB) {
        count = 0;
        valueA = getValue(startA, FACTOR_A, MOD_A);
        valueB = getValue(startB, FACTOR_B, MOD_B);

        String lastA = getLast16(valueA);
        String lastB = getLast16(valueB);
        if (lastA.equals(lastB)) count++;

        for (int i = 1; i < 5000000; i++) {
            valueA = getValue(valueA, FACTOR_A, MOD_A);
            valueB = getValue(valueB, FACTOR_B, MOD_B);

            lastA = getLast16(valueA);
            lastB = getLast16(valueB);
            if (lastA.equals(lastB)) count++;
        }
        return count;
    }

    private String getLast16(long val) {
        String binaryString = toBinaryString(val);
        while (binaryString.length() < 16) binaryString = "0" + binaryString;
        return binaryString.substring(binaryString.length() - 16);
    }

    private long getValue(long val, int factor, int mod) {
        long result = val * factor % DIVIDOR;
        if (result % mod != 0) {
            return getValue(result, factor, mod);
        } else {
            return result;
        }
    }
}
