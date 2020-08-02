class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
    	if flowerbed == []:
    		return False
    	if flowerbed == [0]:
    		return True
        if flowerbed[0] == 0 and flowerbed[1] == 0:
        	flowerbed[0] = 1
        	n -= 1
        index = 1
        while index < len(flowerbed)-1:
        	if flowerbed[index-1] == 0 and flowerbed[index] == 0 and flowerbed[index+1] == 0:
        		flowerbed[index] = 1
        		n -= 1
        		index += 1
        	index += 1
        if flowerbed[len(flowerbed)-1] == 0 and flowerbed[len(flowerbed)-2] == 0:
        	n -= 1
        if n > 0:
        	return False
        return True