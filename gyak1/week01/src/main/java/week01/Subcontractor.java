package week01;

public class Subcontractor implements SalariedEntity{
    private int salary;
    private long adoszam;
    public Subcontractor(int salary, long adoszam){
        this.salary= salary;
        this.adoszam = adoszam;
    }
    public int getSalary(){
        return this.salary;
    }
}
