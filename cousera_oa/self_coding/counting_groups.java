class Point {
    int x;
    int y;
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    } 
}
public int[] numIslands(char[][] grid, int[] array) {
    if (grid.length == 0 || grid[0].length == 0) {
        return 0;
    }

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == '1') {
                int islandSize = bfs(i, j, grid);
                if (!map.containsKey(islandSize)) {
                    map.put(islandSize, 1);
                } else {
                    map.put(islandSize, map.get(islandSize) + 1);
                }
            }
        }
    }

    for (int i = 0; i < array.length; i++) {
        if (map.containsKey(array[i])) {
            array[i] = map.get(array[i]);
        }
    }

    return array;
}
private int bfs(int x, int y, char[][] grid) {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int islandSize = 0;
    Queue<Point> queue = new LinkedList<>();
    queue.offer(new Point(x,y));
    while(!queue.isEmpty()) {
        Point cur = queue.poll();
        for (int i = 0; i < 4; i++) {
            int newX = cur.x + dx[i];
            int newY = cur.y + dy[i];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                if (grid[newX][newY] == '1') {
                    queue.offer(new Point(newX, newY));
                    grid[newX][newY] = '0';
                    islandSize++;
                }
            }
        }
    }
    return islandSize;
    
}