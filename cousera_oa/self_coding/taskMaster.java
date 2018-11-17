public int taskMaster(int k, List<Integer> a, List<Integer> b) {
    if (a == null || b == null || a.size() == 0 || b.size() == 0) {
        return k;
    }
    
    int count = k;
    int[] father = int[a.length + 1];
    
    for (int i = 0; i <= father.length; i++) {
        father[i] = i;
     }
    
     for (int i = 0; i < a.length; i++) {
        if (father[a.get(i)] == find(father, b.get(i))) {
            count--;
        }
       father[a.get(i)] = father[b.get(i)];
    }
    return count;
}

public int find(int[] father, int x) {
    if (father[x] == x) {
        return x;
    }
    return find(father[x]);
}