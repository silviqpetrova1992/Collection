package pageBean;


import java.util.ArrayList;
import java.util.List;

public class PageBean {
  private int pageSize;
  private String[] array;
  private int i;
  private int page = 0;

  /**
   * Constructor s parameters
   *
   * @param pageSize is number of element which we see on one page
   * @param array    is list of elements
   */
  public PageBean(int pageSize, String[] array) {
    this.array = array;
    this.pageSize = pageSize;
    i = -pageSize;
  }

  public class Page {
    public final int number;
    public final List<String> items;

    public Page(int number, List<String> items) {
      this.number = number;
      this.items = items;
    }
  }

  /**
   * Print next page
   */
  public Page next() {

    if (hasNext()) {
      List<String> result = new ArrayList<String>();
      i = i + pageSize;
      for (int j = i; j < i + pageSize; j++) {
        if (j < array.length) {
          result.add(array[j]);
        }
      }
      if (page < pages()) {
        page++;
      }
      return new Page(getCurrentPageNumber(), result);
    } else {
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  /**
   * Print previous page
   */
  public Page previous() {
    if (hasPrevious()) {
      List<String> result = new ArrayList<String>();
      for (int j = (i - pageSize); j <= i - 1; j++) {
        if (j > -1) {
          result.add(array[j]);
        }
      }
      i = i - pageSize;
      page--;
      return new Page(getCurrentPageNumber(), result);
    } else {
      throw new ArrayIndexOutOfBoundsException();

    }
  }

  /**
   * Calculate number of pages
   *
   *
   */
  private int pages() {
    if ((array.length % pageSize) != 0) {
      return ((array.length / pageSize) + 1);
    } else {
      return (array.length / pageSize);
    }
  }

  /**
   * Checks for next page
   *
   *
   */
  private boolean hasNext() {
    return ((page < pages()) && (i < array.length) && (i >= -pageSize));
  }

  /**
   * Checks for previous page
   *
   *
   */
  private boolean hasPrevious() {
    return ((page > 1) && (i >= pageSize));
  }

  /**
   * Prints the first page
   */
  public Page firstPage() {
    List<String> result = new ArrayList<String>();
    i = 0;
    for (int j = i; j < (i + pageSize); j++) {
      result.add(array[j]);
    }
    page = 1;
    return new Page(getCurrentPageNumber(), result);
  }

  /**
   * Prints the previous page
   */
  public Page lastPage() {
    List<String> result = new ArrayList<String>();
    i = (array.length + (array.length % pageSize)) - pageSize;
    for (int j = i; j < array.length; j++) {
      result.add(array[j]);
    }
    page = pages();
    return new Page(getCurrentPageNumber(), result);
  }

  /**
   * Prints the number of page
   *
   *
   */
  private int getCurrentPageNumber() {
    return page;
  }

}
