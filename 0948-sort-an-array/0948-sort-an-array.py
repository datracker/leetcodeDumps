class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        return self.mergeSort(nums)
    
    def mergeSort(self, nums: List[int]) -> List[int]:
        if (len(nums) <= 1):
            return nums
        
        mid = len(nums) // 2
        leftSorted = self.mergeSort(nums[ :mid])
        rightSorted = self.mergeSort(nums[mid: ])

        return self.merge(leftSorted, rightSorted)
        
    def merge(self, nums1: List[int], nums2: List[int]) -> List[int]:
        left = 0
        right = 0
        res = []

        while (left < len(nums1) and right < len(nums2)):
            if (nums1[left] < nums2[right]):
                res.append(nums1[left])
                left += 1
            else:
                res.append(nums2[right])
                right += 1
        
        while (left < len(nums1)):
            res.append(nums1[left])
            left += 1
        
        while (right < len(nums2)):
            res.append(nums2[right])
            right += 1
        
        return res
