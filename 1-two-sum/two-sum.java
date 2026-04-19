class Solution {
    public int[] twoSum(int[] arr, int target) {
        int[] ans = new int[2];
        for(int i=0;i<arr.length;i++){
            boolean flag=false;
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==target)
                {
                    ans[0]=i;
                    ans[1]=j;
                    flag=true;
                    break;
                }
                if(flag==true) break;
            }
        }
        return ans;
        
    }
}