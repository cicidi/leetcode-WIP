package dp;

/*
 * important
 * notice
 * green
 * url
 * leetcode
 *
 *
Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been chosen. The player with the maximum score wins.

Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.

Example 1:
Input: [1, 5, 2]
Output: False
Explanation: Initially, player 1 can choose between 1 and 2.
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2).
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
Hence, player 1 will never be the winner and you need to return False.
Example 2:
Input: [1, 5, 233, 7]
Output: True
Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.

 * 分析
 * */

public class PredictTheWinner {

    public static void main(String[] args) {
//        String[] input = new String[]{
//                "wrt", "wrf", "er", "ett", "rftt"
//        };
        Solution s = new Solution();


        System.out.println();
    }

    // 1,3,2,5,2,3,5,6,7

    // 1  ->   (3,2,5,7)
    //          (3,2,5)  <-  7
    // 3    ->   (2,5)
    //              2     <- 5
    static class Solution {

        public boolean PredictTheWinner(int[] nums) {

            return helper(nums, 0, nums.length - 1) >= 0;
        }

        public int helper(int[] nums, int left, int right) {
            if (left == right) {
                return nums[left];
            }
            //important   这个nums[left]-help 求和下一层的差a值
            return Math.max(nums[left] - helper(nums, left + 1, right), nums[right] - helper(nums, left, right - 1));

        }

    }
}
