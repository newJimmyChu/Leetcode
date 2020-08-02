class Solution(object):
    def twoSum(self, numbers, target):
        large = len(numbers) - 1
        small = 0
        while large != small:
        	if numbers[large] + numbers[small] > target:
        		large -= 1
        	elif numbers[large] + numbers[small] < target:
        		small += 1
        	else:
        		return [small + 1, large + 1]