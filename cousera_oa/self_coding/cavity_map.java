public void cavity_map (char[][] matrix) {
    if (matrix.length < 3 || matrix[0].length < 3) {
        return;
    }
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    List<List<Integer>> cavity_list = new ArrayList<>();

    for (int i = 1; i < matrix.length - 1; i++) {
        for (int j = 1; j < matrix[0].length - 1; j++) {
            int cur = Integer.parseInt(matrix[i][j]);
            int adjSmall = 0;
            for (int k = 0; k < 4; k++) {
                int adj_val = Integer.parseInt(matrix[i + dx[k]][j + dy[k]]);
                if (adj_val < cur) {
                    adjSmall++;
                }
            }
            if (adjSmall == 4) {
                List<Integer> sub = new ArrayList<>();
                sub.add(i);
                sub.add(j);
                cavity_list.add(sub);
            }
        }
    }
    for (List<Integer> cavity : cavity_list) {
        matrix[cavity.get(0)][cavity.get(1)] = 'X';
    }
}