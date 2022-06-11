class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int it : nums) 
            map.put(it, map.getOrDefault(it, 0) + 1);
        PriorityQueue<Element> pq = new PriorityQueue<>();
        for (Map.Entry it : map.entrySet()) {
            pq.add(new Element((int)it.getValue(), (int)it.getKey()));
            if (pq.size() > k)
                pq.poll();
        }
        int ans[] = new int[k];
        for (int i = 0; i < k; ++i) 
            ans[i] = pq.poll().num;
        return ans;
    }
}

class Element implements Comparable<Element> {
    int freq, num;
    Element(int freq, int num) {
        this.freq = freq;
        this.num = num;
    }
    
    @Override
    public int compareTo(Element o) {
        return Integer.compare(this.freq, o.freq);
    }
}