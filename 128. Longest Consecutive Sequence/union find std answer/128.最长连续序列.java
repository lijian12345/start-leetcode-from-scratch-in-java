/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    class UnionFind {
        private int count;
        private Map<Integer, Integer> parent; // (curr, leader)

        UnionFind(int[] arr) {
            count = arr.length;
            parent = new HashMap<>();
            for (int v : arr)
                parent.put(v, v); // 初始时，各自为战，自己是自己的领队
        }

        // 结盟
        void union(int p, int q) {
            // 不只是 p 与 q 结盟，而是整个 p 所在队伍 与 q 所在队伍结盟
            // 结盟需各领队出面，而不是小弟出面
            Integer rootP = find(p), rootQ = find(q);
            if (rootP == rootQ)
                return;
            if (rootP == null || rootQ == null)
                return;

            // 结盟
            parent.put(rootP, rootQ); // 谁大听谁
            // 应取 max，而本题已明确 p < q 才可这么写
            // 当前写法有损封装性，算法题可不纠结

            count--;
        }

        // 查找领队
        Integer find(int p) {
            if (!parent.containsKey(p))
                return null;

            // 递归向上找领队
            int root = p;
            while (root != parent.get(root))
                root = parent.get(root);

            // 路径压缩：扁平化管理，避免日后找领队层级过深
            while (p != parent.get(p)) {
                int curr = p;
                p = parent.get(p);
                parent.put(curr, root);
            }

            return root;
        }
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        // 首次遍历，与邻居结盟
        UnionFind uf = new UnionFind(nums);
        for (int v : nums)
            uf.union(v, v + 1); // uf.union() 结盟

        // 二次遍历，记录领队距离
        int max = 1;
        for (int v : nums)
            max = Math.max(max, uf.find(v) - v + 1); // uf.find() 查找领队
        return max;
    }
}
// @lc code=end

