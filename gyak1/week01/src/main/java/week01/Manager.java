package week01;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
    public List<Employee> alkalmazottak;
    public Manager(String name, int salary){
        super(name, salary);
        alkalmazottak = new ArrayList<>();
    }

    @Override
    public int getSalary() {
        double sal = 0;
        for (Employee employee : alkalmazottak) {
            sal += employee.salary;
        }
        return  (int) (this.salary + 0.05*sal);
    }
    public void addEmployee(Employee alk){
        this.alkalmazottak.add(alk);
    }
    public void delEmployee(Employee alk){
        if (this.alkalmazottak.contains(alk))
            this.alkalmazottak.remove(alk);
    }
}
