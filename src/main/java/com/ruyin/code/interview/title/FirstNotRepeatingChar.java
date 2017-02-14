package com.ruyin.code.interview.title;

/**
 *  面试题35：第一个只出现一次的字符
 *
 *  解决这个问题我们可以定义哈希表的键值(Key)是字符,而值(Value)是该字符出现的次数.
 *  我们需要从头开始扫描字符串两次：第一次扫描字符串时，每扫描到一个字符就在哈希表的对应项中把次数加1，
 *  接下来第二次扫描时,每扫描到一个字符就能从哈希表中的到该字符出现的次数.如此得解
 */
public class FirstNotRepeatingChar {

    public static char firstNotRepeatingChar(String str){
        if(str == null || str.equals(""))
            return '\0';
        //定义数组的大小,因为char类型长度为8,故其有256中可能
        int tableSize = 256;
        //自动将hashTable数组初始化为0
        int hashTable[] = new int[tableSize];

        char hashKey[] = str.toCharArray();
        //统计hashTable中字符命中字数
        for(int i = 0 ; i< hashKey.length ; i++){
            if(hashKey[i] != '\0')
                hashTable[hashKey[i]]++;
        }


        //此时hashTable的下标变成了char类型的ASCII字码表中的字符
        for(int j = 0; j < hashKey.length ; j ++){
            if(hashTable[hashKey[j]] == 1){
                System.out.println(hashKey[j]);
                return hashKey[j];
            }
        }

        //Arrays.stream(hashTable).forEach(s -> System.out.print(s));

        return '\0';
    }
}
