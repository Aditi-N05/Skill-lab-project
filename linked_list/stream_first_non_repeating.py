#User function Template for python3
class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

class DoublyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
    
    def append(self, data):
        new_node = Node(data)
        
        if self.head is None:
            self.head = new_node
            self.tail = new_node
            return new_node
        
        else:
            new_node.prev = self.tail
            self.tail.next = new_node
            self.tail = new_node
        return new_node
    
    def remove(self, node):
        if node is None:
            return
        
        # If node is head
        if node.prev is None:
            self.head = node.next
        else:
            node.prev.next = node.next
        
        # If node is tail
        if node.next is None:
            self.tail = node.prev
        else:
            node.next.prev = node.prev

class Solution:
    def FirstNonRepeating(self, A):
        dll = DoublyLinkedList()
        
        # Initialize arrays for tracking character status
        inDLL = [None] * 26  # To store pointers to DLL nodes
        repeated = [False] * 26  # To mark repeated characters
        
        result = []
        
        for char in A:
            ind = ord(char) - ord('a')
            
            # If character is already marked as repeated, ignore it
            if repeated[ind]:
                pass
            # If character appears for the first time
            elif inDLL[ind] is None:
                inDLL[ind] = dll.append(char)
            # If character appears for the second time
            else:
                dll.remove(inDLL[ind])
                inDLL[ind] = None
                repeated[ind] = True
            
            # Get the first non-repeating character (head of DLL)
            if dll.head:
                result.append(dll.head.data)
            else:
                result.append('#')
        
        return ''.join(result)

#{ 
 # Driver Code Starts
# Initial Template for Python 3

if __name__ == '__main__':
    T = int(input())
    for i in range(T):
        A = input()
        ob = Solution()
        ans = ob.FirstNonRepeating(A)
        print(ans)
        print("~"
              )  # This line is now outside the for loop and correctly aligned.

# } Driver Code Ends
