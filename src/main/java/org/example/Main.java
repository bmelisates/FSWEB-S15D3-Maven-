package org.example;

import org.example.entity.Employee;

import java.util.*;

import static org.example.WordCounter.calculateWord;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> result = calculateWord();
        Map<String, Integer> sortedResult = new TreeMap<>(result);
        System.out.println(sortedResult);

        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Ali", "Yılmaz"));
        employees.add(new Employee(1, "Veli", "Yılmaz"));
        employees.add(new Employee(2, "Ayşe", "Yılmaz"));
        employees.add(new Employee(2, "Selin", "Yılmaz"));
        employees.add(new Employee(3, "Selin", "Yılmaz"));
        //System.out.println(employees);

        List<Employee> duplicates = findDuplicates(employees);
        //System.out.println(duplicates);
        Map<Integer, Employee> employeeMap = findUniques(employees);
        //System.out.println(employeeMap);
        List<Employee> removedDuplicates = removeDuplicates(employees);
        //System.out.println(removedDuplicates);
    }


    public static List<Employee> findDuplicates(List<Employee> list) {
        Set<Employee> uniqueElements = new HashSet<>();
        List<Employee> duplicateList = new LinkedList<>();
        for (Employee emp : list) {
            if (!uniqueElements.add(emp)) {
                duplicateList.add(emp);
            }
        }
        return duplicateList;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee emp : list) {
            if (emp != null) {
                employeeMap.put(emp.getId(), emp);
            }
        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        List<Employee> result = new LinkedList<>();
        Map<Integer, Integer> counts = new HashMap<>();

        for (Employee emp : list) {
            if (emp != null) {
                counts.put(emp.getId(), counts.getOrDefault(emp.getId(), 0) + 1);
            }
        }

        for (Employee emp : list) {
            if (emp != null && counts.get(emp.getId()) == 1) {
                result.add(emp);
            }
        }
        return result;
    }
}