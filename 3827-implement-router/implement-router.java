class Router {

    int n;
    Set<String> existingPackets = new HashSet<>();
    Queue<String> que = new LinkedList<>();
    HashMap<Integer, Integer> src_dst = new HashMap<>();
    HashMap<Integer, Integer> src_time = new HashMap<>();
    HashMap<Integer, List<Integer>> dst_time = new HashMap<>();

    public Router(int memoryLimit) {
        n = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String packetKey = source + ":" + destination + ":" + timestamp;
        if (existingPackets.contains(packetKey)) return false; // duplicate check

        // Remove oldest packet if memory limit reached
        if (que.size() == n) {
            String oldPacket = que.remove();
            String[] parts = oldPacket.split(":");
            int oldSource = Integer.parseInt(parts[0]);
            int oldDest = Integer.parseInt(parts[1]);
            int oldTime = Integer.parseInt(parts[2]);

            existingPackets.remove(oldPacket);
            src_dst.remove(oldSource);
            src_time.remove(oldSource);

            if (dst_time.containsKey(oldDest)) {
                List<Integer> list = dst_time.get(oldDest);
                list.remove(Integer.valueOf(oldTime));
                if (list.isEmpty()) dst_time.remove(oldDest);
            }
        }

        // Add new packet
        que.add(packetKey);
        existingPackets.add(packetKey);
        src_dst.put(source, destination);
        src_time.put(source, timestamp);

        // Your if-else style for dst_time
        if (dst_time.containsKey(destination)) {
            List<Integer> list = dst_time.get(destination);
            list.add(timestamp);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(timestamp);
            dst_time.put(destination, list);
        }

        return true;
    }

    public int[] forwardPacket() {
        if (que.isEmpty()) return new int[0];

        String packet = que.remove();
        String[] parts = packet.split(":");
        int source = Integer.parseInt(parts[0]);
        int destination = Integer.parseInt(parts[1]);
        int timestamp = Integer.parseInt(parts[2]);

        existingPackets.remove(packet);
        src_dst.remove(source);
        src_time.remove(source);

        List<Integer> list = dst_time.get(destination);
        list.remove(Integer.valueOf(timestamp));
        if (list.isEmpty()) dst_time.remove(destination);

        return new int[]{source, destination, timestamp};
    }

     public int getCount(int destination, int startTime, int endTime) {
        if (!dst_time.containsKey(destination)) return 0;

        List<Integer> list = dst_time.get(destination);
        int left = lowerBound(list, startTime);
        int right = upperBound(list, endTime);

        return right - left;
    }

    // index of first element >= target
    private int lowerBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (list.get(m) >= target) r = m;
            else l = m + 1;
        }
        return l;
    }

    // index of first element > target
    private int upperBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (list.get(m) > target) r = m;
            else l = m + 1;
        }
        return l;
    }
}
