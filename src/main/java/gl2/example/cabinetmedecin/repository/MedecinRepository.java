package gl2.example.cabinetmedecin.repository;

import gl2.example.cabinetmedecin.model.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {

    // Methode personnalisee : Spring Data genere automatiquement la requete
    // a partir du nom de la methode
    List<Medecin> findBySpecialite(String specialite);
}
