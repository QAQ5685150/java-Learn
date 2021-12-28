package com.cn.algorithm.tree;

import java.util.*;

/**
 * 类名:getImportance_690
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-11-22 11:06
 **/
public class getImportance_690 {



    public static void main(String[] args) {
        Employee e1 = new Employee(1,5, Arrays.asList(2,3));
        Employee e2 = new Employee(2,3);
        Employee e3 = new Employee(3,3);
        List<Employee> employees = Arrays.asList(e1, e2, e3);
        System.out.println(getImportance1(employees,1));

    }

    public static int getImportance2(List<Employee> employees, int id){
        Deque<Employee> deque = new ArrayDeque<>();
        int ans = 0;
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Employee employee : employees) {
            if(employee.getId() == id){
                deque.add(employee);
                ans += employee.getImportance();
            }
        }
        while (!deque.isEmpty()){
            Employee poll = deque.poll();
            if(poll.subordinates != null){
                for (Employee employee : employees) {
                    for (Integer subordinate : poll.subordinates) {
                        if(employee.getId() == subordinate){
                            ans += employee.getImportance();
                            deque.add(employee);
                        }
                    }
                }
            }
        }

        return ans;
    }




    public static int getImportance1(List<Employee> employees, int id) {
        for (Employee e : employees) {
            if(e.id == id){
                if(e.subordinates == null){
                    return e.importance;
                }
                for(int subID : e.subordinates){
                    e.importance += getImportance1(employees,subID);
                }

                return e.importance;
            }
        }
        return 0;
    }



}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance) {
        this.id = id;
        this.importance = importance;
    }

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public List<Integer> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Integer> subordinates) {
        this.subordinates = subordinates;
    }
}
