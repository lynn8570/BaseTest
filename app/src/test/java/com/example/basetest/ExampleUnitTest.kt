package com.example.basetest

import android.util.Log
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    /**
     * 排序，输入 nums
     */
    @Test
    fun sortArray() {
        var nums = intArrayOf(1, 45, 22, 67, 89, 100, 2, 34, 56, 78, 99)
        quickSort(nums, 0, nums.size - 1)
        nums.forEach {
            print("排序结果：$it ")
        }
    }


    /**
     * 递归分治的思想
     */
    fun mergeSort(nums: IntArray, bgn: Int, end: Int) {
        //从中间，分两组
        if (bgn >= end) return
        val mid = (bgn + end) / 2
        Log.i("linlian", "bgn=$bgn，end=$end mid=$mid")
        mergeSort(nums, bgn, mid)
        mergeSort(nums, mid + 1, end)
        mergeSortInOrder(nums, bgn, mid, end)


    }

    fun mergeSortInOrder(nums: IntArray, bgn: Int, mid: Int, end: Int) {

    }


    /**
     * 其思想是：先选一个“标尺”，用它把整个队列过一遍筛子，以保证：其左边的元素都不大于它，其右边的元素都不小于它。
     * 这样，排序问题就被分割为两个子区间。
     * 再分别对子区间排序就可以了。
     */
    fun quickSort(nums: IntArray, low: Int, high: Int): IntArray {
        if (low < high) { //区间至少有两个数
            var baseP = partion(nums, low, high)
            quickSort(nums, low, baseP - 1)
            quickSort(nums, baseP + 1, high)
        }
        return nums
    }


    /**
     * 找一个基准，将小于它的放左边，大于他的放右边
     */
    fun partion(a: IntArray, low: Int, high: Int): Int {
        var lowP = low
        var highP = high
        val baseP = a[lowP] //选第一个当基准
        println("low=$lowP,high=$highP ,base=${baseP}")
        while (lowP < highP) {

            //从右边开始，找比基准小的数
            while (lowP < highP && a[highP] >= baseP) {
                --highP
                println("向前挪 $highP")
            }

            if (lowP < highP) {
                //如果找到比基准小的,放到low的位置
                println("找到比$baseP 小的右边的数 ${a[highP]},和 ${a[lowP]} ")
                a[lowP] = a[highP]
            } //a[highP]比基准小，所以放到lowp的位置
            //这个时候，highP位置就空了，我们从左边开始扫描，找比基准


            while (lowP < highP && a[lowP] <= baseP) {
                ++lowP
                println("向后挪 $highP")
            }

            if (lowP < highP) {
                //找到比基准大的数了，放到highp的位置
                println("找到比$baseP 小的右边的数 ${a[highP]},和 ${a[lowP]} ")
                a[highP] = a[lowP]
            }
        }
        a[lowP] = baseP //最后指针重合的地方，就是放基准的地方，这样，基准左边的都小于基准，右边的都大于基准
        println("找到基准 $baseP 存放的位置 $lowP ")
        return lowP //返回基准的指针位置
    }

    /**
     * 将 A 数据的 i和j位置的内容交互下
     */
    fun swap(a: IntArray, i: Int, j: Int) {
        if (a.size > i && a.size > j) {//防止数据越界
            val temp = a[i]
            a[i] = a[j]
            a[j] = temp
            return
        }
        println("array size${a.size} i=$i,j=$j")
    }

}