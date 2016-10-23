package com.vittach;

import java.util.ArrayList;

/**
 * Created by VITTACH on 23.10.2016.
 */
public class Doctors extends Patients {
    private String post;
    private String specialization;

    private ArrayList<PatientsDate> patientsDates;

    public Doctors(String lastName, String firstName, String patronymic, String birthsday, String post, String specialization) {
        super(lastName, firstName, patronymic, birthsday);
        this.post = post;
        patientsDates = new ArrayList<>();
        this.specialization = specialization;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getSpecialization(){
        return specialization;
    }

    public ArrayList<PatientsDate> getPatient() {
        return patientsDates;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void addPatient(Patients patient,String date) {
        patientsDates.add(new PatientsDate(date,patient));
    }
}
