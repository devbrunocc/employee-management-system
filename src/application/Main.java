package application;

import entities.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many employees will be added: ");
        int n = sc.nextInt();

        // Uso de lista dinâmica para flexibilidade de armazenamento
        List<Employee> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.printf("\nEmployee #%d\n", i + 1);
            System.out.print("Id: ");
            int id = sc.nextInt();

            // Verificação para garantir que não existam IDs duplicados
            while (hasId(list, id)) {
                System.out.print("Id already taken, try again: ");
                id = sc.nextInt();
            }

            sc.nextLine(); // Limpeza de buffer necessária após ler o int
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();

            list.add(new Employee(id, name, salary));
        }

        System.out.print("\nEnter the employee id that will have salary increase: ");
        int id = sc.nextInt();

        // Busca do funcionário usando Stream para um código mais limpo e legível
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        if (emp == null) {
            System.out.println("This id does not exist!");
        } else {
            System.out.print("Enter the percentage: ");
            double percent = sc.nextDouble();
            // A lógica de aumento fica encapsulada na classe Employee
            emp.increaseSalary(percent);
        }

        // Impressão da lista final utilizando o toString personalizado da entidade
        System.out.println("\nList of employees:");
        for (Employee e : list) {
            System.out.println(e);
        }

        sc.close();
    }

    // Função auxiliar para busca linear na lista
    public static boolean hasId(List<Employee> list, int id) {
        for (Employee obj : list) {
            if (obj.getId() == id) {
                return true;
            }
        }
        return false;
    }
}