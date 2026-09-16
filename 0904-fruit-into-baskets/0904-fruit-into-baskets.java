class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0; int max = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);

            while(map.size() > 2) {
                //reduce the frequency of the left element
                map.put(fruits[left], map.get(fruits[left]) - 1);

                //now remove it from the map if {key : 0}, i.e value is 0
                if(map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);  // hata do map se
                }
                left++;
            }

            max = Math.max(max, i - left + 1);    // length is the distance between left and right
        }
        return max;
    }
}