package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonElementsSorted {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(13, 27, 35, 40, 49, 55, 59);
        List<Integer> list2 = Arrays.asList(17, 35, 39, 40, 55, 58, 60);
        
        System.out.println(commonElements(list1, list2));
    }
    
    private static List<Integer> commonElements(List<Integer> list1, List<Integer> list2) {
        List<Integer> listOfCommons = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        
        while (true) {
            if (index1 == list1.size() || index2 == list2.size())
                break;
            
            if (list1.get(index1).equals(list2.get(index2))) {
                listOfCommons.add(list1.get(index1));
                index1++;
                index2++;
            } else if (list1.get(index1) > list2.get(index2)) {
                index2++;
            } else {
                index1++;
            }
        }
        
        return listOfCommons;
    }

}
