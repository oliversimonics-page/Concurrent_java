package week01;

public abstract class Employee implements SalariedEntity{
    protected String name;
    protected int salary;

    protected Employee(String name, int salary){
        this.name = name;
        this.salary = salary;
    }
    public String getName(){
        return this.name;
    }
    abstract public int getSalary();
    public void setSalary(double salary){
        this.salary *= (1+salary);
    }
}
