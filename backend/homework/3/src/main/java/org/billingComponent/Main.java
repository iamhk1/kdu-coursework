package org.billingComponent;
import org.logger.Log;
import org.users.Patient;
import org.users.Doctor;
import org.users.User;


public class Main {

    public static void main(String []args)
    {

        HealthInsurancePlan insurancePlan = new PlatinumPlan();
        Patient patient = new Patient();
        patient.setInsurancePlan(insurancePlan);
        double[] payments = Billing.computePaymentAmount(patient, 1000.0);
        Log.info("The Bill Amount Paid By Patient and Insurance Company are:");
        Log.info("Rs "+payments[0]+" , Rs "+payments[1]);
        Doctor dr=new Doctor();
        dr.setSalary(10000);
        double monthlyPremium=insurancePlan.computeMonthlyPremium(dr.getSalary());
        Log.info("The Amount Premium Paid by Staff is "+monthlyPremium);
        User staff = new User();
        InsuranceBrand insuranceBrand = new BlueCrossBlueShield();
        insurancePlan.setOfferedBy(insuranceBrand);
        staff.setInsurancePlan(insurancePlan);
        double monPremium=insurancePlan.computeMonthlyPremium(5000, 56, true);
        Log.info("Premium Amount Including Age and Smoking ="+monPremium);
    }
}
