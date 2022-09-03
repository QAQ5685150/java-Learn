package com.cn.Algorithm.tree;

import com.cn.Algorithm.dataStructure.tree.TreeNode;

/**
 * @Auther: @С�Ը����ɰ�
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
            // ��ɾ���ڵ�����������
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            // ��ɾ���ڵ�����������
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            // key == root.val��root Ϊ��ɾ���ڵ�
            if (root.left == null) {
                // ������������Ϊ�µĸ�
                return root.right;
            } else if (root.right == null) {
                // ������������Ϊ�µĸ�
                return root.left;
            } else {
                // �������������ڣ����غ�̽ڵ㣨����������Ҷ�ӣ���Ϊ�µĸ�
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

