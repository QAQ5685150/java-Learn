package com.cn.Algorithm.string;

import java.util.HashMap;

/**
 * @Auther: @Ð¡ÄÔ¸«²»¿É°®
 * @Time: 2022-04-10 16:02
 * @Description: TODO
 * @Project_name: java-learn
 */
public class uniqueMorseRepresentations_804 {

    static HashMap<Character, String> rules = new HashMap<>();
    static String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    static Character[] alpha = new Character[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    static {
        for (int i = 0; i < morse.length; i++) {
            rules.put(alpha[i],morse[i]);
        }
    }

    public static int uniqueMorseRepresentations(String[] words) {
        HashMap<String, Integer> ans = new HashMap<>();
        for (String word : words) {
            String result = "";
            for (int i = 0; i < word.length(); i++) {
                result += rules.get(word.charAt(i));
            }
            ans.put(result,ans.getOrDefault(result,0) + 1);
        }
        return ans.size();
    }

    public static void main(String[] args) {
        String[] test = new String[]{"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(test));
    }
}
