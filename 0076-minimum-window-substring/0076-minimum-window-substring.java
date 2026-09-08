class Solution {
    public boolean contains(int s_array[], int t_array[]) {
        for (int i = 0; i < 256; i++) {
            if (s_array[i] < t_array[i]) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int s_array[] = new int[256];
        int t_array[] = new int[256];
        int length = Integer.MAX_VALUE, minstart = 0;
        int left=0;

        for (char ch : t.toCharArray()) {
            t_array[ch]++;
        }

        for (int i = 0; i < s.length(); i++) {
            s_array[s.charAt(i)]++;

            while (contains(s_array, t_array)) {
                if (i - left + 1 < length) {
                    length = i - left + 1;
                    minstart = left;
                }
                s_array[s.charAt(left)]--;
                left++;
            }
        }

        return (length == Integer.MAX_VALUE) ? "" : s.substring(minstart, minstart + length);

    }
}