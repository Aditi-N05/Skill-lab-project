class Solution:
    # Function to find values in array equal to their indices
    def valueEqualToIndex(self, arr):
        result_list = []
        for index in range(len(arr)):            #0 to n-1
            if index + 1 == arr[index]:          #         
                result_list.append(index+1)
        return result_list


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    tc = int(input())
    while tc > 0:
        arr = list(map(int, input().strip().split()))
        ob = Solution()
        ans = ob.valueEqualToIndex(arr)
        if len(ans) == 0:
            print("Not Found")
        else:
            for x in ans:
                print(x, end=" ")
            print()
        tc -= 1
        print("~")

# } Driver Code Ends
