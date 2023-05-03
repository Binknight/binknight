package org.binknight.dp;

public class dp_03 {
    /**
     * 我们就先来看，如何量化两个字符串之间的相似程度呢？有一个非常著名的量化方法，那就是编辑距离（Edit Distance）。
     * 编辑距离指的就是，将一个字符串转化成另一个字符串，需要的最少编辑操作次数（比如增加一个字符、删除一个字符、替换一个字符）。
     * 编辑距离越大，说明两个字符串的相似程度越小；相反，编辑距离就越小，说明两个字符串的相似程度越大。
     *
     * 根据所包含的编辑操作种类的不同，编辑距离有多种不同的计算方式，比较著名的有莱文斯坦距离（Levenshtein distance）和最长
     * 公共子串长度（Longest common substring length）。其中，莱文斯坦距离允许增加、删除、替换字符这三个编辑操作，最长公
     * 共子串长度只允许增加、删除字符这两个编辑操作。
     *
     * 如何编程计算莱文斯坦距离？
     * 例如两个字符串 mitcmu 和 mtacnu 的莱文斯坦距离是 3，最长公共子串长度是 4。
     * @param args
     */
    public static void main(String[] args) {
        char[] a = "mitcmu".toCharArray();
        char[] b = "mtacnu".toCharArray();
        int minLwstDist = lwstDP(a, a.length, b, b.length);
        System.out.println(minLwstDist);
    }

    private static int lwstDP(char[] a, int n, char[] b, int m) {
        int[][] minDist = new int[n][m];
        for (int i = 0; i < n; i++) {  // 初始化第一列的状态集合
            if(a[i]==b[0]) minDist[i][0] = i;
            else if(i != 0)  minDist[i][0] = minDist[i-1][0] + 1;
            else minDist[i][0] = 0;
        }
        for (int j = 0; j < m; j++) {
            if(b[j]==a[0]) minDist[0][j] = j;
            else if(j != 0)  minDist[0][j] = minDist[0][j-1] + 1;
            else minDist[0][j] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(a[i] ==b[j]){
                    minDist[i][j] = Math.min(Math.min(minDist[i-1][j]+1,minDist[i][j-1]+1),minDist[i-1][j-1]);
                }else {
                    minDist[i][j] = Math.min(Math.min(minDist[i-1][j]+1,minDist[i][j-1]+1),minDist[i-1][j-1]+1);
                }
            }
        }
        return minDist[n-1][m-1];
    }
}
