public int firstOccurance(String A, String X) {
    int start = 0;
    int i = 0;
    int j = 0;
    while (i < A.length() && j < X.length()) {
        if (A.charAt(i) == X.charAt(j) || X.charAt(j) == '*') {
            i++;
            j++;
        } else {
            start++;
            i = start;
            j = 0;
        }
    }
    if (j < X.length()) {
        return -1;
    } else {
        return start;
    }
}