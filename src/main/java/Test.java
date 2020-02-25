import java.util.ArrayList;
import java.util.List;

@Deprecated

public class Test {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("1");
    list.add("2");
    list.add("3");
    ArrayList<String> list2 = (ArrayList<String>) ((ArrayList<String>) list).clone();
    System.out.println(list);
    System.out.println(list2);
  }
}









