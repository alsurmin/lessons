package jmx.jmxlesson;

public interface HelloMBean {
    void sayHello();
    int addInteger(int a, int b);

    Person returnPerson();

    String getName();
    void setName(String name);

}
