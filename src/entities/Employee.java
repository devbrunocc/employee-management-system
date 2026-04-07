package entities;

public class Employee {

    private int id;
    private String name;
    private double salary;

    // construtor padrão necessário para certos frameworks e flexibilidade
    public Employee() {
    }

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    /* getters e setters seguindo o padrão java beans */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // isolando a lógica de cálculo dentro da própria classe
    public void increaseSalary(double percent) {
        salary += salary * percent / 100;
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + String.format("%.2f", salary);
    }
}