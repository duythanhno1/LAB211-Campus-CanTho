package JL.P0023;

/**
 *
 * @author Duy Thanh
 */
public class GetMatrix {

    /**
     * Function get matrix input colum and row
     * duyệt các phần tử trong matrix
     * @param mess show title colum and row
     * @param column user input
     * @param row user input
     * @return matrix [][] get input 
     */
    public static int[][] getMatrix(String mess, int column, int row) {
        int matrix[][] = new int[row][column];
        // loop until the last index in row
        for (int i = 0; i < row; i++) {
            // loop until the last index in column
            for (int j = 0; j < column; j++) {
                matrix[i][j] = GetInput.getInputMatrix(mess+"[" + (i + 1) + "][" + (j + 1) + "]:");
            }
        }
        return matrix;
    }
}