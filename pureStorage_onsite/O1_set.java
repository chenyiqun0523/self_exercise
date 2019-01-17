public class O1_Map {
    HashMap<Integer, Integer> map;
    int[] list;
    int count;

    public O1_Map(int size) {
        map = new HashMap<Integer, Integer>();
        list = new int[size];
        count = 0;
    }

    public void add(int num) {
        if (!contains(num)) {
            map.put(num, count);
            list[count] = num;
            count++;
            System.out.println("Add: " + num + " count: " + count);
        } else {
            System.out.println("Add Error: " + num + " already exists");
        }
    }

    public void remove(int num) {
        if (contains(num)) {
            list[map.get(num)] = list[count - 1];
            map.remove(num);
            count--;
            System.out.println("Remove: " + num + " count: " + count);
        } else {
            System.out.println("Remove Error: " + num + " doesn't exist");
        }
    }

    public boolean contains(int num) {
        if (!map.containsKey(num)) {
            return false;
        }
        if (map.get(num) >= count) {
            return false;
        }
        if (list[map.get(num)] != num) {
            return false;
        }
        return true;
    }

    public void clear() {
        count = 0;
    }

    public void iterate() {
        for (int i = 0; i < count; i++) {
            System.out.println(list[i]);
        }
    }

}
