// Minimum Index Sum of Two Lists
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String , Integer> map = new HashMap<>();
        for(int i = 0 ; i < list1.length ; i++) 
            map.put(list1[i] , i);
            int minSum = Integer.MAX_VALUE;
            ArrayList<String> result = new ArrayList<>();
            for(int i = 0 ; i < list2.length ; i++) {
                if(map.containsKey(list2[i])){
                    if(minSum > i + map.get(list2[i])) {
                        minSum = i + map.get(list2[i]);
                        result.clear();
                        result.add(list2[i]);
                    }
                    else if(minSum == i + map.get(list2[i])) {
                        result.add(list2[i]);
                    }
                }
            }
            return result.toArray(new String[result.size()]);
    }
}