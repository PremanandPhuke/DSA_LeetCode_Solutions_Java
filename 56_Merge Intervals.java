// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

// Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// Example 2:

// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

// Constraints:

// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104


class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));

        LinkedList<int[]> list= new LinkedList<>();

        for(int[] interval : intervals){

            if( list.isEmpty() || list.getLast()[1] < interval[0]){
                list.add(interval);
            }
            else{
                list.getLast()[1]= Math.max(list.getLast()[1], interval[1]);
            }

        }
        
        return list.toArray(new int[list.size()][]);
    }
}
