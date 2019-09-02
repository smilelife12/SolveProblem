import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

public class SW1824 {
    public static int mem, udlr;
    public static int []dx = {0,0,-1,1};
    public static int []dy = {-1,1,0,0};
    public static int [] xy = {0,0};
    public static char [][] map;
    public static int [][][] visit;
    public static boolean stop;
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("./src/input_1824.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int R,C;
            udlr = 3;
            xy = new int [] {0,0};
            R = sc.nextInt();
            C = sc.nextInt();
            visit = new int [R][C][15];
            map = new char[R][C];
            stop = false;
            for(int i =0; i < R ;i++){
                String s = sc.next();
                for(int j = 0; j < C; j++){
                    map[i][j] = s.charAt(j);
                }
            }
            int count = 0;
            while (true){
                if(count <5000){
                    count+=1;
                }
                else{
                    break;
                }
                doHyuk();
                if(stop){
                    break;
                }
                int [] before = new int [2];
                System.arraycopy(xy,0, before,0,2);
                xy[0] += dx[udlr];
                if(xy[0] <0)
                {
                    xy[0] = C-1;
                }
                else if(xy[0] == C){
                    xy[0] = 0;
                }
                xy[1] += dy[udlr];
                if(xy[1] <0)
                {
                    xy[1] = R-1;
                }
                else if(xy[1] == R){
                    xy[1] = 0;
                }
                if(isVisit(before)){
                    break;
                }
                else{
                    visit[xy[1]][xy[0]][mem] = 1;
                }
            }
            String ans = "NO";
            if(stop){
                ans = "YES";
            }
            System.out.println("#"+test_case+" "+ ans);
        }
    }

    public static boolean isVisit(int[] before){
        int x = xy[1];
        int y = xy[0];
        if(visit[x][y][0] == before[1] && visit[x][y][1] == before[0] && visit[x][y][2] == mem){
            return true;
        }
        return false;
    }

    public static void doHyuk(){
        int x = xy[1];
        int y = xy[0];
        char now = map[x][y];
        if (now == '<'){
            udlr = 2;
        }
        else if(now == '>'){
            udlr = 3;
        }
        else if(now == '^'){
            udlr = 0;
        }
        else if(now == 'v'){
            udlr = 1;
        }
        else if(now == '_'){
            if(mem == 0){
                udlr = 3;
            }
            else{
                udlr = 2;
            }
        }
        else if(now == '|'){
            if(mem == 0){
                udlr = 1;
            }
            else{
                udlr = 0;
            }
        }
        else if(now == '?'){
            udlr = new Random().nextInt(4);
        }
        else if(now == '.'){

        }
        else if(now == '@'){
            stop = true;
        }
        else if(now >= '0' && now <= '9'){
            mem = now - '0';
        }
        else if(now == '+') {
            mem += 1;
            if(mem >15){
                mem = 0;
            }
        }
        else if(now == '-'){
            mem -= 1;
            if(mem<0){
                mem = 15;
            }
        }
    }
}