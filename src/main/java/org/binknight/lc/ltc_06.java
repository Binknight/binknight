package org.binknight.lc;

public class ltc_06 {
    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/zigzag-conversion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        String s = "Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.";
        int numRows = 10;
        String convert = convert(s, numRows);
        System.out.println(convert);
    }

    /**
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * @param s
     * @param numRows
     * @return
     */

    // (2*n-2):
    public static String convert(String s, int numRows) {
        if(s.length() <= numRows || numRows == 1) return s;
        int step = s.length() / (numRows * 2 - 2);
        String[][] cc;
        if(s.length() <= numRows*2-2){
            cc = new String[numRows][s.length()-numRows+1];
        }else if(s.length()%(numRows*2-2)==0){
            cc = new String[numRows][step*(numRows-1)];
        }else {
            int w = s.length()%(numRows*2-2)>numRows?2:1;
            cc = new String[numRows][step*(numRows-1)*2+w];
        }
        int i=0,j=0,k=0;
        boolean f = true;
        while(k < s.length()){
            if(f){
                cc[i++][j] = s.charAt(k++) + "";
                if(i == numRows) f = false;continue;
            }
            if(!f){
                cc[--i-1][++j] = s.charAt(k++) + "";
                if(i== 1) f = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int l1 = 0; l1 < numRows; l1++) {
            String[] r1 = cc[l1];
            for (int l2 = 0; l2 < r1.length; l2++) {
                sb.append(r1[l2]==null?"":r1[l2]+"");
            }
        }

        return sb.toString();
    }

}
