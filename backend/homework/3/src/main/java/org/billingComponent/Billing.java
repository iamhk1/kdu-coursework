package org.billingComponent;

import org.users.Patient;

public class Billing {

    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];

        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();
        double amountPayable=0.0;
        double amtPayableByInsurance=0.0;
        double discount=0.0;

        if(patientInsurancePlan instanceof PlatinumPlan) {
            amtPayableByInsurance = patientInsurancePlan.getCoverage() * amount;
            discount=50;

        }
        else if(patientInsurancePlan instanceof GoldPlan) {
            amtPayableByInsurance = patientInsurancePlan.getCoverage() * amount ;
            discount=40;

        }
        else if(patientInsurancePlan instanceof SilverPlan) {
            amtPayableByInsurance = patientInsurancePlan.getCoverage() * amount;
            discount=30;
        }
        else if(patientInsurancePlan instanceof  BronzePlan) {
            amtPayableByInsurance = patientInsurancePlan.getCoverage() * amount ;
            discount=25;
        }
        else
            discount=20;
        amountPayable=amount-amtPayableByInsurance;
        payments[0]=amountPayable-discount;
        payments[1]=amtPayableByInsurance;
        return payments;
    }
}