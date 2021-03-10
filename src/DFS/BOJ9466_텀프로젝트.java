package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class BOJ9466_텀프로젝트 {
    static int n;
    static boolean[] ary;
    static boolean[] visit;
    static List<Integer> list[];

    static int P[];
    static boolean finished[];
    static int res=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            n = Integer.parseInt(br.readLine());
            ary = new boolean[n + 1];
            visit = new boolean[n+1];
            res=0;
            P=new int[n+1];
            finished=new boolean[n+1];
            list = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
            for (int i = 1; i <= n; i++) {
                if(!visit[i]){
                    dfs(i);
                }
            }

            sb.append(n-res + "\n");
        }

        System.out.println(sb.toString());
    }

    static void dfs(int u) {
        visit[u] = true;
        for (Integer v : list[u]) {
            if (!visit[v]) {
                P[u] = v;
                dfs(v);
            } else if (!finished[v]) {
                for (int i = v; i != u; i = P[i]) {
                    res++;
                } res++;
            }
        }
        finished[u] = true;
    }

}
