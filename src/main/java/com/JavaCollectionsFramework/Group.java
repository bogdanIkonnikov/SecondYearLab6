package com.JavaCollectionsFramework;
import lombok.Data;

@Data
public class Group {
    private int id;
    private int[] nums;

    public Group(int id, int[] nums) {
        this.id = id;
        this.nums = nums;
    }

    public int getCountOfNums(){
        return nums.length;
    }
}
