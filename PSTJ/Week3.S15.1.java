import java.util.*;

class Solution {
    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Convert characters into list
        ArrayList<Character> chars = new ArrayList<>(map.keySet());

        // Sort by frequency
        Collections.sort(chars, new Comparator<Character>() {
            public int compare(Character a, Character b) {
                return map.get(b) - map.get(a);
            }
        });

        // Build result
        StringBuilder result = new StringBuilder();

        for (char c : chars) {
            int frequency = map.get(c);

            for (int i = 0; i < frequency; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }
}