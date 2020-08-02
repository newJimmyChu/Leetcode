class Solution(object):
    def numberOfArithmeticSlices(self, A):
        if A == []:
            return 0
        dp = [0 for x in A]
        t, inv, sum = 0, -99, 0
        for i in range(1, len(A)):
            if A[i] - A[i - 1] == inv:
                t += 1
                dp[i] = dp[i - 1] + t
            else:
                sum += dp[i - 1]
                inv = A[i] - A[i - 1]
                t = 0
        sum += dp[len(A) - 1]
        return sum
