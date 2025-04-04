package gfg160Days_DSA;

import java.util.*;

public class Day006_FindMajority {

    // Day 6 : problem = Majority Element II
    public static List<Integer> findMajority(int[] nums) {

        List<Integer>list = new ArrayList<>();

        if(nums == null || nums.length == 0){
            return list;
        }

        Map<Integer, Integer> voteCount = new HashMap<>();
        for(int vote: nums){
            voteCount.put(vote, voteCount.getOrDefault(vote, 0) + 1);
        }

        int totalVotes = nums.length;
        int threshold = totalVotes / 3;

        for (Map.Entry<Integer, Integer> entry : voteCount.entrySet()){
            if(entry.getValue() > threshold){
                list.add(entry.getKey());
            }
        }

        list.sort(Integer::compareTo);
        return list;

    }

    public static void main(String[] args) {
        int [] nums = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
        System.out.println(findMajority(nums));
    }
}

