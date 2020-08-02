class Solution(object):
    def eraseOverlapIntervals(self, intervals):
    	ret_list = []
    	counter, end = -1, 0
    	intervals.sort(key=lambda x: (x[1]-x[0], x[0]))
    	if len(intervals) == 0:
    		return 0
    	ret_list.append(intervals[0])
    	for interval in intervals:
    		for target in ret_list:
				if interval[0] < target[1] or interval[1] > target[0]:
					counter += 1
    				break
    			elif interval[0] == target[1]:
					target[1] = interval[1]
  					break
				elif interval[1] == target[0]:
  					target[0] = interval[1]
  					break
  			ret_list.append(interval)
    	return counter


