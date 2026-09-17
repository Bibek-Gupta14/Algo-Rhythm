class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1_freq[] = new int[26];  // only lowercase
        int s2_freq[] = new int[26];  

        if(s1.length() > s2.length()) return false;

        // initialise the window 
        for(int i=0; i<s1.length(); i++) {          // s1 = ab, -> thats why s1.length
            s1_freq[s1.charAt(i) - 'a']++;
            s2_freq[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(s1_freq, s2_freq)) {          // what if s1 = 'ab' and s2 = 'bac' -> first one only
            return true;
        }

        for(int i=1; i<s2.length() - s1.length()+1; i++) {  

            //slide the window
            s2_freq[s2.charAt(i-1) - 'a']--;   // remove the 1st element of window
            s2_freq[s2.charAt(i + s1.length() - 1) - 'a']++;   // add the new element to window
            
            if(Arrays.equals(s1_freq, s2_freq)) {
                return true;
            }
            
        }
        return false;
    }

    // private boolean is_Matched(int s1_freq[], int s2_freq[]) {
    //     for(int i=0 ;i<26; i++) {
    //         if(s1_freq[i] != s2_freq[i]) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}