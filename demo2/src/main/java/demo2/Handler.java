package demo2;

import java.util.Collection;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

import demo1.Person;

public class Handler {


  public static void execute(List<Person> list) {
    Collection<String> collection = Collections2.transform(list, new Function<Person, String>() {
      @Override
      public String apply(Person input) {
        return input.getName();
      }
    });
    for (String string : collection) {
      System.out.println(string);
    }
  }
}
