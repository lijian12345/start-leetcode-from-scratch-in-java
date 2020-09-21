/*
 * @lc app=leetcode.cn id=684 lang=java
 *
 * [684] 冗余连接
 */

// @lc code=start
public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UF uf = new UF(n);
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (uf.connect(u, v)) {
                return new int[] {u, v};
            }
            uf.union(u, v);
        }
        return new int[] {-1, -1};
    }
}


class UF {
    int[] parent;

    public UF(int n) {
        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        parent[pRoot] = qRoot;
    }

    public int find(int p) {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public boolean connect(int p, int q) {
        return find(p) == find(q);
    }
}
// @lc code=end

