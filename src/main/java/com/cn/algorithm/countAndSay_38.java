package com.cn.algorithm;

/**
 * 类名:countAndSay_38
 * 描述:TODO
 * 姓名:南风
 * 日期:2021-10-15 16:36
 **/
public class countAndSay_38 {

    public static void main(String[] args) {
        countAndSay(30);

        //System.out.println(getString("1"));
    }


    public static String countAndSay(int n) {
        return getCount(n,1,"1");
    }

    public static String getCount(int i,int start,String ans){
        if(start == i){
            return ans;
        }
        String tmp = getString(ans);
        System.out.println('"' + tmp + '"' + ",");
        return getCount(i,start + 1,tmp);
    }

    public static String getString(String s){
        int length = s.length();
        String ans = "";
        for(int i = 0;i < length;){
            int num = 1;
            char c = s.charAt(i);
            while (i + 1 < length && s.charAt(i) == s.charAt(i+1)){
                num++;
                i++;
            }
            i++;
            ans += String.valueOf(num) + c;
        }
        return ans;
    }

        public String countAndSay2(int n) {
            String str = "1";
            for (int i = 2; i <= n; ++i) {
                StringBuilder sb = new StringBuilder();
                int start = 0;
                int pos = 0;

                while (pos < str.length()) {
                    while (pos < str.length() && str.charAt(pos) == str.charAt(start)) {
                        pos++;
                    }
                    sb.append(Integer.toString(pos - start)).append(str.charAt(start));
                    start = pos;
                }
                str = sb.toString();
            }

            return str;
        }

}
