package com.vittach;

import java.util.Scanner;

/**
 * Created by VITTACH on 22.10.2016.
 */
public class HRManager {
    public static void main(String []argv) {
        Request request = new Request();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n-----------------------------Жариков Виталий Владиславович 2307-----------------------------");
            System.out.println("1-generatePatient; 2-generateDoctors; 3-getAllDiagnosisByPatient; 4-getAllDiagnosisByPatients; 5-getAllPatientsToDoctorByDate; 6-getAllDoctorsByCurrentPatient");
            switch (sc.nextInt()) {
                case 1: request.generatePatient(); break;
                case 2: request.generateDoctors(); break;
                case 3: request.getAllDiagnosisByPatient(); break;
                case 4: request.getAllDiagnosisByPatients();break;
                case 5: request.getAllPatientsToDoctorByDate(); break;
                case 6: request.getAllDoctorsByCurrentPatient();break;
                default: return;
            }
        }
    }
}
