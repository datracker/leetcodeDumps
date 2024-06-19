class Solution {
    // public boolean judgeSquareSum(int c) {
    //     //we do binary search for one variable, and for other use exhaustive search

    //     int a = 0;
    //     int a2 = 0;
    //     int b2 = c;

    //     int left = 0;
    //     int right = (int) Math.sqrt(c);
    //     while (a2 <= c) {
    //         b2 = c - a2;
    //         //the value of b can be from 0 to rootC
    //         if (binarySearch(left, right, b2)) {
    //             return true;
    //         }
    //         a++;
    //         a2 = a*a;
    //     }

    //     return false;
    // }

    // boolean binarySearch(int left, int right, int target) {

    //     while (left <= right) {
    //         int mid = left + (right-left)/2;
    //         int midSquared = mid*mid;
    //         if (midSquared == target) {
    //            return true;
    //         }
    //         else if (midSquared > target) {
    //             right = mid-1;
    //         }
    //         else {
    //             left = mid+1;
    //         }
    //     }

    //     return false;
    // }

    
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b = c - (int)(a * a);
            if (binary_search(0, b, b))
                return true;
        }
        return false;
    }
    public boolean binary_search(long s, long e, int n) {
        if (s > e)
            return false;
        long mid = s + (e - s) / 2;
        if (mid * mid == n)
            return true;
        if (mid * mid > n)
            return binary_search(s, mid - 1, n);
        return binary_search(mid + 1, e, n);
    }
}