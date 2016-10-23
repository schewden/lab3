package com.vittach;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import com.vittach.enums.DiagnosisEnum;
import com.vittach.enums.SpecializationEnum;

/**
 * Created by VITTACH on 23.10.2016.
 */
public class Request {
    private Scanner sc;
    private int countOfDiagnos; // random
    private ArrayList<Doctors> doctors;
    private ArrayList<Patients> patients;
    private int countOfPatientsToDoctors;
    private Random r = new Random(System.currentTimeMillis());

    Request() {
        sc = new Scanner(System.in);
        doctors = new ArrayList<>();
        patients= new ArrayList<>();
    }

    public void generatePatient() {
        String lastName;
        String firstName;
        String birthsday;
        String patronymic;
        DiagnosisEnum mydiagnosis;
        DiagnosisEnum diagnosis[];

        System.out.print("Input patient last name: ");
        lastName = sc.nextLine();
        System.out.print("Input patient first name: ");
        firstName = sc.nextLine();
        System.out.print("Input patient patronymic name: ");
        patronymic = sc.nextLine();
        System.out.print("Input patient birthsday date: ");
        birthsday = sc.nextLine();

        Patients patient = new Patients(lastName, firstName, patronymic, birthsday);
        diagnosis = DiagnosisEnum.values();
        countOfDiagnos = r.nextInt(2) + 1;
        for (int j=0;j<countOfDiagnos; j++) {
            mydiagnosis = diagnosis[r.nextInt(diagnosis.length - 1)];
            System.out.println("Add this diagnosis: " + mydiagnosis);
            patient.addDiagnos(mydiagnosis);
        }
        patients.add(patient);
    }

    public void generateDoctors() {
        String date;
        String lastName;
        String firstName;
        String birthsday;
        Patients patient;
        String patronymic;

        System.out.print("Input doctor last name: ");
        lastName = sc.nextLine();
        System.out.print("Input doctor first name: ");
        firstName = sc.nextLine();
        System.out.print("Input doctor patronymic name: ");
        patronymic = sc.nextLine();
        System.out.print("Input doctor birthsday date: ");
        birthsday = sc.nextLine();

        DiagnosisEnum posts[] = DiagnosisEnum.values();
        SpecializationEnum specializations[] = SpecializationEnum.values();

        Doctors doctor = new Doctors(lastName,
                                    firstName,
                                    patronymic,
                                    birthsday,
                                    posts[r.nextInt(posts.length - 1)].toString(),
                                    specializations[r.nextInt(specializations.length- 1)].toString());
        countOfPatientsToDoctors=r.nextInt(patients.size())+ 1;
        for (int j = 0;j<countOfPatientsToDoctors; j++) {
            date = String.valueOf(r.nextInt(31)) + "/" + String.valueOf(r.nextInt(12)) + "/" + "2016";
            patient = patients.get(r.nextInt(patients.size()));

            System.out.println("Add this patient: " + patient + " at this date: " + date);
            doctor.addPatient(patient, date);
        }
        doctors.add(doctor);
    }

    public void getAllDiagnosisByPatients() {
        for(int i=0;i<92;i++)System.out.print("-");
        for(Patients pt: patients) {
            System.out.println("\nПациент: " + pt);
            System.out.println("Болезни:");
            for(DiagnosisEnum ill: pt.getDiagnos())
                System.out.println("\t" + ill);
        }
    }

    public void getAllDiagnosisByPatient() {
        for(int i=0;i<92;i++)System.out.print("-");
        System.out.print("\nInput patient last name: ");
        String lastName = sc.nextLine();
        System.out.print("Input patient first name: ");
        String firstName = sc.nextLine();
        System.out.print("Input patient patronymic name: ");
        String patronymic = sc.nextLine();

        patients.stream().filter(pt-> pt.getFirstName().equals(firstName)
                && pt.getLastName().equals(lastName)
                && pt.getPatronymic().equals(patronymic)).forEach(pt -> {
            System.out.println("Болезни пациента:");
            for(DiagnosisEnum ill : pt.getDiagnos())
                System.out.println("\t" + ill);
        });
    }

    public void getAllPatientsToDoctorByDate() {
        for(int i=0;i<92;i++)System.out.print("-");
        System.out.print("\nInput doctor last name: ");
        String lastName = sc.nextLine();
        System.out.print("Input doctor first name: ");
        String firstName = sc.nextLine();
        System.out.print("Input doctor patronymic name: ");
        String patronymic = sc.nextLine();
        System.out.print("Input date in format xx/xx/xxxx: ");
        String date = sc.nextLine();
        System.out.println("На эту дату к вам записаны: ");
        doctors.stream().filter(pt -> pt.getFirstName().equals(firstName)
                && pt.getLastName().equals(lastName)
                && pt.getPatronymic().equals(patronymic)).forEach(pt -> {
            ArrayList<PatientsDate> doctorsPatient = pt.getPatient();
            for(PatientsDate pa: doctorsPatient) {
                if(pa.getDate().equals(date)==true)
                    System.out.println("\t"+ pa.getPatient());
            }
        });
    }

    public void getAllDoctorsByCurrentPatient() {
        for(int i=0;i<92;i++)System.out.print("-");
        System.out.print("\nInput patient last name: ");
        String lastName = sc.nextLine();
        System.out.print("Input patient first name: ");
        String firstName = sc.nextLine();
        System.out.print("Input patient patronymic name: ");
        String patronymic = sc.nextLine();
        System.out.println("Пациент записан к: ");
        for(Doctors dt: doctors) {
            ArrayList<PatientsDate> doctorsPatient = dt.getPatient();
            for(PatientsDate pd: doctorsPatient) {
                if(pd.getPatient().getFirstName().equals(firstName)
                   &&pd.getPatient().getLastName().equals(lastName)
                   &&pd.getPatient().getPatronymic().equals(patronymic)) {
                    System.out.println("\t" + dt);
                }
            }
        }
    }
}
