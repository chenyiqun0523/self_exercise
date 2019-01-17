//https://www.cs.uic.edu/~jbell/CourseNotes/ComputerGraphics/Circles.html
import java.lang.Math; // headers MUST be above the first class
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


// one class needs to have a main() method
public class HelloWorld
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    List<List<Integer>> result = draw_circle(10000);
    System.out.print(result);
  }
  
  public static List<List<Integer>> draw_circle(int r) { // r
        List<List<Integer>> result = new ArrayList<>();
        int x = (int)0.717 * r;
        int r2 = r * r;
        int[] dx = {1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1};
        while (x <= r) {
            for (int y = 0; y <= x; y++) {
                if (x * x + y * y == r2) {
                    for (int i = 0; i < 4; i++) {
                        int curX = x * dx[i];
                        int curY = y * dy[i];
                        List<Integer> temp = new ArrayList<>();
                        temp.add(curX);
                        temp.add(curY);
                        result.add(new ArrayList<Integer>(temp));
                        Collections.reverse(temp);
                        result.add(new ArrayList<Integer>(temp));
                    }
                }
            }
            x++;
        }
        return result;
    }
}