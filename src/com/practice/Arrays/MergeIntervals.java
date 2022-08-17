package com.practice.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    static class Interval {
        public int first;
        public int second;

        public Interval(int x, int y) {
            this.first = x;
            this.second = y;
        }
    }


    public static void main(String[] args) {
        Interval[] v1 = {new Interval(1, 5), new Interval(3, 7), new Interval(4, 6)};
        Interval[] v2 = {new Interval(1, 5), new Interval(4, 6), new Interval(6, 8), new Interval(11, 15)};
        Interval[] v3 = {new Interval(3, 7), new Interval(6, 8), new Interval(10, 12), new Interval(11, 15)};
        Interval[] v4 = {new Interval(1, 5)};

        mergeIntervals(v1);
        mergeIntervals(v2);
        mergeIntervals(v3);
        mergeIntervals(v4);


    }

    private static void mergeIntervals(Interval[] v1) {
        ArrayList<Interval> list = new ArrayList<>(Arrays.asList(v1));
        ArrayList<Interval> result=new ArrayList<>();
        result.add(new Interval(list.get(0).first,list.get(0).second));
        for (int i = 1; i < list.size(); i++) {
            int second = result.get(result.size()-1).second;
            if(isInBetween(second,list.get(i).first)){
                result.get(result.size()-1).second=Math.max(list.get(i).second,result.get(result.size()-1).second);
            }else{
                result.add(new Interval(list.get(i).first,list.get(i).second));
            }

        }
        String result_str = "";
        for (int j = 0; j < result.size(); j++) {
            result_str += "[" + result.get(j).first + ", " + result.get(j).second + "] ";
        }
        System.out.println("   Merged intervals:\t" + result_str);
        
    }

    private static Boolean isInBetween(int second, int interval) {
        if(second>= interval){
            return true;
        }
        return false;
    }


}
