package code.leet.b75.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {

    int[] solveBrute(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if (i != j && target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     *
     * Time: O(n*log(n))
     * Space: O(n)
     */
    int[] solveBetter(int[] nums, int target) {
        int[] sortedNums = (int[])Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        boolean found = false;
        int x = nums[0], y = target - x;

        for(int i = 0; i < sortedNums.length; i++) {
            x = sortedNums[i];
            y = target - x;
            int left = i + 1, right = sortedNums.length - 1;
            int median;
            while(left <= right) {
                median = (left + right) / 2;
                if(y == sortedNums[median]) {
                    found = true;
                    break;
                } else if (y > sortedNums[median]) {
                    left = median + 1;
                } else {
                    right = median - 1;
                }
            }
            if (found) {
                break;
            }
        }

        int xind = -1, yind = -1;
        if(found) {
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == x) {
                    xind = i;
                }
            }
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] == y && i != xind) {
                    yind = i;
                }
            }
        }
        return new int[]{xind, yind};
    }

    /**
     * Time: O(n)
     * Space: Hash
     */
    int[] solveEvenBetter(int nums[], int target) {
        HashMap<int, int> map = new HashMap<int, int>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int key: map.keySet()) {
            if(map.containsKey(target-key)) {
                return new int[]{map.get(key), map.get(target-key)};
            }
        }
        return new int[]{-1, -1};
    }
}
