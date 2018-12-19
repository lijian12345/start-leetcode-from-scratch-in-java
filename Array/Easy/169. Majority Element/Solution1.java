import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            if (m.containsKey(num)) {
                m.put(num, m.get(num) + 1);
            } else {
                m.put(num, 1);
            }
        }

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            if (majorityEntry == null || majorityEntry.getValue() < entry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }
}