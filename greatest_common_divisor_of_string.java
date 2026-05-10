class Solution {

    public String gcdOfStrings(String str1, String str2) {

        int n1 = str1.length();
        int n2 = str2.length();

        // Check if both strings can form same pattern
        if(!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Find gcd of lengths
        int len = gcd(n1, n2);

        return str1.substring(0, len);
    }

    // GCD function
    public int gcd(int a, int b) {

        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}