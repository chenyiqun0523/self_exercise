static int minUniqueSum(int[] A) {
    int n = A.length;

    int sum = A[0];
    int prev = A[0];

    for( int i = 1; i < n; i++ ) {
        int curr = A[i];

        if( prev >= curr ) {
            curr = prev+1;
        }
        sum += curr;
        prev = curr;
    }

    return sum;
}