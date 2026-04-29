package gl2.example.cabinetmedecin.service;

import gl2.example.cabinetmedecin.model.Medecin;
import gl2.example.cabinetmedecin.repository.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedecinService {

    @Autowired
    private MedecinRepository medecinRepository;

    // Recuperer tous les medecins
    public List<Medecin> getAllMedecins() {
        return medecinRepository.findAll();
    }

    // Recuperer un medecin par son id
    public Optional<Medecin> getMedecinById(Long id) {
        return medecinRepository.findById(id);
    }

    // Rechercher des medecins par specialite
    public List<Medecin> getMedecinsBySpecialite(String specialite) {
        return medecinRepository.findBySpecialite(specialite);
    }

    // Ajouter un nouveau medecin
    public Medecin ajouterMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    // Modifier un medecin existant
    public Medecin modifierMedecin(Long id, Medecin medecinModifie) {
        Optional<Medecin> medecinOpt = medecinRepository.findById(id);
        if (medecinOpt.isPresent()) {
            Medecin medecin = medecinOpt.get();
            medecin.setNom(medecinModifie.getNom());
            medecin.setPrenom(medecinModifie.getPrenom());
            medecin.setSpecialite(medecinModifie.getSpecialite());
            medecin.setTelephone(medecinModifie.getTelephone());
            return medecinRepository.save(medecin);
        }
        return null;
    }

    // Supprimer un medecin
    public void supprimerMedecin(Long id) {
        medecinRepository.deleteById(id);
    }
}