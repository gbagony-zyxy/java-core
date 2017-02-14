package com.ruyin.code.interview.title;

/**
 *  面试题4：替换空格
 *
 *  网络编程中需要将空格替换成%20,此时会造成多出两位,此时是选择遇到空格将其后的部分都后移2位还是...这样时间复杂度位O(n*n)
 *  我们可以首先遍历一遍字符串,统计出总共有多少个空格,据此就可以确定转换所需要的字符串大小,第二遍就是将字符转和转换后的空格加入新的字符串中
 */
public class StringOperate {

    public static void replaceBlank(String str){
        if(str == null)
            return;

        int numberOfBlank = 0;
        int i=0;
        char strArr[] = str.toCharArray();

        while (i < str.length()){
            if(strArr[i] == ' ')
                ++numberOfBlank;
            ++i;
        }

        int newLength = str.length() + numberOfBlank*2;
        int indexOfOriginal = str.length();
        int indexOfNew = newLength;
        char newArr[] = new char[newLength];
        for(int k = 0 ; k< strArr.length;k++){
            newArr[k] = strArr[k];
        }

        while (indexOfOriginal >=0 && indexOfNew > indexOfOriginal){
            if(newArr[indexOfOriginal] == ' '){
                newArr[indexOfNew--] = '0';
                newArr[indexOfNew--] = '2';
                newArr[indexOfNew--] = '%';
            }
            else{
                newArr[indexOfNew--] = newArr[indexOfOriginal];
            }
            --indexOfOriginal;
        }

        for (int  j =0 ; j < strArr.length ; j ++){
            System.out.print(strArr[j]);
        }

    }

    public static String replaceBlank1(String str){
        if(str == null)
            return "";
        String phrase[] =  str.split(" ");
        String finalStr = "";
        for (int i=0 ; i < phrase.length-1 ; i++){
            finalStr+= phrase[i] + "%20";
        }
        return finalStr + phrase[phrase.length-1];
    }
}
