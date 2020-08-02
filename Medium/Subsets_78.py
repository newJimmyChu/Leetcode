class Solution(object):
    def subsets(self, nums):
        nums.sort()
        a = list(successors(nums, [], -1))
        a.append([])
        return a

def successors(nums, current_list, current_index):
    if len(current_list) == len(nums):
        yield current_list
    else:
        for i in range(current_index + 1, len(nums)):
            if len(current_list) != len(nums) - 1:
                yield current_list + [nums[i]]
            for elem in successors(nums, current_list + [nums[i]], i):
                yield elem
