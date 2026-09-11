package week01;

public class Manager extends Employee {
    public Manager(String name, int salary){
        super(name, salary);
    }

    @Override
    public int getSalary() {
        return this.salary;
    }
}
