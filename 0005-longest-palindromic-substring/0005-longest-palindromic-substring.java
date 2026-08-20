class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;

            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                left--;
            }

            while (right < s.length() && s.charAt(right) == s.charAt(i)) {
                right++;
            }

            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right))
                    break;
                left--;
                right++;
            }
            left++;

            //if the current length is longest than og, then update the l and r
            if (end - start < right - left) {
                start = left;
                end = right;
            }

        }
        return s.substring(start, end);
    }
}