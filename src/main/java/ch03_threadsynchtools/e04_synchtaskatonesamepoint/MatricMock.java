package ch03_threadsynchtools.e04_synchtaskatonesamepoint;

import java.util.Random;

/**
 * Created by Hank on 2015/4/1.
 */
public class MatricMock {
    private int[][] data;

    /**
     *
     * @param size 矩阵行数
     * @param length 每行长度
     * @param number 要查找的数字
     */
    public MatricMock(int size, int length, int number){
        int counter = 0;
        data = new int[size][length];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for(int j = 0; j < length; j++){
                data[i][j] = random.nextInt(10);
                if(data[i][j] == number){
                    counter ++;
                }
            }
        }

        System.out.printf("Mock: There are %d ocurrences of number in generated data\n", counter, number);
    }

    public int[] getRow(int row){
        if((row >= 0) && (row < data.length)){
            return data[row];
        }

        return null;
    }
}
