class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] ans = new int[nums1.length];
        int j;

        for (int i = 0; i < nums1.length; i++) {
            for (j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j])
                    break;
            }
            boolean flag = false;
            int max = Integer.MIN_VALUE;
            for (int k = j + 1; k < nums2.length; k++) {
                if (nums2[k] > nums2[j]) {
                    flag = true;
                    ans[i] = nums2[k];
                    break;
                }
            }
            if (flag == false)
                ans[i] = -1;
        }
        return ans;

    }
}