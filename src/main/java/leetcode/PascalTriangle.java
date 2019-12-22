package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle
 */
public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> newRow = new ArrayList<>();
            
            newRow.add(1);
            if (i == 0) {
            	pascalTriangle.add(newRow);
            	continue;
            }
            
            List<Integer> lastRow = pascalTriangle.get(pascalTriangle.size() - 1);
            for (int j = 0; j < lastRow.size() - 1; j++) {
            	newRow.add(lastRow.get(j) + lastRow.get(j+1));
            }
            newRow.add(1);
            pascalTriangle.add(newRow);
        }
        
        return pascalTriangle;
    }
}
