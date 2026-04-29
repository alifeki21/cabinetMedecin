package gl2.example.cabinetmedecin.controller;

import gl2.example.cabinetmedecin.model.RendezVous;
import gl2.example.cabinetmedecin.service.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/rendezvous")
public class RendezVousController {

    @Autowired
    private RendezVousService rendezVousService;

    // GET /api/rendezvous
    @GetMapping
    public List<RendezVous> getAllRendezVous() {
        return rendezVousService.getAllRendezVous();
    }

    // GET /api/rendezvous/{id}
    @GetMapping("/{id}")
    public ResponseEntity<RendezVous> getRendezVousById(@PathVariable Long id) {
        Optional<RendezVous> rdv = rendezVousService.getRendezVousById(id);
        return rdv.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /api/rendezvous/medecin/{id} : agenda d'un medecin
    @GetMapping("/medecin/{id}")
    public List<RendezVous> getRendezVousByMedecin(@PathVariable Long id) {
        return rendezVousService.getRendezVousByMedecin(id);
    }

    // GET /api/rendezvous/patient/{id} : historique d'un patient
    @GetMapping("/patient/{id}")
    public List<RendezVous> getRendezVousByPatient(@PathVariable Long id) {
        return rendezVousService.getRendezVousByPatient(id);
    }

    // POST /api/rendezvous?medecinId=X&patientId=Y
    @PostMapping
    public ResponseEntity<RendezVous> planifierRendezVous(
            @RequestParam Long medecinId,
            @RequestParam Long patientId,
            @RequestBody RendezVous rdv) {
        RendezVous nouveau = rendezVousService.planifierRendezVous(medecinId, patientId, rdv);
        if (nouveau != null) {
            return ResponseEntity.ok(nouveau);
        }
        return ResponseEntity.badRequest().build();
    }

    // PUT /api/rendezvous/{id}/annuler
    @PutMapping("/{id}/annuler")
    public ResponseEntity<RendezVous> annulerRendezVous(@PathVariable Long id) {
        RendezVous annule = rendezVousService.annulerRendezVous(id);
        if (annule != null) {
            return ResponseEntity.ok(annule);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE /api/rendezvous/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerRendezVous(@PathVariable Long id) {
        rendezVousService.supprimerRendezVous(id);
        return ResponseEntity.ok("Rendez-vous supprime avec succes");
    }
}