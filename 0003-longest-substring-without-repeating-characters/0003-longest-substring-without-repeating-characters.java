// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int left=0, max = 0;
//         Set<Character> set = new HashSet<>();
//         for(int i=0; i<s.length(); i++) {
//             while(set.contains(s.charAt(i))) {
//                 set.remove(s.charAt(left));
//                 left++;
//             }
//             set.add(s.charAt(i));
//             max = Math.max(max, i-left+1);
//         }
//     return max;
//     }
// }

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}