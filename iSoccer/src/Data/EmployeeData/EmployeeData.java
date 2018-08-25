package Data.EmployeeData;

import MVC.Model;

public class EmployeeData implements Model {
    public static final String SALARY = "Salário", JOB = "Cargo";

    public enum Type {ADVOGADO, COZINHEIRO, JOGADOR, MÉDICO, MOTORISTA, PREPARADOR, PRESIDENTE, TÉCNICO};

    private double salary;
    private Type type;


    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public double getSalary() {
        return salary;
    }
}
