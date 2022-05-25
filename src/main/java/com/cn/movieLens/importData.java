package com.cn.movieLens;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-05-04 11:14
 * @Description: TODO
 * @Project_name: java-learn
 */
public class importData {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String movies = "D:\\development\\ml-1m\\movies.dat";
        String ratings = "D:\\development\\ml-1m\\ratings.dat";
        String users = "D:\\development\\ml-1m\\users.dat";

        List<String[]> moviesList = new ArrayList<>();
        List<String[]> ratingsList = new ArrayList<>();
        List<String[]> usersList = new ArrayList<>();

//        try {
//            FileReader fr = new FileReader(movies);
//            BufferedReader bfr = new BufferedReader(fr);
//            String tmp ;
//
//            while(((tmp = bfr.readLine()) != null)){
//                String[] split = tmp.split("::");
//                boolean contains = split[1].contains("'");
//                if(contains){
//                    String s = "";
//                    for (int i = 0; i < split[1].length(); i++) {
//                        if(split[1].charAt(i) == '\''){
//                            s += ';';
//                            continue;
//                        }
//                        s += split[1].charAt(i);
//                    }
//                    split[1] = s;
//                }
//
//
//                String[] split1 = split[2].split("\\|");
//                String s = "";
//                for (int i = 0; i < split1.length; i++) {
//                    if(split1[i].contains("'")){
//                        split1[i] = "Children";
//                    }
//                    s += split1[i];
//                    if(i != split1.length - 1){
//                        s += ",";
//                    }
//                }
//                split[2] = s;
//                moviesList.add(split);
//            }
//            bfr.close();
//            fr.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        //insert2sql(conn, stmt, rs, moviesList,"movies");

        //ratingsList = importRatting(ratings);

        usersList = importUsers(users);

        insert2sql(conn,stmt,rs,usersList,"users");
    }

    private static void insert2sql(Connection conn, Statement stmt, ResultSet rs, List<String[]> list,String table) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://192.168.111.128:3306/movieLens";
            String user = "root";
            String passwd = "123456";
            conn = DriverManager.getConnection(url, user, passwd);
            stmt = conn.createStatement();

            for (String[] s : list) {
                StringBuilder sql = new StringBuilder();
                sql.append("insert into " + table + " (sex,age,occupation)" + " values (");

                for (int i = 0; i < 3; i++) {
                    sql.append("'" + s[i] + "'");
                    if(i != 2){
                        sql.append(",");
                    }
                }

                sql.append(")");
                boolean execute = stmt.execute(sql.toString());
                if(execute){
                    System.out.println(sql);
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public static List<String[]> importRatting(String filePath){
        List<String[]> ratingsList = new ArrayList<>();

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader bfr = new BufferedReader(fr);
            String tmp ;

            while(((tmp = bfr.readLine()) != null)){
                String[] split = tmp.split("::");
                ratingsList.add(split);
            }

            bfr.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ratingsList;
    }

    public static List<String[]> importUsers(String filePath){
        List<String[]> Users = new ArrayList<>();

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader bfr = new BufferedReader(fr);
            String tmp ;

            while(((tmp = bfr.readLine()) != null)){
                String[] split = tmp.split("::");
                String[] s = new String[3];
                for (int i = 0; i < s.length; i++) {
                    s[i] = split[i + 1];
                }
                Users.add(s);
            }

            bfr.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Users;
    }
}
