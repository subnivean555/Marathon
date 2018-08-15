package leetcode.arr;

/**
 * 将图像顺时针旋转 90 度。
 *
 *  方法 1 :
 *      将 行 上下对称交换, 之后将矩阵转置即可
 *      同理, 逆时针旋转时, 将 列 左右对称交换, 之后转置即可
 *
 *  方法 2 :
 *      每次交换四个点
 */
public class Basic_RotateImage {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++){
            for (int j = 0; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - i - 1][j];
                matrix[matrix.length - i - 1][j] = temp;
            }
        }

        for (int i = 0 ; i < matrix.length / 2; i++){
            for (int j = i + 1; j < matrix[i].length / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void rotate2(int[][] matrix){
        int n = matrix.length;
        for (int i = 0; i < n / 2 ; i++){
            for (int j = i; j < n -1 - i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 -i][n - 1 - j];
                matrix[n - 1 -i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
