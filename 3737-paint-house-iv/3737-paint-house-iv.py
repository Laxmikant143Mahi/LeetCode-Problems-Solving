from typing import List
from collections import defaultdict

class Solution:
    def minCost(self, n: int, cost: List[List[int]]) -> int:
        n_pairs = n // 2

        # Initialize the DP for the first pair (0, n-1)
        prev_dp = defaultdict(int)
        for a in range(3):
            for b in range(3):
                if a != b:
                    prev_dp[(a, b)] = cost[0][a] + cost[n-1][b]

        # Process the remaining pairs
        for k in range(1, n_pairs):
            i = k
            j = n - 1 - k
            current_dp = defaultdict(lambda: float('inf'))
            for (prev_a, prev_b), prev_cost in prev_dp.items():
                for curr_a in range(3):
                    if curr_a == prev_a:
                        continue
                    for curr_b in range(3):
                        if curr_b == prev_b or curr_b == curr_a:
                            continue
                        new_cost = prev_cost + cost[i][curr_a] + cost[j][curr_b]
                        if new_cost < current_dp[(curr_a, curr_b)]:
                            current_dp[(curr_a, curr_b)] = new_cost
            prev_dp = current_dp
            if not prev_dp:
                return -1  # This case should not occur as per problem constraints

        return min(prev_dp.values())