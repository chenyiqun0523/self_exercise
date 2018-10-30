static String calculateScore(String text, String prefix, String suffix) {

    int suf_len = suffix.length();
    int pref_len = prefix.length();

    Map<String, Integer> map = new HashMap<>();

    for(int i = 0; i < text.length(); i++) {
        for(int j = i + 1; j <= text.length(); j++) {

            String L = text.substring(i,j);
            
            //skip duplicate substring
            if (map.containsKey(L)) {
                continue;
            }

            int suf_score = 0;
            int pref_score = 0;
            int L_len = L.length();

            for(int k = 0; k < L_len; k++) {
                if(L_len - k <= suf_len) {
                    if(L.substring(k, L_len).equals(suffix.substring(0,L_len-k))) {
                        suf_score = Math.max(suf_score, L_len - k);
                    }
                }
            }

            for(int k = 0; k < L_len; k++) {
                if(k < pref_len) {
                    if(L.substring(0, k + 1).equals(prefix.substring(pref_len - k - 1, pref_len))) {
                        pref_score = Math.max(pref_score, k + 1);
                    }
                }
            }
            int total_score = suf_score + pref_score;
            map.put(L, total_score);
        }
    }

    int max_score = 0;
    String ans = "";
    for (key: map.keyset()) {
        if (map.get(key) > max_score || map.get(key) == max_score && key.length() < ans.length()) {
            max_score = map.get(key);
            ans = key;
        }
    }

    return ans;
}