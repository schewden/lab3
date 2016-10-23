package com.vittach;

/**
 * Created by VITTACH on 23.10.2016.
 */
public class PatientsDate {
    private String date;
    private Patients patient;

    public PatientsDate(String date, Patients patient) {
        this.date = date;
        this.patient = patient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }
}
