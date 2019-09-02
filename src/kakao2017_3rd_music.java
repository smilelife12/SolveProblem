import java.util.Scanner;
import java.util.*;

public class kakao2017_3rd_music {
    public static String solution(String m, String[] musicinfos){
        String answer = "(None)";
        int m_len = -1;
        m = m.replace("C#","c").replace("D#","d").replace("F#","f").replace("G#","g").replace("A#","a");
        int count = 0;
        int len = m.length();
        for (String temp : musicinfos){
            String [] arr = temp.split(",");
            String start = arr[0];
            String end = arr[1];
            int time = calTime(start, end);
            if(time < len){
                continue;
            }
            String melody = arr[3];
            melody = melody.replace("C#","c").replace("D#","d").replace("F#","f").replace("G#","g").replace("A#","a");
            String t_m = "";
            for(int i = 0 ; i < time; i++){
                t_m += melody.charAt(i%melody.length());
            }
            if(t_m.contains(m)){
                if(time > m_len){
                    answer = arr[2];
                    m_len = time;
                }
            }
        }
        return answer;
    }
    public static int calTime(String S, String E){
        int S_H = Integer.parseInt(S.split(":")[0]);
        int S_M = Integer.parseInt(S.split(":")[1]);

        int E_H = Integer.parseInt(E.split(":")[0]);
        int E_M = Integer.parseInt(E.split(":")[1]);

        int sum = E_M - S_M;
        if(sum < 0){
            sum += 60;
            E_H -=1;
        }
        sum += (E_H - S_H)*60;

        return sum;
    }
    public static void main(String[] args) {
        String m = "ABC";
        String [] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String ans = solution(m,musicinfos);
        System.out.println(ans);
//        System.out.println(calTime("15:40", "16:20"));
    }
}
