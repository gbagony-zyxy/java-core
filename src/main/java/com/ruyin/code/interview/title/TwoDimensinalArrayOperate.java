package com.ruyin.code.interview.title;

/**
 *  面试题3：二维数组中的查找
 *
 *  在一个二维数组中每一行按照从左到右递增的顺序排序,每一列按照从上到下的顺序排序。
 *  输入一个二维数组和一个整数,判断数组中是否含有该整数
 */
public class TwoDimensinalArrayOperate {
    //二维数组在内存中占据连续的空间
    //故可使用一维数组保存所有的值,通过行与列来寻址二维数组中的数
    public static boolean findElementInArray(int matrix[],int rows,int columns,int number){
        boolean foundFlag = false;
        //此处使用排过序的二维数组右上角来缩小查找范围
        if(matrix != null && rows > 0 && columns > 0){
            int row = 0;
            int column = columns -1;
            while (row < rows && column >= 0){
                if(matrix[row * columns + column] == number){
                    foundFlag = true;
                    break;
                }
                else if(matrix[row * columns + column] > number)
                    --column;
                else
                    ++row;
            }
        }

        return foundFlag;
    }
}
