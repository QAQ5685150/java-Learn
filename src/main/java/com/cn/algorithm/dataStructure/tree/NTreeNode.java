package com.cn.algorithm.dataStructure.tree;

import java.util.List;

/**
 * 类名:NTreeNode
 * 描述:N叉树结构
 * 姓名:南风
 * 日期:2021-11-22 9:48
 **/
public class NTreeNode {

    public int _val;

    public List<NTreeNode> children;

    public NTreeNode(int _val, List<NTreeNode> children) {
        this._val = _val;
        this.children = children;
    }

    public NTreeNode(int _val) {
        this._val = _val;
    }
}
