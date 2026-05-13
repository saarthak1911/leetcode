class Solution {

    public String reverseWords(String s) {

        int n = s.length();

        StringBuilder ans = new StringBuilder();

        // Reverse entire string
        String reversed = new StringBuilder(s).reverse().toString();

        for(int i = 0; i < n; i++) {

            StringBuilder word = new StringBuilder();

            // Skip spaces
            while(i < n && reversed.charAt(i) == ' ') {
                i++;
            }

            // Store one word
            while(i < n && reversed.charAt(i) != ' ') {

                word.append(reversed.charAt(i));
                i++;
            }

            // Reverse word again
            String newWord = word.reverse().toString();

            if(newWord.length() > 0) {

                ans.append(newWord);
                ans.append(" ");
            }
        }

        return ans.toString().trim();
    }
}