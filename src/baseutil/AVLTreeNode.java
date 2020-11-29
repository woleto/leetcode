package baseutil;

/**
 * @description:
 * @author: Sun, YaSong
 * @time: 2020/9/3 8:58
 */
public class AVLTreeNode {
    public int val;
    public AVLTreeNode parent, left, right;
    public int blance;
    public AVLTreeNode (int val) {
        this.val = 0;
        this.blance = 0;
    }
}
