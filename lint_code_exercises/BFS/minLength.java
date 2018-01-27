//624 Remove Substrings

public class Solution {
  public int minLength(String s, Set<String> dict) {
    Queue<String> queue = new LinkedList<String>();
    Set<String> hash = new HashSet<String>();
    queue.offer(s); 
    hash.add(s);
    int min = s.length();
    while(!queue.isEmpty()){
      s = queue.poll();
      for(String sub : dict) {
        int found = s.indexOf(sub);
        while(found != -1) {
          String new_string = s.substring(0,found) + s.substring(found+sub.length(), s.length());
          if(!hash.contains(new_string)) {
            if (new_string.length() < min) {
              min = new_string.length();
            }
            queue.offer(new_string);
            hash.add(new_string);
          }
          found = s.indexOf(sub, found+1); 
        }
      }
    }
    return min;
  }
}
