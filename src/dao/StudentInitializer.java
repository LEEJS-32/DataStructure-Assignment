/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author jians
 */
public class StudentInitializer {
    
    public boolean updateApplicant(ApplicantManagement updatedApplicant) {
        ApplicantManagement existingApplicant = getApplicantById(updatedApplicant.getId());
        if (existingApplicant != null) {
            existingApplicant.setName(updatedApplicant.getName());
            existingApplicant.setSkills(updatedApplicant.getSkills());
            existingApplicant.setLocation(updatedApplicant.getLocation());
            return true;
        }
        return false;
    }

    public boolean deleteApplicant(String id) {
        for (int i = 1; i <= applicantsDatabase.getNumberOfEntries(); i++) {
            ApplicantManagement applicant = applicantsDatabase.getEntry(i);
            if (applicant.getId().equals(id)) {
                applicantsDatabase.remove(i);
                return true;
            }
        }
        return false;
    }

}
