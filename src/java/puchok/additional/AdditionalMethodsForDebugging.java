package puchok.additional;

/**
 * User: Puchok
 * Date: 08.06.12
 * Time: 14:04
 */
public class AdditionalMethodsForDebugging {
    //Prints 2d double array into console
    public static void print2DimensionalArray(double[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }

    //Prints 2d double array into console
    public static void print2DimensionalArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }
}
