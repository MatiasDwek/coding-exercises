package other;

import java.util.ArrayList;
import java.util.List;

public class ListMerger {
	
	public static void main(String[] args) {
		List<?> listTest = new ArrayList<Integer>();
		
		List<Integer> list1, list2;
		list1 = new ArrayList<Integer>();
		list2 = new ArrayList<Integer>();
		
		list1.add(1);
		list1.add(2);
		list1.add(2);
		list1.add(5);
		list1.add(7);
		
		
		list2.add(4);
		list2.add(4);
		list2.add(5);
		list2.add(8);
		
		ListMerger merger = new ListMerger();
		System.out.println(merger.mergeLists(list1, list2));
	}
	
	private List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
		List<Integer> mergedList = new ArrayList<Integer>();
		int i1 = 0, i2 = 0;
		while (true) {
			if (i1 == list1.size()) {
				mergedList.addAll(list2.subList(i2, list2.size()-1));
				return mergedList;
			} else if (i2 == list2.size()) {
				mergedList.addAll(list1.subList(i1, list1.size()-1));
				return mergedList;
			}
			
			if (list1.get(i1) <= list2.get(i2))
				mergedList.add(list1.get(i1++));
			else
				mergedList.add(list2.get(i2++));
		}
	}
	
	private List<Integer> mergeLists2(List<Integer> list1, List<Integer> list2) {
		List<Integer> mergedList = new ArrayList<>();
		int i = 0, j = 0;
		
		while (true) {
			Integer integerList1 = list1.get(i);
			Integer integerList2 = list2.get(j);
			
			if (integerList1 < integerList2) {
				mergedList.add(integerList1);
				
				if (i != list1.size()-1) {
					i++;
					continue;
				}
			} else {
				mergedList.add(integerList2);
				
				if (j != list2.size()-1) {
					j++;
					continue;
				}
			}
			return mergedList;
		}
		
	}
}
