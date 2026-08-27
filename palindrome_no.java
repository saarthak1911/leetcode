class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;

        int org = x;
        int temp, rev = 0;

        while (x != 0) {
            temp = x % 10;      
             rev = rev * 10 + temp;
            x = x / 10;        
        }  

        if(org - rev == 0)
            return true;
        else 
            return false;

    }
}   