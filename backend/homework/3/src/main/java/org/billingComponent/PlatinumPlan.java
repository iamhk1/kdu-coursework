package org.billingComponent;

public class PlatinumPlan extends HealthInsurancePlan{
    public double computeMonthlyPremium(double salary)
    {
        return 0.08*salary;
    }
    public  double computeMonthlyPremium(double salary,int age,boolean smoking)
    {

        return 0.08 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
    }

    PlatinumPlan()
    {
        this.setCoverage(0.9);
    }

}
