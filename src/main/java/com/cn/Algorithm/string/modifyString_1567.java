package com.cn.Algorithm.string;

/**
 * @Auther: @С�Ը����ɰ�
 * @Time: 2022-01-05 22:45
 * @Description: TODO
 * @Project_name: java-learn
 */
public class modifyString_1567 {

    private static char[] c = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','?'};

    /**
     * ����һ��������СдӢ����ĸ�� '?' �ַ����ַ��� s�����㽫���е� '?' ת��Ϊ����Сд��ĸ��ʹ���յ��ַ����������κ� �����ظ� ���ַ���
     *
     * ע�⣺�� ���� �޸ķ� '?' �ַ���
     *
     * ��Ŀ����������֤ �� '?' �ַ� ֮�⣬�����������ظ����ַ���
     *
     * ���������ת������������ת�����󷵻����յ��ַ���������ж������������뷵�������κ�һ��������֤�����ڸ�����Լ�������£������Ǵ��ڵġ�
     * @param args
     */
    public static void main(String[] args) {
        String s = new String("b?a");
        System.out.println(modifyString(s));
    }

    /**
     * test  �����������о����꣬���ǻ���30����ӡ������ǳ��߽磬debug�����⣬��Ҫ��debug�Ŀ�ݼ����ʼǱ�Fn���ɻ��ˣ�
     *  ���������� ����������û�뵽 ��b��a��û������Ϊ�����ж�û�а�a���ϣ������ִ�a��ʼ���ظ���
     * @param s
     * @return
     */
    public static String modifyString(String s) {
        if(s.length() == 1 && s.equals("?")){
            return "a";
        }
        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if(chars[i] == '?'){
                if(i == 0){
                    int cur = 0 <= (chars[i + 1] - 'a') ? chars[i + 1] - 'a' : 26;
                    chars[i] = replace(26,cur);
                    continue;
                }
                if(i == s.length() - 1){
                    int cur = 0 <= (chars[i - 1] - 'a') ? chars[i - 1] - 'a' : 26;
                    chars[i] = replace(26,cur);
                    continue;
                }
                int l = chars[i - 1] - 'a';
                int r =  0 <= (chars[i + 1] - 'a') ? chars[i + 1] - 'a' : 26;
                chars[i] = replace(l,r);
            }
        }
        return new String(chars);
    }

    public static char replace(int j, int k){
        int index = 0;
        for(int i = 0; i < c.length - 1; i++){
            if(c[i] != c[j] && c[i] != c[k]){
                index = i;
                break;
            }
        }
        return c[index];
    }

    /**
     * �ٷ���⣬�滻������˵Ϊɶ�������� �������� ��һ���ͱ��b���滻�Ǵ�c��ʼ����İ�
     * @param s
     * @return
     */
    public static String modifyString_ch(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; ++i) {
            if (arr[i] == '?') {
                for (char ch = 'a'; ch <= 'c'; ++ch) {
                    if ((i > 0 && arr[i - 1] == ch) || (i < n - 1 && arr[i + 1] == ch)) {
                        continue;
                    }
                    arr[i] = ch;
                    break;
                }
            }
        }
        return new String(arr);
    }

}
