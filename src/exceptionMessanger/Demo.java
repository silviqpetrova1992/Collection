package exceptionMessanger;

import java.util.Hashtable;

/**
 * Created by clouway on 4/6/15.
 */
public class Demo {
  public static void main(String[] args) {
    ExceptionMessageManager list = new ExceptionMessageManager();
    try {
      list.registerErrorMessage("11", "Sisa");
      list.registerErrorMessage("12", "Pesho");
       list.registerErrorMessage("11","hhh");
      //list.raiseError("12");
      list.raiseError("11");
      list.raiseError("10");
      System.out.println(list.getErrorMessages() + " ");
    } catch (ProgramerException e) {
      System.out.println(e.getMessage());
    }
  }
}
