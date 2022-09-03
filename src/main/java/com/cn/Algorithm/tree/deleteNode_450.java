package com.cn.Algorithm.tree;

import com.cn.Algorithm.dataStructure.tree.TreeNode;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-06-02 10:24
 * @Description: TODO
 * @Project_name: java-learn
 */
public class deleteNode_450 {
    static TreeNode ref = null;

    public static void main(String[] args) {

    }

    public static TreeNode deleteNode(TreeNode root, int key) {


        return null;
    }

    public static void delete(TreeNode pre,TreeNode root, int key){
        if(root == null){
            return;
        }
        if (root.val == key){
            if(root.right == null && root.left == null){
                root = null;
                return;
            }
            if(root.right == null || root.left == null){
                root = root.right == null ? root.right : root.left;
                return;
            }
            if(root.right.left == null){
                root = root.right;
                return;
            }
            if (root.left.right == null){
                root = root.left;
                return;
            }
            if(root.right.left != null && root.left.right != null){
                ref = root.left.right;
                root.left.right = null;
                root = root.left;
                while (root != null){

                }
            }
        }

        delete(root,root.left,key);
        delete(root,root.right,key);
    }
}

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            // 待删除节点在左子树中
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            // 待删除节点在右子树中
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            // key == root.val，root 为待删除节点
            if (root.left == null) {
                // 返回右子树作为新的根
                return root.right;
            } else if (root.right == null) {
                // 返回左子树作为新的根
                return root.left;
            } else {
                // 左右子树都存在，返回后继节点（右子树最左叶子）作为新的根
                TreeNode successor = min(root.right);
                successor.right = deleteMin(root.right);
                successor.left = root.left;
                return successor;
            }
        }
    }

    private TreeNode min(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }
}

/**
 *
 */
class Solution2 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            TreeNode successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            root.right = deleteNode(root.right, successor.val);
            successor.right = root.right;
            successor.left = root.left;
            return successor;
        }
        return root;
    }
}

