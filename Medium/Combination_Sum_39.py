class Solution(object):
    def combinationSum(self, candidates, target):
        if candidates == []:
            return []
        ret_list = []
        for d in successors(candidates, {}, 0, target, []):
            t = []
            for key, value in d.items():
                for i in range(value):
                    t.append(key)
            ret_list.append(t)
        return ret_list


def successors(candidates, current_dict, current_sum, target, d):
    if current_sum == target:
        if current_dict not in d:
            d.append(current_dict)
            yield current_dict
    else:
        for elem in candidates:
            if current_sum + elem <= target:
                c = dict(current_dict)
                if elem in current_dict:
                    c[elem] += 1
                else:
                    c[elem] = 1
                for ls in successors(candidates, c, current_sum + elem, target, d):
                    yield ls
