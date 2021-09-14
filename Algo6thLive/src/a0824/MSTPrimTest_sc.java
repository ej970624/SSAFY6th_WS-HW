package a0824;

import java.io.*;
import java.util.*;
public class MSTPrimTest_sc {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[][] g = new int[N][N];
        boolean[] v = new boolean[N];
        int[] minEdge = new int[N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                g[i][j] = sc.nextInt();
            }
            minEdge[i] = Integer.MAX_VALUE;
        }
        
        int result = 0, cnt = 0; // 최소신장트리 비용
        minEdge[0] = 0; // 임의의 시작점 0의 간선비용을 0으로 세팅
        
        for (int i = 0; i < N; i++) {
            // 1. 신장트리에 포함되지 않은 정점 중 최소간선비용의 정점 찾기
            int min = Integer.MAX_VALUE;
            int minVertex = -1; // 최소간선비용의 정점번호
            
            for (int j = 0; j < N; j++) {
                if(!v[j] && min > minEdge[j]) {
                            min = minEdge[j];
                            minVertex = j;
                }
            }
            
            v[minVertex] = true; // 신장트리에 포함시킴
            result += min;  // 간선비용 누적
            if(cnt++ == N-1) break;
            
            // 2. 선택된 정점 기준으로 신장트리에 연결되지 않은 타 정점과의 간선 비용 최소로 업데이트
            
            for (int j = 0; j < N; j++) {
                if(!v[j] && g[minVertex][j] != 0 && minEdge[j] > g[minVertex][j]) {
                                                    minEdge[j] = g[minVertex][j];
                }
            }
        }
        
        System.out.println(result);
    }
}