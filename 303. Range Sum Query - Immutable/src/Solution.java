/*
Given an integer array nums, find the sum of the elements between indices i and j (i ¡Ü j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
 */

class NumArray {
    int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        // sums[0] = nums[0]; nums may empty
        int prev = 0;
        for(int i = 0; i < nums.length; i++){
            sums[i] = nums[i] + prev;
            prev = sums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        if(i == 0) return sums[j];
        return sums[j] - sums[i-1];
    }
}



/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */