package problems;

import baseutil.TreeNode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description: 二叉树的最小深度
 * @author: Sun, YaSong
 * @time: 2020/8/21 13:38
 * 解题思路：第一感觉用BFS,但是DFS也可以，好像还更简单
 */
public class Num111 {

    /**
     * dfs方法
     * @param root 二叉树根节点
     * @return 最小高度
     */
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int minValue = Integer.MAX_VALUE;

        if (root.left != null) {
            minValue = Math.min(minDepth(root.left), minValue);
        }

        if (root.right != null) {
            minValue = Math.min(minDepth(root.right), minValue);
        }
        return minValue + 1;
    }

    /**
     * bfs版本
     * @param root
     * @return
     */
    class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int minDepthBfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<QueueNode> queue = new LinkedList<QueueNode>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode nodeDepth = queue.poll();
            TreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.offer(new QueueNode(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.offer(new QueueNode(node.right, depth + 1));
            }
        }

        return 0;
    }

}
