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
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }
}