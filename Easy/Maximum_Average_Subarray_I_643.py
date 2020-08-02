class Solution(object):
    def findMaxAverage(self, nums, k):
        max_val = float("-inf")
        s = 0
        if nums == []:
        	return 0
        if len(nums) == 1:
        	return nums[0]
        sum_list = [0 for elem in range(len(nums)+1)]
        sum_list[0] = 0
        for i in range(0, len(nums)):
        	sum_list[i+1] = sum_list[i] + nums[i]
       	if len(nums) == k:
       		print(sum_list)
       		return (sum_list[len(sum_list)-1]*1.0) / (k*1.0)
        for i in range(k, len(nums)+1):
        	if max_val < sum_list[i]-sum_list[i-k]:
        		max_val = sum_list[i]-sum_list[i-k]
        return (max_val * 1.0) / (k * 1.0)