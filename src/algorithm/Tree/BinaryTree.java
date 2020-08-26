package algorithm.Tree;


import baseutil.TreeNode;

import java.util.*;

/**
 * @author: woleto
 * @date: 2020/8/23 18:54
 * @Email: woleto@126.com
 * @description: 二叉树的一些操作
 */
public class BinaryTree {
    private static int element = 3;
    private static int lay;
    /**
     * 生成二叉树
     * @return
     */
    public static TreeNode createBinaryTree(){
        TreeNode rootNode = new TreeNode(0);
        TreeNode rootNode1 = new TreeNode(1);
        TreeNode rootNode2 = new TreeNode(2);
        TreeNode rootNode3 = new TreeNode(3);
        rootNode.left = rootNode1;
        rootNode.right = rootNode2;
        rootNode2.left = rootNode3;
        return rootNode;
    }

    /**
     * 前序遍历
     * @param root 根节点
     */
    public static void preorderTraversal(TreeNode root){
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    /**
     * 前序遍历的非递归版本
     * @param root 根节点
     */
    public static void perorderTraversalIter(TreeNode root){
        if (root == null) {return;}
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    /**
     * 中序遍历
     * @param root 根节点
     */
    public static void inorderTraversal(TreeNode root){
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    /**
     * 非递归版本的中序遍历
     * @param root 根节点
     */
    public static void inorderTraversalIter(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while(root!= null || !stack.isEmpty()){
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            root = node.right;
        }


    }
    /**
     * 后序遍历
     * @param root 根节点
     */
    public static void postorderTraversal(TreeNode root){
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        postorderTraversal(root.left);
        postorderTraversal(root.right);
    }

    /**
     * 后序遍历非递归版本
     * @param root 根节点
     */
    public static void postorderTraversalIter(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisit = null;
        while (root != null || !stack.isEmpty()) {
            while (root!= null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.peek();
            if (root.right == null || lastVisit == root.right) {
                System.out.print(root.val + " ");
                stack.pop();
                lastVisit = root;
                root = null;
            }
            else{
                root = root.right;
            }
        }
    }

    /**
     * 计算二叉树的高度，也叫最大高度。
     * 同时如果要计算最小高度，将return里的Math.max换成Math.min就可以了
     * @param root
     * @return
     */
    public static int getMaxHeight(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftHeight = getMaxHeight(root.left);
        int rightHeight = getMaxHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * 某个元素的高度1
     * @param root
     * @return
     */
    public static int getElementHeight(TreeNode root, int layer){
        if (root == null) {
            return 0;
        }
        if (root.val == element) {
            lay = layer + 1;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        getElementHeight(root.left, layer + 1);
        getElementHeight(root.right, layer + 1);
        return 0;
    }


    public static int layer = 0;

    /**
     * 某元素高度2
     * @param root
     * @param element
     */
    public static void getElementHeight2(TreeNode root, int element){
        if (root == null) {return;}
        layer++;
        if (root.val == element) {
            System.out.println(layer);
            return;
        }
        getElementHeight2(root.left, element);
        getElementHeight2(root.right, element);
        layer--;
    }

    /**
     * 层序遍历
     * @param root 根节点
     */
    public static List<List<Integer>> elements = new ArrayList<>();
    public static void levelTraversal(TreeNode root, int level){
        if (root == null) {return;}
        if (level >= elements.size()) {
            elements.add(new ArrayList<Integer>());
        }
        elements.get(level).add(root.val);
        levelTraversal(root.left, level + 1);
        levelTraversal(root.right, level + 1);
    }

    /**
     * 非递归版层序遍历
     * @param root 根节点
     */
    public static void levelTraversalIter(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode rootNode = createBinaryTree();
//        前序遍历
//        preorderTraversal(rootNode);
//        perorderTraversalIter(rootNode);

//        中序遍历
//        inorderTraversalIter(rootNode);

//        后序遍历
//        postorderTraversalIter(rootNode);

//        层序遍历
        levelTraversalIter(rootNode);
//        System.out.println(getHeight(rootNode));
//        getElementHeight(rootNode, 0);
//        getElementHeight2(rootNode, 3);
//        System.out.println(layer);
    }
}
