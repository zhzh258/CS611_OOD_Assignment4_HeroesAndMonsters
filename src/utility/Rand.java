package utility;


import java.util.*;

public class Rand {
    private static final Random random = new Random();

    // [l, r)
    public static int randomInt(int l, int r){
        if(l == r) return l;
        return random.nextInt(r - l) + l;
    }

    public static <T> List<T> selectRandomElements(List<T> list, int n) {
        Random random = new Random();
        List<T> selectedItems = new ArrayList<>();

        // Create a list of indices to shuffle and pick the first n indices after shuffling
        List<Integer> indices = new ArrayList<>();
        for (int index = 0; index < list.size(); index++) {
            indices.add(index);
        }
        Collections.shuffle(indices, random);

        // Check if n is greater than list size, and adjust if necessary
        n = Math.min(n, list.size());

        // Pick the first n indices and get the corresponding elements from list
        for (int index = 0; index < n; index++) {
            selectedItems.add(list.get(indices.get(index)));
        }

        return selectedItems;
    }
}
