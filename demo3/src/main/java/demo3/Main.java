package demo3;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

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

