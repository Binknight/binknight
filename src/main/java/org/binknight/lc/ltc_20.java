package org.binknight.lc;

import java.util.Stack;

public class ltc_20 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        String s = "(])";
        boolean valid = isValidExpression(s);
        System.out.println(valid);
    }

    private static boolean isValidExpression(String s) {
        Stack<Character> sk = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '[' || chars[i] == '{' || chars[i] == '('){
                sk.add(chars[i]);
            } else if (!sk.isEmpty()) {
                if (chars[i] == ']' && sk.peek() == '['){
                    sk.pop();
                }else if (chars[i] == '}' && sk.peek() == '{'){
                    sk.pop();
                }else if (chars[i] == ')' && sk.peek() == '('){
                    sk.pop();
                }else {
                    return false;
                }
            }else if(chars[i] == ']' || chars[i] == '}' || chars[i] == ')'){
                return false;
            }
        }
        return sk.isEmpty();
    }
}
