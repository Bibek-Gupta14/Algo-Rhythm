class Solution {
    void reverse(char ch[], int l, int r) {
        while(l < r) {
            char temp = ch[l];
            ch[l] = ch[r];
            ch[r] = temp;
            l++;
            r--;
        }
    }

    public String reverseWords(String s) {
        char ch[] = s.toCharArray();
        
        int old = 0;
        for(int i=0; i < ch.length; i++) {
            if(ch[i] != ' ') {
                if(old > 0) ch[old++] = ' ';
                int wordindex = old;
                while(i < ch.length && ch[i] != ' ') {
                    ch[old++] = ch[i++];
                }
                reverse(ch, wordindex, old-1);
            }
        }
        reverse(ch, 0, old-1);
        return new String(ch, 0, old);
    }
}