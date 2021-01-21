package com.tjh.day12StreamAPI_练习;

import java.util.Objects;

public class Employee {

    private int id;
    private String name;
    private Integer age;
    private double salary;
    private Status Status;

    public Employee(String name, Integer age, double salary, Employee.Status status) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        Status = status;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee.Status getStatus() {
        return Status;
    }

    public void setStatus(Employee.Status status) {
        Status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name) &&
                Objects.equals(age, employee.age) &&
                Status == employee.Status;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, age, salary, Status);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", Status=" + Status +
                '}';
    }

    public enum Status{
        FREE, BUSY, VOCATION;
    }
}
