class Solution(object):
    def reconstructQueue(self, people):
        people.sort(key=lambda x: (x[1], x[0]))
        index, counter = 0, 0
        for elem in people:
        	if elem[1] != 0:
        		for i in range(index):
        			if people[i][0] >= elem[0]:
        				counter += 1
        		if elem[1] - counter != 0:
        			people.remove(elem)
        			people.insert(index+elem[1]-counter, elem)
        	counter = 0
        	index += 1
        return people

class Solution(object):
    def reconstructQueue(self, people):
        people.sort(key=lambda x: (-x[0], x[1]))
        ret_list = []
        for elem in people:
        	ret_list.insert(elem[1], elem)
        return ret_list


