import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

public class SW1227 {
    public static int [][] maze;
    public static int [][] vis;
    public static int size = 100;
    public static int [] start;
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./src/input_1227.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            sc.nextInt();
            maze = new int [size][size];
            vis = new int [size][size];
            start = new int[2];
            for(int i = 0 ; i < size; i++){

                String line;
                line = sc.next();
                for(int j = 0 ; j < size; j++){
                    int temp = line.charAt(j)-'0';
                    maze[i][j] = temp;
                    if(temp == 2){
                        start[0] = i;
                        start[1] = j;
                    }
                }
            }
            int ans = 0;
            if(isPossible(start)){
                ans = 1;
            }
            System.out.println("#"+ test_case+ " "+ ans);
        }
    }
    public static boolean isPossible(int [] pos){
        int r = pos[0];
        int c = pos[1];
        if(maze[r][c] == 3){
            return true;
        }
        int [] dx = {-1,1,0,0};
        int [] dy = {0,0,-1,1};
        for(int i = 0 ; i < 4 ; i++){
            int t_r = r+dx[i];
            int t_c = c+dy[i];
            if(t_r>=0 && t_r < size && t_c >=0 && t_c< size && maze[t_r][t_c] != 1){
                if(vis[t_r][t_c] == 0){
                    vis[t_r][t_c] = 1;
                    if(isPossible(new int [] {t_r, t_c})){
                        return true;
                    }
                    vis[t_r][t_c] = 0;
                }
            }
        }
        return false;
    }

}