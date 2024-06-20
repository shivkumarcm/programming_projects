package code.leet.b75.array;

/**
 * https://leetcode.com/problems/product-of-array-except-self/description/
 */
public class ProductArrayExceptSelf {
    int[] solve(int[] nums) {
        int[] prefix_prods = new int[nums.length];

        prefix_prods[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            prefix_prods[i] = prefix_prods[i-1]*nums[i-1];
        }

        int suffix_prod = 1;
        for(int j = nums.length-1; j>= 0; j--) {
            prefix_prods[j] *= suffix_prod;
            suffix_prod*=nums[j];
        }
        return prefix_prods;
    }
}
