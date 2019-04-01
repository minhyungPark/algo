package com.ssafy.day0401;

import java.util.Scanner;
 
public class Test {
 
    static int T, N, M, ans, sumW, sumR, sumB;
    static char map[][];
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            map = new char[N][M];
            for (int i = 0; i < N; i++) {
                String s = sc.next();
                for (int j = 0; j < M; j++) {
                    map[i][j] = s.charAt(j);
                }
            }
            sumW = 0;
            sumR = 0;
            sumB = 0;
            for (int j = 0; j < M; j++) {
                if (map[0][j] != 'W')
                    sumW++;
                if (map[N - 1][j] != 'R')
                    sumR++;
            }
            ans = N * M - sumW - sumR;
            for (int i = 1; i < N - 1; i++) {
                sumB = 0;
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 'B')
                        sumB++;
                }
                int tmp1 = 0, tmp2 = 0;
                int blue = 0, red = 0, white = 0;
                for (int ti = 1; ti < i; ti++) { // 위쪽
                    for (int j = 0; j < M; j++) {
                        if (map[ti][j] == 'W')
                            white++;
                        else if (map[ti][j] == 'B')
                            blue++;
                    }
                }
                tmp1 = (blue < white) ? M * (i - 1) - white : M * (i - 1) - blue;
                blue = 0;
                for (int ti = i + 1; ti < N - 1; ti++) { // 아래쪽
                    for (int j = 0; j < M; j++) {
                        if (map[ti][j] == 'R')
                            red++;
                        else if (map[ti][j] == 'B')
                            blue++;
                    }
                }
                tmp2 = (red < blue) ? M * (N - i - 2) - blue : M * (N - i - 2) - red;
                int tmp = sumB + tmp1 + tmp2;
                ans = ans < tmp ? ans : tmp;
            }
            System.out.println("#" + tc + " " + (ans + sumW + sumR));
        }
        sc.close();
    }
 
}