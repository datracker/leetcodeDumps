class Solution:
    def winningPlayerCount(self, n: int, pick: List[List[int]]) -> int:
        map = defaultdict(int)
        for pair in pick:
            map[tuple(pair)] += 1
        
        winners = set()
        for key, val in map.items():
            if val > key[0]:
                winners.add(key[0])
        
        return len(winners)
        