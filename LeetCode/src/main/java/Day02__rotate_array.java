public class Day02__rotate_array {
    /**
     *  给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     */

    public static void rotateArray(int[] nums, int k) {
        k = k % nums.length;
        //翻转数组
        rotate(nums,0,nums.length-1);
        //翻转前k个
        rotate(nums,0,k-1);
        //翻转后n-k个
        rotate(nums,k,nums.length-1);

    }


    public static void rotate(int[] nums,int start, int end){
        int temp;
        while (start < end){
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void retateArrayCircleReplace(int[] nums, int k){
        //保证每个元素都要被替换过
        int count = 0;
        k = k % nums.length;
        //终止条件  count 用来计数  count = nums.length
        //当出现特殊情况，比如数组长度 % k = 0,实际上进行了 数组长度/k次，此时已经回到了第一次替换元素的位置
        //要在第一次元素位置的后一位开始继续执行
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int pre = nums[start];  //上一个被替换的元素值
            do{
                int next = (k+current) % nums.length;
                //nums[start]->nums[cur]
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                current =next;
                count++;

            }while (current != start);    // 判断条件是  start == cur  start++
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
       // rotateArray(nums,3);
        retateArrayCircleReplace(nums,3);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}