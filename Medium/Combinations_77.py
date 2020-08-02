class Solution(object):
    def combine(self, n, k):
        if n < 1 or n < k:
            return None
        return list(successors(n, [], 0, k, 0))


def successors(n, print_list, level, k, current_num):
    if level == k:
        yield print_list
    else:
        for i in range(current_num + 1, n + 1):
            for elem in successors(n, print_list + [i], level + 1, k, i):
                yield elem
