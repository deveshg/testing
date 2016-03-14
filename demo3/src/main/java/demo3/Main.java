package demo3;

import java.util.Arrays;
import java.util.List;

import demo1.Person;
import demo1.dao.PersonDAO;
import demo2.Handler;

public class Main {
  /**
   * 
   * guava demo
   */
  public static void main(String[] args) {
    List<Person> list = Arrays.asList(PersonDAO.getPersons());
    Handler.execute(list);
  }
}

