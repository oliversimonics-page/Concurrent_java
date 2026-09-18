package week01;

import java.util.ArrayList;

public class Company {
    private ArrayList<SalariedEntity> alkalmazottak = new ArrayList<>();
    public Company(){

    }
    public void addAlk(SalariedEntity alk){
        this.alkalmazottak.add(alk);
    }
    public void delAlk(SalariedEntity alk){
        if (this.alkalmazottak.contains(alk)){
            this.alkalmazottak.remove(alk);
        }
    }
    public void fizuEmel(double szazalek){
        for (SalariedEntity salariedEntity : alkalmazottak) {
            if(salariedEntity instanceof Employee emp){
                emp.setSalary(szazalek);
            }
        }
    }
}
