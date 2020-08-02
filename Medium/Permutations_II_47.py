class Solution(object):
    def permuteUnique(self, nums):
        index_list = [i for i in range(len(nums))]
        visited = []
        return list(successors(nums, [], [], visited))


def successors(nums, currrent_list, index_list, visited):
    if len(currrent_list) == len(nums):
        if currrent_list not in visited:
            visited.append(currrent_list)
            yield currrent_list
    else:
        for i, elem in enumerate(nums):
            if i not in index_list:
                for ls in successors(nums, currrent_list + [elem], index_list + [i], visited):
                    yield ls
