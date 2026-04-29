package gl2.example.cabinetmedecin.repository;

import gl2.example.cabinetmedecin.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
