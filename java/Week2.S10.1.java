import java.util.*;

class Dequeue {

    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> result = new ArrayList<>();

        // Each event = {x, height, right}
        // Start event: height is negative
        List<int[]> events = new ArrayList<>();

        for (int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];

            // Negative height means building starts
            events.add(new int[]{left, -height, right});

            // Positive height means building ends
            events.add(new int[]{right, 0, 0});
        }

        // Sort events by x-coordinate
        // If same x, process taller building first
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // Max heap: {height, right}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );

        // Ground level
        pq.add(new int[]{0, Integer.MAX_VALUE});

        int previousHeight = 0;

        for (int[] event : events) {

            int x = event[0];
            int height = event[1];
            int right = event[2];

            // Remove buildings that have ended
            while (!pq.isEmpty() && pq.peek()[1] <= x) {
                pq.poll();
            }

            // Building starts
            if (height < 0) {
                pq.add(new int[]{-height, right});
            }

            int currentHeight = pq.peek()[0];

            // Height changed
            if (currentHeight != previousHeight) {
                result.add(Arrays.asList(x, currentHeight));
                previousHeight = currentHeight;
            }
        }

        return result;
    }
}