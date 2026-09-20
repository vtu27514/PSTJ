public class Main {

    static class MyHashSet {

        private boolean[] set;

        // Constructor
        public MyHashSet() {
            set = new boolean[1000001];
        }

        // Add a key
        public void add(int key) {
            set[key] = true;
        }

        // Remove a key
        public void remove(int key) {
            set[key] = false;
        }

        // Check whether key exists
        public boolean contains(int key) {
            return set[key];
        }
    }

    public static void main(String[] args) {

        // Create HashSet
        MyHashSet myHashSet = new MyHashSet();

        // Operations
        myHashSet.add(1);
        myHashSet.add(2);

        System.out.println("Contains 1: " + myHashSet.contains(1));
        System.out.println("Contains 3: " + myHashSet.contains(3));

        myHashSet.add(2);

        System.out.println("Contains 2: " + myHashSet.contains(2));

        myHashSet.remove(2);

        System.out.println("Contains 2 after remove: "
                           + myHashSet.contains(2));
    }
}