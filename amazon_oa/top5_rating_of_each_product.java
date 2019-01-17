
class Solution {
    public List<List<Integer>> top5 (List<List<Integer>> list) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int cur_id = list.get(i).get(0);
            if (!map.containsKey(cur_id)) {
                PriorityQueue<Integer> heap = new PriorityQueue<>(5);
                map.put(cur_id, heap);
            }
            cur_heap = map.get(cur_id);
            cur_heap.offer(list.get(i).get(1));
            if(cur_heap.size() > 5) {
                cur_heap.poll();
            }
            
        }

        for (int key : map.keyset()) {
            int[] top5 = map.get(key).toArray();
            int sum = 0;
            for (int i = 0; i < top5.length; i++) {
                sum += top5[i];
            } 
            int average = sum / top5.length;
            List<Integer> subset = new ArrayList<>();
            subset.add(key);
            subset.add(average);
            result.add(subset);
        }
        return result;
    } 
}