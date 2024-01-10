package org.billingcomponent;

public class GoldPlan extends HealthInsurancePlan{
    public double computeMonthlyPremium(double salary)
    {
        return 0.07*salary;
    }
    public  double computeMonthlyPremium(double salary,int age,boolean smoking)
    {

        return 0.07 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }
    GoldPlan()
    {
        this.setCoverage(0.8);
    }
}
