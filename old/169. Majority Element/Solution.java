import java.util.*;

class Solution {
    private class ValueComparator implements Comparator<Map.Entry<Integer, Integer>> {
        public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2) {
            return m2.getValue() - m1.getValue();
        }
    }

    public int majorityElement(int[] nums) {
        // int min = nums.length / 2;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i])) {
                m.put(nums[i], m.get(nums[i]) + 1);
            } else {
                m.put(nums[i], 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        list.addAll(m.entrySet());
        Solution.ValueComparator vc = new ValueComparator();
        Collections.sort(list, vc);
        return list.get(0).getKey();
    }
}