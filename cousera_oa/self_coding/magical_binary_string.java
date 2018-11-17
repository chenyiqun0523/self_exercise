public static void main(String[] args) {
    String str = "11011000";
    System.out.println(magicstr(str));
}

public static String magicstr(String str) {

    int n = str.length();
    int maxInd = -1;
    int maxLen = -1;
    int maxVal = -1;
    for (int i = 1; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            String cur_sub = str.substring(i, j+1);
            int magical_substring_value = isMagic(cur_sub);
            if (magical_substring_value > maxVal && maxVal > -1) {
                String nq = "";
                String prev_magic_sub = str.substring(maxInd, maxInd + maxLen);
                String pre1 = str.substring(0, maxInd);
                String po1 = str.substring(j+1, n);
                String mi1 = str.substring(maxInd + maxLen+1, i);

                nq = pre1;
                nq += cur_sub;
                nq += mi1;
                nq += prev_magic_sub;
                nq += po1;

                str = magicstr(nq);
            } else if (magical_substring_value > maxVal && maxVal == -1) { // first magical substring
                maxInd = i;
                maxLen = cur_sub.length();
                maxVal = magical_substring_value;
                break;
            }
        }
    }
    return str;
}

public static int isMagic(String sub) {
    if (sub.length() == 0) {
        return -1;
    }

    int binaryDigits = Integer.parseInt(sub, 2);
    int count1 = 0;
    int count0 = 0;

    for (int n = sub.length() - 1; n >= 0; n--) {
        if (((binaryDigits & (1 << n)) != 0) && ( (binaryDigits & (1 << n)) == 1 || (binaryDigits & (1 << n)) % 2 == 0)) {
            count1++;
        } else {
            count0++;
        }
        if (count1 < count0) {
            return -1;
        }
    }
    if (count1 == count0) {
        return Integer.parseInt(sub);
    }
    return -1;
}