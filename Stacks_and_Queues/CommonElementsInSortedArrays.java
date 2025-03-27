import java.util.*;

public class CommonElementsInSortedArrays {
    public static List<Integer> findCommonElements(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0, j = 0, k = 0; 
        List<Integer> result = new ArrayList<>();
        
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                if (result.isEmpty() || result.get(result.size() - 1) != arr1[i]) 
                { 
                    result.add(arr1[i]);
                }
                i++;
                j++;
                k++;
            }
           
            else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }

        return result.isEmpty() ? List.of(-1) : result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 10, 20, 40, 80};
        int[] arr2 = {6, 7, 20, 80, 100};
        int[] arr3 = {3, 4, 15, 20, 30, 70, 80, 120};

        List<Integer> commonElements = findCommonElements(arr1, arr2, arr3);
        System.out.println(commonElements);
    }
}
