class Solution {
    public boolean closeStrings(String word1, String word2) {
        
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for( char ch : word1.toCharArray() ) {
            freq1[ch - 'a'] += 1;
        }
        for( char ch : word2.toCharArray() ) {
            freq2[ch - 'a'] += 1;
        }

        for( int i = 0; i < 26; i++ ) {
            
            if( ( freq1[i] == 0 && freq2[i] != 0 ) || ( freq1[i] != 0 && freq2[i] == 0 ) ) return false;

        }

        for( int i = 0; i < 26; i++ ) {
            boolean isFound = false;    
            for( int j = 0; j < 26; j++ ) {
                if(  freq1[i] == freq2[j] ) {
                    isFound = true;
                    freq2[j] = 0;
                    break;
                }
            }

            if( !isFound ) return false;

        }

        
        return true;

    }
}