class Solution(object):
    def findMinArrowShots(self, points):
    	points.sort(key = lambda x: x[0])
    	if len(points) == 0:
    		return 0
    	intersects = [] 
    	intersects.append(points[0])
    	for point in points:
    		intersect = intersects[len(intersects) - 1]
    		if point[0] > intersect[1]:
    			intersects.append(point)
      		else:
      			if point[0] >= intersect[0]:
      				intersect[0] = point[0]
      			if point[1] <= intersect[1]:
      				intersect[1] = point[1]
        return len(intersects)