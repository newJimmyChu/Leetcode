class Solution(object):
    def merge(self, nums1, m, nums2, n):
    	ret_list = []
    	i, j = 0, 0
    	if m == 0:
    		nums1[:] = nums2[:]
    		return None
    	if n == 0:
    		return None
    	while i < n and j < n:
    		if nums1[i] <= nums2[j]:
    			ret_list.append(nums1[i])
    			i += 1
    		else:
    			ret_list.append(nums2[j])
    			j += 1
    	print(i)
    	print(j)
    	while i < n:
    		ret_list.append(nums1[i])
    		i += 1
    	while j < n:
    		ret_list.append(nums2[j])
    		j += 1
    	print(ret_list)
    	for s in range(len(nums1)):
    		nums1[s] = ret_list[s]