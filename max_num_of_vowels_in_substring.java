class Solution {
    public int maxVowels(String s, int k) {
        int c=0;
        int maxc=Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            if(checkv(s.charAt(i)))
             c++;
        }
        maxc=c;
        int l=0;
        int r=k-1;
        while(r<s.length()){
            if(checkv(s.charAt(l)))
             c=c-1;
             l++;
             r++;
             if(r<s.length()){
             if(checkv(s.charAt(r)))
             c++;
             }
             if(c>maxc)
             maxc=c;
        }
        return maxc;
    }
    public boolean checkv(char ch){
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
         return true;
        else
         return false;
    }

}