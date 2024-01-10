package org.billingComponent;

public class BronzePlan extends HealthInsurancePlan{
    public double computeMonthlyPremium(double salary)
    {
        return 0.05*salary;
    }
    public  double computeMonthlyPremium(double salary,int age,boolean smoking)
    {
        return 0.05 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }
    BronzePlan()
    {
        this.setCoverage(0.6);
    }

}
