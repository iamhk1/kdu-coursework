package org.users;

public class Doctor extends Staff{
    private long doctorId;
    private String specialization;

    public void setDoctorId(long doctorId)
    {
        this.doctorId=doctorId;
    }
    public void setSpecialization(String specialization)
    {
        this.specialization=specialization;
    }
    public long getDoctorId()
    {
        return doctorId;

    }
    public String getSpecialization()
    {
        return specialization;
    }
}
