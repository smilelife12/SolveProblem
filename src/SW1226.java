import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

public class SW1226 {
    public static int [][] maze;
    public static int [][] vis;
    public static int [] start;
    public static int [] end;
    public static int n = 16;
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./src/input_1226.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            sc.nextInt();
            maze = new int[n][n];
            vis = new int[n][n];
            for(int i = 0 ; i < n ; i++){
                String line = sc.next();
                for(int j = 0 ; j < n ; j++){
                    int temp = line.charAt(j)- '0';
                    if(temp == 2){
                        start = new int[] {i,j};
                    }
                    else if(temp == 3){
                        end = new int[] {i,j};
                    }
                    maze[i][j] = temp;
                }
            }
            int ans = 0;
            if (isPossble(start)) {
                ans = 1;
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
    public static boolean isPossble(int [] rc){
        int r = rc[0];
        int c = rc[1];
        int var = maze[r][c];
        if(var == 3){
            return true;
        }
        else if(var == 0 || var == 2){
            int[] dx = {1,-1,0,0};
            int[] dy = {0,0,-1,1};
            for(int i = 0 ; i< 4; i++){
                int temp_r = r+dx[i];
                int temp_c = c+dy[i];
                if(vis[temp_r][temp_c]==1){
                    continue;
                }
                vis[r][c] = 1;
                if(temp_r >=0 && temp_r <n && temp_c>=0 && temp_c<n){
                    if(isPossble(new int [] {temp_r,temp_c}))
                        return true;
                }
                vis[r][c] = 0;
            }
        }
        else if(var == 1){
            return false;
        }
        return false;
    }
}