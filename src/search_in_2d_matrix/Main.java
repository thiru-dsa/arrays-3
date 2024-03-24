package search_in_2d_matrix;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayListOfArrayList = new ArrayList<>();

        ArrayList<Integer> innerList1 = new ArrayList<>();
        innerList1.add(1);
        innerList1.add(2);
        innerList1.add(3);
        innerList1.add(4);
        arrayListOfArrayList.add(innerList1);

        ArrayList<Integer> innerList2 = new ArrayList<>();
        innerList2.add(5);
        innerList2.add(6);
        innerList2.add(7);
        innerList2.add(8);
        arrayListOfArrayList.add(innerList2);

        ArrayList<Integer> innerList3 = new ArrayList<>();
        innerList3.add(9);
        innerList3.add(10);
        innerList3.add(11);
        innerList3.add(12);
        arrayListOfArrayList.add(innerList3);

        System.out.println(BruteForce.searchMatrix(arrayListOfArrayList, 12));
        System.out.println(Better.searchMatrix(arrayListOfArrayList, 12));
    }
}

//    Approach : - loop through all elements and find whether it is present or not
//    Time complexity  : O(m*n)
//    Space complexity : O(1)
class BruteForce {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        for(int iterator = 0; iterator < mat.size(); iterator++) {
            for(int jterator = 0; jterator < mat.get(iterator).size(); jterator ++) {
                if(mat.get(iterator).get(jterator) == target) {
                    return true;
                }
            }
        }


        return false;
    }
}

//    Approach : - consider the m*n 2d matrix to a m*n length of 1d array and perform binary search
//    Time complexity  : O(log(n*m))
//    Space complexity : O(1)
class Better {

    static boolean searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        int n = matrix.size();
        int m = matrix.get(0).size();

        //apply binary search:
        int low = 0, high = n * m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / m, col = mid % m;
            if (matrix.get(row).get(col) == target) return true;
            else if (matrix.get(row).get(col) < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

}