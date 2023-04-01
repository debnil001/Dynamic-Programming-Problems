/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author HP
 */
class FrogJumps {
    public boolean canCross(int[] stones) {
        HashMap<Integer,HashSet<Integer>> hm=new HashMap<>();
        for(int i=0;i<stones.length;i++){
            hm.put(stones[i],new HashSet<>());
        }
        hm.get(stones[0]).add(1);
        for(int stone:stones){
            for(int jump:hm.get(stone)){
                if(jump!=0 && hm.containsKey(stone+jump)){
                    hm.get(stone+jump).add(jump-1);
                    hm.get(stone+jump).add(jump);
                    hm.get(stone+jump).add(jump+1);
                }
            }
        }
        return !hm.get(stones[stones.length-1]).isEmpty();
    }
}
