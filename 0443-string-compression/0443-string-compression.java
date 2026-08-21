class Solution {
    public int compress(char[] chars) {
        int index = 0;  //track the count 
        for(int i=0; i<chars.length;) {
            char ch = chars[i];
            int count = 0;

            while(i<chars.length && ch == chars[i]) {
                count++;
                i++;
            }

            if(count == 1) chars[index++] = ch;
            else {
                chars[index++] = ch;
                String no = Integer.toString(count);    // converts 12 -> ['1','2']
                for(char digit: no.toCharArray()) {
                    chars[index++] = digit;
                }
            }
            // i--;
        }
        return index;
    }
}