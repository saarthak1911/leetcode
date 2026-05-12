class Solution {

    public String reverseVowels(String s) {

        char[] arr = s.toCharArray();

        int i = 0;
        int j = arr.length - 1;

        String vowels = "aeiouAEIOU";

        while(i < j) {

            // Find vowel from left
            while(i < j) {

                char ch = arr[i];

                if(vowels.indexOf(ch) != -1) {
                    break;
                }

                i++;
            }

            // Find vowel from right
            while(i < j) {

                char ch = arr[j];

                if(vowels.indexOf(ch) != -1) {
                    break;
                }

                j--;
            }

            // Swap vowels
            if(i < j) {

                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }

        return new String(arr);
    }
}

/*

This is second approch

class Solution {

    public boolean isVowel(char ch) {

        return ch == 'a' || ch == 'e' || ch == 'i' ||
               ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' ||
               ch == 'O' || ch == 'U';
    }

    public String reverseVowels(String s) {

        char[] arr = s.toCharArray();

        int i = 0;
        int j = arr.length - 1;

        while(i < j) {

            if(!isVowel(arr[i])) {
                i++;
            }

            else if(!isVowel(arr[j])) {
                j--;
            }

            else {

                // Swap vowels
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }

        return new String(arr);
    }
}


*/