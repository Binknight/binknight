package org.binknight.dp;

public class dp_04 {
    /**
     *
     * 如何编程计算最长公共子串的长度？
     * 例如两个字符串 mitcmu 和 mtacnu 的莱文斯坦距离是 3，最长公共子串长度是 4。
     * @param args
     */
    public static void main(String[] args) {
        char[] a = "mitcmu".toCharArray();
        char[] b = "mtacnu".toCharArray();
        int maxStrLen = maxStrLen(a, a.length, b, b.length);
        System.out.println(maxStrLen);
    }

    private static int maxStrLen(char[] a, int n, char[] b, int m) {
        int[][] maxStrLen = new int[n][m];
        for (int i = 0; i < n; i++) {
            if(a[i] == b[0]) maxStrLen[i][0] = 1;
            else if(i !=0) maxStrLen[i][0] = maxStrLen[i-1][0];
            else maxStrLen[i][0] = 0;
        }

        for (int j = 0; j < m; j++) {
            if(b[j] == a[0]) maxStrLen[j][0] = 1;
            else if(j !=0) maxStrLen[0][j] = maxStrLen[0][j-1];
            else maxStrLen[j][0] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(a[i] == b[j]) {
                    maxStrLen[i][j] = Math.max(Math.max(maxStrLen[i-1][j],maxStrLen[i][j-1]),maxStrLen[i-1][j-1]+1);
                }else {
                    maxStrLen[i][j] = Math.max(Math.max(maxStrLen[i-1][j],maxStrLen[i][j-1]),maxStrLen[i-1][j-1]);
                }
            }
        }
        return maxStrLen[n-1][m-1];
    }
}
