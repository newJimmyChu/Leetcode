import math

class Solution(object):
    def judgeSquareSum(self, c):
        s = math.floor(math.sqrt(c))
        large = s
        small = 0
        flag = True
        while flag:
        	q = small ** 2 + large ** 2 
        	if large == small:
        		flag = False
        	if q < c:
        		small += 1
        	elif q > c:
        		large -= 1
        	else:
        		return True

        return False