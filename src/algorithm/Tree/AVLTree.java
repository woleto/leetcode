package algorithm.Tree;

import baseutil.AVLTreeNode;

/**
 * @description:
 * @author: Sun, YaSong
 * @time: 2020/9/3 8:57
 */
public class AVLTree {
    /**
     *以传入点为中心，
     * @param node 旋转的中心
     */
    public void leftRotate(AVLTreeNode node){
        // 准备参与旋转的节点
        AVLTreeNode nodeParent = node.parent;
        AVLTreeNode rightSon = node.right;
        AVLTreeNode rightLeftGrandSon = rightSon.left;
        // 右子变父

    }
}
