package gl2.example.cabinetmedecin.repository;

import gl2.example.cabinetmedecin.model.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {

    // Trouve tous les RDV d'un medecin specifique
    List<RendezVous> findByMedecinId(Long medecinId);

    // Trouve tous les RDV d'un patient specifique
    List<RendezVous> findByPatientId(Long patientId);
}
