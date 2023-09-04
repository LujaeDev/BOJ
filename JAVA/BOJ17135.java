import java.io.*;
import java.util.*;

public class BOJ17135 {
    static private List<ArrayList<Integer>> archerPositions = new ArrayList<>();
    static int[] dy = {0, -1, 1, 0};
    static int[] dx = {-1, 0, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N, M, D;

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        D = Integer.parseInt(input[2]);

        int state[][] = new int[N][M];

        for (int i = 0; i < N; ++i) {
            input = br.readLine().split(" ");

            for (int j = 0; j < M; ++j)
                state[i][j] = Integer.parseInt(input[j]);
        }

        setArcherPositions(-1, M, 0, new ArrayList<>());
        int ret = solve(state, N, M, D);

        bw.write(Integer.toString(ret));

        br.close();
        bw.close();
    }

    public static void setArcherPositions(int lastSelected, int M, int len, ArrayList<Integer> tmpList) {
        if (len == 3)
            archerPositions.add(new ArrayList<>(tmpList));

        for (int i = lastSelected + 1; i < M; ++i) {
            tmpList.add(i);
            setArcherPositions(i, M, len + 1, tmpList);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static int solve(final int[][] state, int N, int M, int D) {
        int ret = 0;

        for (int i = 0; i < archerPositions.size(); ++i) {

            final List<Integer> archerPosition = archerPositions.get(i);
            int[][] simulationState = new int[N][M];
            int tmpRet = 0;

            for (int j = 0; j < N; ++j)
                System.arraycopy(state[j], 0, simulationState[j], 0, M);


            while (isLiveEnemy(simulationState, N, M)) {

                Pair pair1 = bfsFromArcher(simulationState, N, archerPosition.get(0), N, M, D);
                Pair pair2 = bfsFromArcher(simulationState, N, archerPosition.get(1), N, M, D);
                Pair pair3 = bfsFromArcher(simulationState, N, archerPosition.get(2), N, M, D);

                List<Pair> listPair = new ArrayList<>(List.of(pair1, pair2, pair3));

                for (int j = 0; j < 3; ++j) {
                    Pair pair = listPair.get(j);

                    if (pair.getY() == -1) continue;

                    boolean killNewEnemy = true;
                    for (int z = 0; z < j; ++z) {
                        Pair deadEnemy = listPair.get(z);

                        if (deadEnemy.getX() == pair.getX() && deadEnemy.getY() == pair.getY())
                            killNewEnemy = false;
                    }

                    if (killNewEnemy)
                        tmpRet++;
                }

                for (Pair pair : listPair) {
                    if (pair.getY() == -1) continue;

                    simulationState[pair.getY()][pair.getX()] = 0;


                }

                updateNextStage(simulationState, N, M);
            }

            ret = Math.max(ret, tmpRet);
        }

        return ret;
    }

    private static void updateNextStage(int[][] simulationState, int N, int M) {

        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < M; j++)
                simulationState[i + 1][j] = simulationState[i][j];
        }

        for (int j = 0; j < M; ++j)
            simulationState[0][j] = 0;
    }

    public static boolean isLiveEnemy(int[][] state, int N, int M) {
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < M; ++j)
                if (state[i][j] == 1) return true;

        return false;
    }

    public static Pair bfsFromArcher(int[][] state, int r, int c, int N, int M, int D) {
        boolean[][] visited = new boolean[N + 1][M];

        visited[r][c] = true;
        Queue queue = new LinkedList();
        queue.add(new Pair(r, c, 0));

        while (!queue.isEmpty()) {
            Pair currentPos = (Pair) queue.poll();

            int currentPosY = currentPos.getY();
            int currentPosX = currentPos.getX();
            int nextDistance = currentPos.getD() + 1;

            visited[currentPosY][currentPosX] = true;

            if (currentPos.getD() > D)
                return new Pair(-1, -1, D + 1);

            if (currentPos.getD() != 0 && state[currentPosY][currentPosX] == 1)
                return new Pair(currentPosY, currentPosX, currentPos.getD());

            for (int i = 0; i < 4; ++i) {
                int nextY = currentPosY + dy[i];
                int nextX = currentPosX + dx[i];

                if (isRange(nextY, nextX, N, M))
                    queue.add(new Pair(nextY, nextX, nextDistance));
            }
        }

        return new Pair(-1, -1, D + 1);
    }

    static boolean isRange(int y, int x, int N, int M) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }

    static class Pair {
        int y, x, d;

        Pair(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }

        int getY() {
            return y;
        }

        int getX() {
            return x;
        }

        int getD() {
            return d;
        }
    }
}
