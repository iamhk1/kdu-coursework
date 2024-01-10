package org.billingcomponent;


public abstract class HealthInsurancePlan {
    public abstract double computeMonthlyPremium(double salary);
    public abstract double computeMonthlyPremium(double salary,int age,boolean smoke);
    private InsuranceBrand offeredBy;

    public InsuranceBrand getOfferedBy() {
        return offeredBy;
    }

    public void setOfferedBy(InsuranceBrand offeredBy) {
        this.offeredBy = offeredBy;
    }
    private double coverage;
    public void setCoverage(double coverage)
    {
        this.coverage=coverage;
    }
    public double getCoverage()
    {
        return coverage;
    }
    private HealthInsurancePlan insurancePlan;
    public void setInsurancePlan(HealthInsurancePlan insurancePlan)
    {
        this.insurancePlan=insurancePlan;
    }
    public HealthInsurancePlan getInsurancePlan()
    {
        return insurancePlan;
    }
}
