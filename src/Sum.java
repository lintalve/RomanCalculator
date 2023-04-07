import java.util.Arrays;

public class Sum {
    public static int[] twoSum(int[] nums, int target) {
        int one;
        int two;
        int[] result = {0, 1};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i);
            for (int num : nums) {
                if (nums[i] + num == target) {
                    result[0] = nums[i];
                    result[1] = num;
                    break;
                }
            }
            //return result;
        }
        return result;
    }



    public static void main(String[] args){
        int[] numbers = {2, 3, 4, 5, 6, 7, 8, 1, 9};
        int target = 9;
        int[] res = twoSum(numbers, target);
        System.out.println(Arrays.toString(res));

    }
}

