import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

public class SW1868 {
    public static char [][] map;
    public static int [][] cnt;
    public static boolean [][] visit;
    public static int count,N;
    public static LinkedList<int[]> zero;
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./src/input_1868.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            N = sc.nextInt();
            map = new char[N][N];
            visit = new boolean[N][N];
            cnt = new int [N][N];
            zero = new LinkedList<>();
            count = 0;
            int [] dr = {0,0,1,-1,1,-1,1,-1};
            int [] dc = {1,-1,0,0,1,-1,-1,1};
            for(int i = 0 ; i < N ; i++){
                String temp = sc.next();
                for(int j = 0 ; j < N ; j++){
                    char now = temp.charAt(j);
                    if(now == '*'){
                        visit[i][j] = true;
                    }
                    map[i][j] = now;
                }
            }
            for(int i = 0 ; i < N; i++){
                for(int j = 0 ; j < N; j++){
                    if(map[i][j] != '.') {
                        continue;
                    }
                    int c = 0;
                    for(int k = 0 ; k < 8 ; k++){
                        int t_r = i+ dr[k];
                        int t_c = j + dc[k];
                        if(t_r >=0 && t_r<N && t_c>=0 && t_c<N && map[t_r][t_c]=='*'){
                            c++;
                        }
                    }
                    if(c == 0){
                        zero.add(new int[] {i,j});
                    }
                    cnt[i][j] = c;
                }
            }
            while(!zero.isEmpty()){
                int [] temp = zero.poll();
                if(visit[temp[0]][temp[1]]){
                    continue;
                }
                count++;
                visit[temp[0]][temp[1]] = true;
                BFS(new int [] {temp[0],temp[1]});
            }
            for(int i = 0 ; i < N; i++){
                for(int j = 0 ; j < N; j++){
                    if(!visit[i][j] &&cnt[i][j]>0 && cnt[i][j] <9){
                        count++;
                    }
                }
            }
            System.out.println("#"+test_case+" "+count);
        }
    }

    public static void BFS(int[] RC){
        int r = RC[0];
        int c = RC[1];
        int [] dr = {0,0,1,-1,1,-1,1,-1};
        int [] dc = {1,-1,0,0,1,-1,-1,1};
        LinkedList<int[]> stack = new LinkedList<>();
        for(int i = 0 ; i<8; i++){
            int t_r = r + dr[i];
            int t_c = c + dc[i];
            if(t_r >=0 && t_r< N && t_c>=0 && t_c < N){
                if(!visit[t_r][t_c]){
                    if(cnt[t_r][t_c] == 0){
                        stack.add(new int []{t_r,t_c});
                    }
                    else {
                        visit[t_r][t_c] = true;
                    }
                }
            }
        }
        while(!stack.isEmpty()){
            int[] temp =stack.poll();
            int t_r = temp[0];
            int t_c = temp[1];
            if(visit[t_r][t_c]){
                continue;
            }
            visit[t_r][t_c] = true;
            BFS(new int [] {t_r, t_c});
        }
    }

}