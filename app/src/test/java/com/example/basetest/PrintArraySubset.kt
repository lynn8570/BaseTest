package com.example.basetest

import org.junit.Test

class PrintArraySubset {


    @Test
    fun printArray() {
        val testArray = intArrayOf(1, 2, 3, 4)
        val result = subSet(testArray)
        result.forEach {
            printArray(it)
        }
    }


    //从前往后遍历, 遇到一个数, 之前的所有集合添加上这个数组成新的子集.
    fun subSet(nums: IntArray): MutableList<IntArray> {
        val res = mutableListOf<IntArray>()
        if (nums.isEmpty()) return res
        res.add(intArrayOf()) //添加一个空的集合
        for (i in nums.indices) {
            var size = res.size
            for (j in 0 until size) {
                var array = res[j].toMutableList() //之前的集合
                array.add(nums[i]) //加上新的这个数
                res.add(array.toIntArray()) //组合成新的集合，追加到尾部
            }

        }
        return res
    }

    fun printArray(nums: IntArray) {
        print("[")
        nums.forEach {
            print("${it} ")
        }
        print("],")
    }

}