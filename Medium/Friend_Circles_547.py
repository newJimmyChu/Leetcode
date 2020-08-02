class Solution(object):
    def findCircleNum(self, M):
    	p_list = [[] for x in M]
        for i in range(len(M)):
        	for j in range(i, len(M)):
        		if M[i][j] == 1:
        			p_list[i].append(j)
        q = []
        count, k, m = 0, 0, 0
        visited = set()
        for i in range(len(M)):
            for elem in p_list[i]:
                k = elem
                count += 1
                while k < len(M):
                    print(p_list[k])
                    if p_list[k] != []:
                        m = k
                        k = p_list[k].pop(0)
                        if k in visited:
                            count -= 1
                            break
                        if m == k:
                            visited.add(k)
                            if p_list[k] == []:
                                break
                    elif k in visited:
                        count -= 1
                        print(k)
                        break
                    else:
                        print(k)
                        break
        return count