//recursion
class solution {
    public int fibonacci(int n) {
        // write your code here
        if (n == 1) {
            return 0;
        } 
        if (n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

class solution {
    public int fib(int n) {
        int add1 = 0;
        int add2 = 1;
        for (int i = 0; i < n - 1; i++) {
            int c = add1 + add2;
            add1 = add2;
            add2 = c;
        }
        return add1;
    } 
}