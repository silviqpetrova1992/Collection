package exceptionMessanger;

import java.util.*;

/**
 * Created by clouway on 4/6/15.
 */
public class Demo2 {
  class User {


  }

  public Set<User> findUsers() {
    return null;
  }

  public static void main(String[] args) {


    Hashtable<String, String> h = new Hashtable<String, String>();
    h.put("1", "bdrcjdlnmk");
    h.put("2", "cat");
    h.put("5","ghuio");
    h.put("3", "dog");
    for (String i : h.keySet()) {
      System.out.print(i + " |");
    }
    System.out.println(" ");
    Set<String> l = new HashSet<String>();
    l.add("1");
    l.add("4");
    l.add("2");
    for(String p : l) {
      System.out.print(p + "|");
    }
  }

  class MyTreeSet<T> extends AbstractSet<T> {


    @Override
    public Iterator<T> iterator() {
      return null;
    }

    @Override
    public int size() {
      return 0;
    }
  }
}
