/*
 * @lc app=leetcode.cn id=743 lang=java
 *
 * [743] 网络延迟时间
 */

// @lc code=start
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] t : times) {
            graph.computeIfAbsent(t[0], k -> new ArrayList<>()).add(new int[] {t[1], t[2]});
        }

        int[] distTo = new int[N + 1];
        Arrays.fill(distTo, 0x3f3f3f3f);
        boolean[] visited = new boolean[N + 1];
        distTo[K] = 0;
        distTo[0] = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> distTo[a] - distTo[b]);
        q.offer(K);
        while (!q.isEmpty()) {
            Integer u = q.poll();
            if (visited[u])
                continue;
            visited[u] = true;
            List<int[]> neighbors = graph.getOrDefault(u, Collections.emptyList());
            for (int[] neighbor : neighbors) {
                int v = neighbor[0], w = neighbor[1];
                if (visited[v])
                    continue;
                distTo[v] = Math.min(distTo[v], distTo[u] + w);
                q.offer(v);
            }
        }

        int res = Arrays.stream(distTo).max().getAsInt();
        return res == 0x3f3f3f3f ? -1 : res;
    }
}
// @lc code=end

