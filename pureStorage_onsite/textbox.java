class TextBox {
    int height;
    int width;
    int biasline;
    int x;
    int y;
}

public class solution {
    public List<List<TextBox>> textbox(List<TextBox> input, int max_width) {
        List<List<TextBox>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();  //final location(x,y) of each textbox's bottom right
        int prev_width = 0;
        int prev_height = 0;
        List<TextBox> row = new ArrayList<>();
        for (int i = 0; input.size(); i++) {
            TextBox cur_box = input.get(i);
            int cur_width = cur_box.width;
            int cur_height = cur_box.height;
            if (cur_width > max_width - prev_width) {
                result.add(new ArrayList<>(row));
                row.clear();
                row.add(cur_box);
                List<Integer> coor = new ArrayList<>();

                queue.offer(new ArrayList)
            } 
        }
    }

}

public class solution {
    public List<List<TextBox>> textbox(List<TextBox> inputList, int max_width) {
        int maxHeight = 0;
        int cur_width = 0;
        List<List<TextBox>> result = new ArrayList<>();
        List<TextBox> oneRow = new ArrayList<TextBox>();
        int cur_maxHeight = 0;
        int previousBottom = 0;
        for(int i = 0; i < inputList.size(); i++) {
            TextBox curBox = inputList.get(i);
            if (cur_width + curBox.width > max_width) {
                for (TextBox box : oneRow) {
                    box.y = cur_maxHeight / 2 + previousBottom - box.height / 2;
                }
                result.add(new ArrayList<TextBox>(oneRow));
                previousBottom += cur_maxHeight;
                oneRow.clear();
            } else {
                curBox.x = cur_width;
                cur_width += curBox.width;
                oneRow.add(curBox);
                cur_maxHeight = Math.max(cur_maxHeight, curBox.height);
            }
        }
        return result;
    }
}