1.删除排序数组中的重复项
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int newSize = 0;
        for(int i = 1;i < len;++i){
            if(nums[i] != nums[newSize]){
                nums[++newSize] = nums[i];
            }
        }
        return newSize + 1;
    }



2.两数之和
    public int[] twoSum(int[] nums, int target) {
        //1.暴力解法
    //     if(nums.length < 2){
    //         return null;
    //     }
    // int[] result = new int[2];
    // outer:for(int i = 0;i < nums.length - 1;i++){
    //     for(int j = i + 1 ;j < nums.length ; j++){
    //         if(nums[i] + nums[j] == target){
    //             result[0] = i;
    //             result[1] = j;
    //             break outer;
    //         }
    //     }
    // }

    // return result;
    //利用hashMap解法：
    int len = nums.length;
    int[] result = new int[2];
            if(len < 2){
            return result;
        }

HashMap<Integer,Integer> map = new HashMap();

    for (int i = 0;i < len;++i) {

            if (map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;

                return result;
            } 

            map.put(nums[i],i);
        }

        return result;
    }

3.移动0
    public void moveZeroes(int[] nums) {
        // method1:
        int len = nums.length;
        int low = 0;
        for (int i = 0; i < len;i++){
            if (nums[i] != 0){
                nums[low] = nums[i];
                if (low != i) {
                    nums[i] = 0;
                }
                low++;
            }
        }

        //method2:先把非零的放在前面,后面再补全0
        // int len = nums.length;
        // int low = 0;
        // for (int i = 0; i < len; i++){
        //     if (nums[i] != 0){
        //         nums[low++] = nums[i];
        //     }
        // }

        // for(int j = low;j < len;j++){
        //     nums[j] = 0;
        // }
    }

4.合并两个数组
   使用双指针没写出来，最后突然想到了先拷贝再排序，感觉，面试的时候是不是不能这样写？
    System.arraycopy(nums2,0,nums1,m,n);
    Arrays.sort(nums1);