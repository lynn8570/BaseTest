package com.example.basetest

import android.util.Log
import org.junit.Test

class BinaryTreeTest {


    /**
     * 输入:
    1
    / \
    2   3
    \
    4
    输出:
    [
    ["", "", "", "1", "", "", ""],
    ["", "2", "", "", "", "3", ""],
    ["", "", "4", "", "", "", ""]]

     */
    @Test
    fun printBinaryTree() {
        val root = exampleTree()
        val depth = depthOfTree(root)
        println("二叉树深度$depth")

        intArrayOf()

        //创建一个层数为 depth, 宽度为 2的 n次方 -1 的数组
        val width: Int = (Math.pow(2.0, depth.toDouble()) - 1).toInt()
        println("width =$width")
        val array2d = Array(depth) { IntArray(width) { it -> 0 } }

        //填充二叉树
        fill(array2d, 0, 0, width, root)

        //打印
        array2d.forEach {
            print("[")
            it.forEach {
                if(it==0) print("\"\",")
                else print("\"${it}\",")
            }
            println("],")
        }
    }


    fun fill(array: Array<IntArray>, depth: Int, start: Int, end: Int, treeNode: TreeNode?) {
        if (treeNode == null) return
        val cur = (start + end) / 2
        array[depth][cur] = treeNode.value
        fill(array, depth + 1, start, cur - 1, treeNode.leftNode)
        fill(array, depth + 1, cur + 1, end, treeNode.rightNode)
    }

    /**
     * 通过递归的方式，求得二叉树的深度
     */
    fun depthOfTree(treeNode: TreeNode?): Int {
        if (treeNode == null) return 0
        val leftDepth = depthOfTree(treeNode.leftNode)
        val rightDepth = depthOfTree(treeNode.rightNode)

        //左右深度取大的
        if (leftDepth > rightDepth) return leftDepth + 1
        else return rightDepth + 1
    }

    class TreeNode(var value: Int) {
        var leftNode: TreeNode? = null
        var rightNode: TreeNode? = null
    }

    /**
     * 构建一个二叉树
     */
    fun exampleTree(): TreeNode {
        val root = TreeNode(1)
        val level2Left = TreeNode(2)
        val level2Right = TreeNode(3)
        root.leftNode = level2Left
        root.rightNode = level2Right

        val level3Right = TreeNode(4)
        level2Left.rightNode = level3Right
        return root
    }
}
























