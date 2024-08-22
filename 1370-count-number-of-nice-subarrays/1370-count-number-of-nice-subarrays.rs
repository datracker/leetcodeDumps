impl Solution {
    pub fn number_of_subarrays(nums: Vec<i32>, k: i32) -> i32 {        
        let mut count = 0;
        let mut odd_count = vec![0; nums.len() + 1];
        odd_count[0] = 1;
        let mut odd_numbers = 0;

        for &num in &nums {
            if num % 2 != 0 {
                odd_numbers += 1;
            }
            if odd_numbers >= k {
                count += odd_count[(odd_numbers - k) as usize];
            }
            odd_count[odd_numbers as usize] += 1;
        }

        count
    }
}