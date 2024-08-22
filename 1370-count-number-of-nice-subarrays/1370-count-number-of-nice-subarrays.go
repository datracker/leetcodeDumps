func numberOfSubarrays(nums []int, k int) int {
    count := 0
    oddCount := make([]int, len(nums)+1)
    oddCount[0] = 1
    oddNumbers := 0

    for _, num := range nums {
        if num%2 != 0 {
            oddNumbers++
        }
        if oddNumbers >= k {
            count += oddCount[oddNumbers-k]
        }
        oddCount[oddNumbers]++
    }

    return count
}