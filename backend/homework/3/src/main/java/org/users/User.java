package org.users;

import org.billingcomponent.HealthInsurancePlan;

public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private boolean insured;
    public boolean getInsured()
    {
        return insured;
    }
    public void setInsured(boolean insured)
    {
        this.insured=insured;
    }
    public void setId(long id)
    {
        this.id=id;
    }
    public void setFirstName(String firstName)
    {
        this.firstName=firstName;
    }
    public void setLastName(String lastName)
    {
        this.lastName=lastName;
    }
    public void setGender(String gender)
    {
        this.gender=gender;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public long getId()
    {
        return id;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getGender()
    {
        return gender;
    }
    public String getEmail()
    {
        return email;
    }

    private static HealthInsurancePlan insurancePlan;
    public void setInsurancePlan(HealthInsurancePlan insurancePlan)
    {
        this.insurancePlan=insurancePlan;
    }
    public HealthInsurancePlan getInsurancePlan()
    {
        return insurancePlan;
    }

}
