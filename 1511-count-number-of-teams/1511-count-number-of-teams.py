class Solution:
    def numTeams(self, rating: List[int]) -> int:
        n = len(rating)
        count = 0        
        for i in range(1, n-1):
            smallLeft = 0 
            bigRight = 0
            for j in range(0, i):
                if (rating[j] < rating[i]):
                    smallLeft += 1
            for j in range(i+1, n):
                if (rating[j] > rating[i]):
                    bigRight += 1
            
            count += (smallLeft * bigRight)
            bigLeft = i - smallLeft
            smallRight = n - 1 - i - bigRight
            count += (bigLeft * smallRight)

        return count