package com.vittach;

import com.vittach.enums.DiagnosisEnum;

import java.util.ArrayList;

/**
 * Created by VITTACH on 22.10.2016.
 */
public class Patients {
    private String lastName;
    private String firstName;
    private String birthsday;
    private String patronymic;
    private ArrayList<DiagnosisEnum> diagnos;

    public Patients(String lastName, String firstName, String patronymic, String birthsday) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthsday = birthsday;
        diagnos = new ArrayList<>();
        this.patronymic = patronymic;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBirthsday() {
        return birthsday;
    }

    public void setBirthsday(String birthsday) {
        this.birthsday = birthsday;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public ArrayList<DiagnosisEnum> getDiagnos() {
        return diagnos;
    }

    public void addDiagnos(DiagnosisEnum diagnos){
        this.diagnos.add(diagnos);
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + patronymic;
    }
}
