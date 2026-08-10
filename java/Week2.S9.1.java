import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        ArrayList<ArrayList<String>> result = new ArrayList<>(map.values());

        System.out.println(result);
    }
}