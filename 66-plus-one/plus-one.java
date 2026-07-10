class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        // First Check that last Digit is 9 or not
        if (digits[n - 1] != 9) {
            digits[n - 1] = digits[n - 1] + 1;
            return digits;
        }
        //Add 1 in the last Digit
        digits[n - 1] = digits[n - 1] + 1;

        // new Array because of adding last digit size of array should be increase 
        int[] arr = new int[n + 1];
        int len = arr.length;
        int carry = 0;
        for (int i = len - 1; i >= 1; i--) {
            int sum = digits[i - 1] + carry;
            if (sum == 10) {
                arr[i] = 0;
                carry = 1;
            } else {
                arr[i] = sum;
                carry = 0;
            }
        }
        if (carry == 1) {
            arr[0] = carry;
            return arr;
        }
        // Means our size of digits array should not be increases
        else {
            for (int i = 0; i < n; i++) {
                digits[i] = arr[i + 1];
            }
            return digits;
        }
    }
}