class Solution:
    # @return a tuple, (index1, index2)
    def twoSum(self, num, target):
        dic = {}
        for i in range(0, len(num)):
            dic[num[i]] = i
        for i in range(0, len(num)):
            n = target - num[i]
            if n in dic and i != dic[n]:
                return (i + 1, dic[n] + 1)
