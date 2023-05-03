package org.binknight.hj;

import java.util.*;
public class HJ43 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] r_l = scanner.nextLine().split(" ");
        int r = Integer.parseInt(r_l[0]),l = Integer.parseInt(r_l[1]);
        int[][] maze = new int[r][l];
        for (int i = 0; i < r; i++) {
            int[] r1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            maze[i] = r1;
        }
        Stack<int[]> path = new Stack<>();
        int[] x0y0 = new int[]{0, 0}, xnyn = new int[]{r-1, l-1};
        path.push(x0y0);
        searchRoad(x0y0, maze, path, xnyn);
        Iterator<int[]> iterator = path.iterator();
        while(iterator.hasNext()){
            int[] next = iterator.next();
            System.out.println("("+next[0]+","+next[1]+")");
        }
    }
    private static boolean searchRoad(int[] x0y0, int[][] maze, Stack<int[]> path, int[] xnyn) {
        if (x0y0[0] == xnyn[0] && x0y0[1] == xnyn[1]) return true;
        int[] pr = x0y0.clone();pr[1] = x0y0[1]+1;
        int[] pl = x0y0.clone();pl[1] = x0y0[1]-1;
        int[] pu = x0y0.clone();pu[0] = x0y0[0]-1;
        int[] pd = x0y0.clone();pd[0] = x0y0[0]+1;
        List<int[]> ppp = Arrays.asList(pr, pl, pu, pd);
        for (int i = 0; i < ppp.size(); i++) {
            int[] ints = ppp.get(i);
            boolean isSearched = path.stream().anyMatch(c -> c[0] == ints[0] && c[1] == ints[1]);
            if(!isSearched){
                if(ints[0] >= 0 && ints[0] < maze.length && ints[1] >= 0 && ints[1] < maze[0].length && maze[ints[0]][ints[1]]==0){
                    path.push(ints);
                    if (searchRoad(ints, maze, path, xnyn)) {
                        return true;
                    }else {
                        path.pop();
                    };
                }
            }
        }
        return false;
    }
}
