package problems;

import baseutil.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: woleto
 * @date: 2020/8/26 20:40
 * @Email: woleto@126.com
 * @description: 翻转二叉树，也有两种方式，递归版本比较好理解，也有非递归版本
 */
public class Num226 {

    /**
     * \ 递归版本
     * @param root
     * @return
     */
    public static TreeNode inverTree(TreeNode root){
        if (root == null) {
            return null;
        }
        TreeNode leftNode = inverTree(root.left);
        TreeNode rightNode = inverTree(root.right);
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }


    public static TreeNode inverTreeIter(TreeNode root){
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode temp = null;
            temp = node.left;
            node.left = node.right;
            node.left = temp;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
