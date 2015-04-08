package pageBean;

import pageBean.PageBean.Page;

import java.util.Scanner;

public class Demo {
  public static void main(String[] args) {
    String[] arr = {"Zornica", "Silviq", "Ivan", "Kaloqn", "Atanas", "Ralica"};
    int pageSize = 4;
    PageBean p = new PageBean(pageSize, arr);
    Scanner sc = new Scanner(System.in);
    int function;
    do {
      System.out.println("");
      System.out.println("Push :" + "\n" + "1 for next page" + "\n" + "2 for previous page" + "\n" + "3 for first page" + "\n" + "4 for last page" + "\n" + "5 for quit");
      System.out.println("");
      function = sc.nextInt();
      switch (function) {
        case 1:
          try {
            Page page = p.next();
            System.out.println("page........." + page.number);
            for (String i : page.items) {
              System.out.println(i);
            }

            break;
          } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("This was a last page!");
            break;
          }
        case 2:
          try {
            Page page = p.previous();
            System.out.println("page........." + page.number);
            for (String i : page.items) {
              System.out.println(i);
            }
            break;
          } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("This was a first page! ");
            break;
          }
        case 3:
          Page page = p.firstPage();
          System.out.println("page........." + page.number);
          for (String i : page.items) {
            System.out.println(i);
          }
          break;
        case 4:
          Page list = p.lastPage();
          System.out.println("page........." + list.number);
          for (String i : list.items) {
            System.out.println(i);
          }
          break;
        default:
          if (function > 5 || function < 1)
            System.out.println("Invalid function!");
          break;
      }
    }
    while (function != 5);

  }
}
