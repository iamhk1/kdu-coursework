package org.billingcomponent;

public class BlueCrossBlueShield implements InsuranceBrand{

    private long id;
    private String name;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking) {
        double monthlyPremium=0;
        if(insurancePlan instanceof PlatinumPlan) {
            if (age > 55)
                monthlyPremium += 200;
            if (smoking)
                monthlyPremium += 100;

        }
        else if(insurancePlan instanceof  GoldPlan)
        {
            if(age>55)
                monthlyPremium+=150;
            if(smoking)
                monthlyPremium+=90;
        }
        else if(insurancePlan instanceof  SilverPlan)
        {
            if(age>55)
                monthlyPremium+=100;
            if(smoking)
                monthlyPremium+=80;
        }
        else if(insurancePlan instanceof BronzePlan)
        {
            if(age>55)
                monthlyPremium+=50;
            if(smoking)
                monthlyPremium+=70;
        }
        return monthlyPremium;
    }
}
