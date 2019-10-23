import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

public class SW1219 {
    public static int[][] vertix;
    public static int [] vis;
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./src/input_1219.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            sc.nextInt();
            int idx = sc.nextInt();
            vertix = new int [100][100];
            vis = new int [100];
            for(int i = 0 ; i < idx; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                vertix[a][b] = 1;
            }
            int ans = 0;
            if(isPossible(0)){
                ans = 1;
            }
            System.out.println("#"+test_case+" "+ ans);
        }
    }
    public static boolean isPossible(int pos){
        if(pos == 99){
            return true;
        }
        vis[pos] = 1;
        for(int i = 0 ; i< 100; i++){
            if(vis[i] == 0 && vertix[pos][i]==1){
                if(isPossible(i)){
                    return true;
                }
            }
        }
        vis[pos] = 0;
        return false;
    }
}