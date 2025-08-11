package leetcode;
import java.util.HashMap;

//solution 1: find the maximum of element

class Solution {
    public int majorityElement(int[] nums) {
        int num = 0;
        int quantity = 0;
        for (int i : nums) {
            if (quantity == 0) num = i;
            if (i == num) quantity++;
            else quantity--;
        }
        return num;
    }
}

//solution 2: Hash map

class Solution2 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> mapCounting = new HashMap<>();
        float standart = nums.length / 2;
        int result = 0;
        for (int num : nums) {
            if (mapCounting.containsKey(num)) {
                mapCounting.put(num,mapCounting.get(num) +1 );
            }else {
                 mapCounting.put(num,1 );
            }
        }
        for (int i : mapCounting.keySet()) {
            if (mapCounting.get(i) > standart ) result = i;
        }
        return result;
    }
}