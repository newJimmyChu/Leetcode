class Solution(object):
    def restoreIpAddresses(self, s):
    	if len(s) > 12 or len(s) < 4:
    		return []
    	return list(search(s, "", 0, 4))


def search(s, letter, position, level):
	if level == 1 and position < len(s) - 3:
		return
	elif level == 1:
		print(letter)
		yield letter + s[position:len(s)]
	for i in range(1, 4):
		if position + i >= len(s):
			return
		t = s[position:position+i]
		print(t)
		if t != '':
			if int(t) < 255 and position == 0:
				for a in search(s, t + '.', position + i ,level - 1):
					yield a
			elif int(t) < 255:
				for a in search(s, letter + t + '.', position + i ,level - 1):
					yield a