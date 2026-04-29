package gl2.example.cabinetmedecin.service;

import gl2.example.cabinetmedecin.model.Medecin;
import gl2.example.cabinetmedecin.model.Patient;
import gl2.example.cabinetmedecin.model.RendezVous;
import gl2.example.cabinetmedecin.repository.MedecinRepository;
import gl2.example.cabinetmedecin.repository.PatientRepository;
import gl2.example.cabinetmedecin.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RendezVousService {

    @Autowired
    private RendezVousRepository rendezVousRepository;

    @Autowired
    private MedecinRepository medecinRepository;

    @Autowired
    private PatientRepository patientRepository;

    // Recuperer tous les RDV
    public List<RendezVous> getAllRendezVous() {
        return rendezVousRepository.findAll();
    }

    // Recuperer un RDV par son id
    public Optional<RendezVous> getRendezVousById(Long id) {
        return rendezVousRepository.findById(id);
    }

    // Recuperer l'agenda d'un medecin
    public List<RendezVous> getRendezVousByMedecin(Long medecinId) {
        return rendezVousRepository.findByMedecinId(medecinId);
    }

    // Recuperer l'historique d'un patient
    public List<RendezVous> getRendezVousByPatient(Long patientId) {
        return rendezVousRepository.findByPatientId(patientId);
    }

    // Planifier un nouveau RDV : on retrouve d'abord le medecin et le patient
    public RendezVous planifierRendezVous(Long medecinId, Long patientId, RendezVous rdv) {
        Optional<Medecin> medecinOpt = medecinRepository.findById(medecinId);
        Optional<Patient> patientOpt = patientRepository.findById(patientId);

        if (medecinOpt.isPresent() && patientOpt.isPresent()) {
            rdv.setMedecin(medecinOpt.get());
            rdv.setPatient(patientOpt.get());
            rdv.setStatut("PLANIFIE");
            return rendezVousRepository.save(rdv);
        }
        return null;
    }

    // Annuler un RDV : on change juste le statut
    public RendezVous annulerRendezVous(Long id) {
        Optional<RendezVous> rdvOpt = rendezVousRepository.findById(id);
        if (rdvOpt.isPresent()) {
            RendezVous rdv = rdvOpt.get();
            rdv.setStatut("ANNULE");
            return rendezVousRepository.save(rdv);
        }
        return null;
    }

    // Supprimer un RDV
    public void supprimerRendezVous(Long id) {
        rendezVousRepository.deleteById(id);
    }
}
