package demo1;

public class Person {

  private String name;

  public Person() {
    setName("Unknown");
  }
  
  public Person(String name){
    setName(name);
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
}
