class Solution(object):
    def permute(self, nums):
        print_list = []
        return list(successors(nums, print_list))


def successors(nums, print_list):
    if len(nums) == len(print_list):
        yield print_list
    for elem in nums:
        if elem not in print_list:
            for l in successors(nums, print_list + [elem]):
                yield l
