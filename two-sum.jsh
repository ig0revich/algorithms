//usr/bin/env jshell -R -ea "$0" "$@"; exit $?
/* 
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6

Output: [0,1] */

/* Complexity Analysis
Time complexity: O(n^2). For each element, we try to find its complement by looping through the rest of array which takes O(n) time. Therefore, the time complexity is O(n^2).
Space complexity : O(1) */
int[] twoSumBruteForce(int[] nums, int target) {
   for(int i=0; i<nums.length; i++) {
      for(int j=i+1; j<nums.length; j++) {
         if(target == nums[i] + nums[j]) {
            return new int[]{i,j};
         }
      }
   }
   throw new IllegalArgumentException("No matching indexes could be found!"); 
}

/* Complexity Analysis:
Time complexity: O(n). We traverse the list containing n elements exactly twice. Since the hash table reduces the look up time to O(1), the time complexity is O(n).
Space complexity: O(n). The extra space required depends on the number of items stored in the hash table, which stores exactly n elements. */
int[] twoSumTwoPassHashTable(int nums[], int target) {
   Map<Integer, Integer> map = new HashMap<>(nums.length);
   for(int i = 0; i< nums.length; i++) {
      map.put(nums[i], i);
   }
   for(int i=0; i< nums.length; i++) {
      int complement = target - nums[i];
      if(map.containsKey(complement) && map.get(complement) != i) {
         return new int[]{i, map.get(complement)};
      }
   }
   throw new IllegalArgumentException("No matching indexes could be found!"); 
}

/* Complexity Analysis:
Time complexity: O(n). We traverse the list containing n elements only once. Each look up in the table costs only O(1) time.
Space complexity: O(n). The extra space required depends on the number of items stored in the hash table, which stores at most n elements */
int[] twoSumOnePassHashTable(int nums[], int target) {
   Map<Integer, Integer> map = new HashMap<>(nums.length);
   for(int i=0; i< nums.length; i++) {
      int complement = target - nums[i];
      if(map.containsKey(complement)) {
         return new int[]{map.get(complement), i};
      }
      map.put(nums[i], i);
   }
   throw new IllegalArgumentException("No matching indexes could be found!"); 
}

assert Arrays.equals(
   new int[]{0,1}, 
   twoSumBruteForce(new int[]{2, 7, 11, 2}, 9))

assert Arrays.equals(
   new int[]{3,7}, 
   twoSumBruteForce(new int[]{0, 77, 2, 7, 11, 2, 20, 111}, 118))

assert Arrays.equals(
   new int[]{0,1}, 
   twoSumTwoPassHashTable(new int[]{2, 7, 11, 2}, 9))

assert Arrays.equals(
   new int[]{3,7}, 
   twoSumOnePassHashTable(new int[]{0, 77, 2, 7, 11, 2, 20, 111}, 118))

assert Arrays.equals(
   new int[]{0,1}, 
   twoSumOnePassHashTable(new int[]{2, 7, 11, 2}, 9))

assert Arrays.equals(
   new int[]{3,7}, 
   twoSumTwoPassHashTable(new int[]{0, 77, 2, 7, 11, 2, 20, 111}, 118))

/exit
