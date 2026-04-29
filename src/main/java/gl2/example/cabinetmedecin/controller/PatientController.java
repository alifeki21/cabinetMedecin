package gl2.example.cabinetmedecin.controller;

import gl2.example.cabinetmedecin.model.Patient;
import gl2.example.cabinetmedecin.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // GET /api/patients
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    // GET /api/patients/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Optional<Patient> patient = patientService.getPatientById(id);
        return patient.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/patients
    @PostMapping
    public Patient ajouterPatient(@RequestBody Patient patient) {
        return patientService.ajouterPatient(patient);
    }

    // PUT /api/patients/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Patient> modifierPatient(@PathVariable Long id, @RequestBody Patient patient) {
        Patient modifie = patientService.modifierPatient(id, patient);
        if (modifie != null) {
            return ResponseEntity.ok(modifie);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE /api/patients/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerPatient(@PathVariable Long id) {
        patientService.supprimerPatient(id);
        return ResponseEntity.ok("Patient supprime avec succes");
    }
}