package org.example.codewars;

public class Interval {

    private int[][] intervals;
    public Interval(int[][] intervals) {
        this.intervals = intervals;
    }
    public int[][] getIntervals() {
        return intervals;
    }
    public int sumIntervals() {
        int sum = 0;
        for (int i = 0; i < intervals.length; i++) {
            sum += intervals[i][1] - intervals[i][0];
        }
        return sum;

    }
    public static void main(String[] args) {
        //int[][] intervals = {{1, 5}, {6, 10}};
        int[][] intervals = {{4, 4}, {6, 6}, {8, 8}};
        Interval interval = new Interval(intervals);
        System.out.println(interval.sumIntervals());
    }

}
