import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

public class SW1211 {
    public static int [][] ladder;
    public static int [][] vis;
    public static int [] start;
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./src/input_1211.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            sc.nextInt();
            ladder = new int [100][100];
            start = new int[100];
            for(int j = 0 ; j<100 ; j++){
                int temp = sc.nextInt();
                ladder[0][j] = temp;
                if(temp == 1) {
                    start[j] = 1;
                }
            }
            for(int i = 1 ; i<100; i++)
            {
                for(int j = 0 ; j<100 ; j++){
                    int temp = sc.nextInt();
                    ladder[i][j] = temp;
                }
            }
            int ans = -1;
            int min = 999;
            for(int i = 0 ; i < 100; i++){
                if(start[i] == 1){
                    vis = new int [100][100];
                    int dis;
                    dis = Find(new int [] {0,i}, 0);
                    if(min > dis){
                        ans = i;
                        min = dis;
                    }
                }
            }

            System.out.println("#"+test_case+" "+ans);
        }
    }

    public static int Find(int[] pos, int dis){
        int r = pos[0];
        int c = pos[1];
        if(r == 99) {
            return dis;
        }
        vis[r][c] =1;
        if(c+1 < 100 && vis[r][c+1] == 0 &&ladder[r][c+1] == 1){
            return Find(new int[] {r,c+1}, dis+1);
        }
        else if(c-1 >=0 && vis[r][c-1] ==0 &&ladder[r][c-1] == 1){
            return Find(new int[] {r,c-1}, dis +1);
        }
        else{
            return Find(new int[] {r+1,c}, dis+1);
        }
    }

}