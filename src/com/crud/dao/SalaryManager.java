package com.crud.dao;

public class SalaryManager {
    public static double initialBaseSalary = 1000;
    private final int TOTAL_GRADE = 6;
    private final int LOWEST_GRADE = 6;
    private final double SALARY_DIFFERENCE = 5000;

    public double calculateSalary(int grade) {
        double baseSalary = ((LOWEST_GRADE - grade) * SALARY_DIFFERENCE) + initialBaseSalary;
        double allowance = this.calculateAllowance(baseSalary);
        double totalSalary = baseSalary + allowance;

        return totalSalary;
    }

    private double calculateAllowance(double baseSalary) {
        double medicalAllowance = baseSalary * .15; //15% of base
        double houseRent = baseSalary * .20; //20% of base
        return medicalAllowance + houseRent;
    }


}
