package com.cn.algorithm.tree;

import com.cn.algorithm.dataStructure.tree.TreeNode;

import java.util.List;
import java.util.Random;

/**
 * 类名:is_equals
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-09-28 14:24
 **/
public class is_equals {

    public static void main(String[] args) {
        Random random = new Random();
        is_equals_pro(random);
    }

    private static void is_equals_pro(Random random) {
        for(int i = 0;i < 10; i++){
            recursion recursion = new recursion();
            TreeNode test = new TreeNode(random.nextInt(10),
                    new TreeNode(random.nextInt(10), new TreeNode(random.nextInt(10), new TreeNode(random.nextInt(10)), new TreeNode(random.nextInt(10))),
                            new TreeNode(random.nextInt(10), new TreeNode(random.nextInt(10)), new TreeNode(random.nextInt(10)))),
                    new TreeNode(random.nextInt(10), new TreeNode(random.nextInt(10), new TreeNode(random.nextInt(10)), new TreeNode(random.nextInt(10))),
                            new TreeNode(random.nextInt(10))));
            if(check_pro(test, recursion) == false){
                System.out.println("test no." + i +" is false");
            }else {
                System.out.println("ok!");
            }
        }
    }

    public static boolean check_pro(TreeNode treeNode,recursion re){
        re.pro(treeNode);
        List<Integer> pro = unrecursion.pro(treeNode);
        return check(re.re_proList,pro);
    }

    public static boolean check(List<Integer> A,List<Integer> B){
        if(A.size() != B.size()){
            return false;
        }
        int len = A.size();
        for(int i = 0; i < len; i++){
            Integer integer = A.get(i);
            Integer integer1 = B.get(i);
            if( integer != integer1){
                return false;
            }
        }
        return true;
    }
}
