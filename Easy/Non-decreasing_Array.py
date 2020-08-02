class Solution(object):
    def checkPossibility(self, nums):
    	i = 1
        flag = 0
    	if len(nums) <= 1:
    		return True
    	if nums[0] > nums[1]:
    		nums.remove(nums[0])
    		flag = 1
    	while i < len(nums):
    		if nums[i] < nums[i-1]:
    			if flag == 1:
    				return False
    			flag += 1
    			nums.remove(nums[i-1])
    			i -= 1
    			continue
    		i += 1
        return True