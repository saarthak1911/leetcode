class Solution {
    public int findKthPositive(int[] arr, int k) {

        int size = arr.length;

        int high = arr[size - 1] + k;

        int newarr[] = new int[high];
        for (int i = 0; i < high; i++) {
            newarr[i] = i + 1;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < high; j++) {
                if (arr[i] == newarr[j]) {
                    newarr[j] = 0;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < high; i++) {
            if (newarr[i] != 0) {
                count++;
            }

            if (count == k) {
                return newarr[i];
            }
        }

        return -1;
    }
}