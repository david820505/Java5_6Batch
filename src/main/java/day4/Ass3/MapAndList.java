package day4.Ass3;

import java.util.*;

public class MapAndList {
    public static void main(String[] args) {
        List<Integer> listA = new ArrayList<>(Arrays.asList(1,2,3,4,10));
        Map<String,String> mapB = new HashMap<>();
        mapB.put("a","1");
        mapB.put("b","2");
        mapB.put("c","10");
        List<Integer> result = filterList(listA,mapB);

        for(int i = 0; i< result.size();i++){
            System.out.println(result.get(i));
        }
    }

    public static List<Integer> filterList(List<Integer> listA, Map<String,String> mapB){
        Set<Integer> nums = new HashSet<>();
        for(Map.Entry<String,String> m: mapB.entrySet()){
            nums.add(Integer.valueOf(m.getValue()));
        }

        List<Integer> res = new ArrayList<>();

        for(Integer x: listA){
            if(!nums.contains(x))
                res.add(x);
        }

        return res;
    }
}
