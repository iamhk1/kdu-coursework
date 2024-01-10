package org.billingcomponent;

public class SilverPlan extends HealthInsurancePlan{
    public double computeMonthlyPremium(double salary)
    {
        return 0.06*salary;
    }
    public  double computeMonthlyPremium(double salary,int age,boolean smoking)
    {

        return 0.06 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }
    SilverPlan()
    {
        this.setCoverage(0.7);
    }
}
