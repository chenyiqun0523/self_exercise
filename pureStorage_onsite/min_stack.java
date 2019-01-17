//#1
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min;

    public MinStack() {
        stack = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        if (min.isEmpty()) {
            min.push(number);
        } else {
            min.push(Math.min(min.peek(), number));
        }
    }

    public int pop() {
        min.pop();
        return stack.pop();
    }

    public int min() {
        return min.peek();
    }
}

//#2
public class MinStack {
    public MinStack() {
        stack = new Stack<Integer>();
        minEle = Integer.MAX_VALUE;
    }
    private Stack<Integer> stack;
    int minEle;

    public int min() {
        if (stack.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return minEle;
        }
    }

    public int peek() {
        if (stack.isEmpty()) {
            return Integer.MAX_VALUE;
        } 
        return stack.peek();
    }

    public int pop() {
        if (stack.isEmpty()) {
            return Integer.MAX_VALUE;
        } 
        int t = stack.pop();
        if (t < minEle) {
            int temp = minEle;
            minEle = 2 * minELe - t;
            return temp;
        } else {
            return t;
        }
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            MinEle = x;
        } else {
            if (x >= minEle) {
                stack.push(x);
            } else {
                stack.push(2 * x - minEle);
                minEle = x;
            }
        }
    }
}
