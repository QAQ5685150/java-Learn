package com.cn.Utils;

import com.cn.Algorithm.util.printUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

/**
 * @Author: Linxx
 * @Package: com.cn.Utils
 * @Time: 2022-11-10 19:25
 * @Description: TODO
 **/
public class movieLen2Matrix {

    static final String FILE_PATH = "src\\main\\resources\\u.data";
    static double[][] matrix = new double[944][1683];
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new FileReader(FILE_PATH));
        String line ;
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> movie = new HashSet<>();
        while ((line = bfr.readLine()) != null){
            String[] split = line.split("\\s+");
            Integer userId = Integer.valueOf(split[0]);
            Integer movieId = Integer.valueOf(split[1]);
            Double rating = Double.valueOf(split[2]);
//            set.add(userId);
//            movie.add(movieId);
            matrix[userId][movieId] = rating;
        }
        for (double[] doubles : matrix) {
            for (double aDouble : doubles) {
                System.out.print(aDouble + " ");
            }
            System.out.println();
        }
//        System.out.println("用户总数：" + set.size());
//        System.out.println("电影总数" + movie.size());
    }
}
