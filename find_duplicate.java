import java.util.*;

public class find_duplicate {

    public static int findDuplicate(ArrayList<Integer> list) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : list) {

            if (set.contains(num))
                return num;

            set.add(num);
        }

        return -1;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(
                Arrays.asList(1,3,4,2,2));

        System.out.println(findDuplicate(list));
    }
}