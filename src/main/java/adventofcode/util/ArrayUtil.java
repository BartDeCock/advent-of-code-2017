package adventofcode.util;

public class ArrayUtil {
    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.print("\n");
    }

    public static void printDoubleArray(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for(int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j] + ",");
            }
        System.out.print("\n");
        }
        System.out.print("\n");
    }

}
