package com.mycompany.pharmacymanagementsystem.Model;

import java.time.LocalDate; 
import java.util.List;

public class Prescription {
    private int prescriptionID;
    private String patientName;
    private String doctorName;
    private List<Item> items;
    private LocalDate datePrescribed; 

    public Prescription() {
    }

    public Prescription(int prescriptionID, String patientName, String doctorName, List<Item> items, LocalDate datePrescribed) {
        this.prescriptionID = prescriptionID;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.items = items;
        this.datePrescribed = datePrescribed;
    }

    public int getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public LocalDate getDatePrescribed() {
        return datePrescribed;
    }

    public void setDatePrescribed(LocalDate datePrescribed) {
        this.datePrescribed = datePrescribed;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "prescriptionID=" + prescriptionID +
                ", patientName='" + patientName + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", items=" + items +
                ", datePrescribed=" + datePrescribed +
                '}';
    }
}
