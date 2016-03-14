package demo1.dao;

import demo1.Person;

public class PersonDAO {

  public static Person[] getPersons() {
    return new Person[] {
      new Person("John"),
      new Person("Robert")
    };
  }

}
