package gl2.example.cabinetmedecin.service;

import gl2.example.cabinetmedecin.model.Patient;
import gl2.example.cabinetmedecin.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Recuperer tous les patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Recuperer un patient par son id
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    // Inscrire un nouveau patient
    public Patient ajouterPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Modifier un patient existant
    public Patient modifierPatient(Long id, Patient patientModifie) {
        Optional<Patient> patientOpt = patientRepository.findById(id);
        if (patientOpt.isPresent()) {
            Patient patient = patientOpt.get();
            patient.setNom(patientModifie.getNom());
            patient.setPrenom(patientModifie.getPrenom());
            patient.setDateNaissance(patientModifie.getDateNaissance());
            patient.setTelephone(patientModifie.getTelephone());
            patient.setEmail(patientModifie.getEmail());
            return patientRepository.save(patient);
        }
        return null;
    }

    // Supprimer un patient
    public void supprimerPatient(Long id) {
        patientRepository.deleteById(id);
    }
}

