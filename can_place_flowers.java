class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int i = 0;

        while ( i < flowerbed.length){
            if ( flowerbed[i] == 1){
                i = i + 2;
            }
            else{
                if ( (i == 0 || flowerbed[i - 1]== 0 ) && ( i == flowerbed.length - 1 || flowerbed[ i + 1] == 0)){
                    count++;
                    i+=2;
                }
                else{
                    i++;
                }
            }
        }
        if(count >= n){
            return true;
        }
        else{
            return false;
        }
        
    }
}