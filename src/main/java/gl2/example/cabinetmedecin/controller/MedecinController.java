package gl2.example.cabinetmedecin.controller;

import gl2.example.cabinetmedecin.model.Medecin;
import gl2.example.cabinetmedecin.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/medecins")
public class MedecinController {

    @Autowired
    private MedecinService medecinService;

    // GET /api/medecins
    @GetMapping
    public List<Medecin> getAllMedecins() {
        return medecinService.getAllMedecins();
    }

    // GET /api/medecins/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Medecin> getMedecinById(@PathVariable Long id) {
        Optional<Medecin> medecin = medecinService.getMedecinById(id);
        return medecin.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /api/medecins/specialite/{spec}
    @GetMapping("/specialite/{spec}")
    public List<Medecin> getMedecinsBySpecialite(@PathVariable String spec) {
        return medecinService.getMedecinsBySpecialite(spec);
    }

    // POST /api/medecins
    @PostMapping
    public Medecin ajouterMedecin(@RequestBody Medecin medecin) {
        return medecinService.ajouterMedecin(medecin);
    }

    // PUT /api/medecins/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Medecin> modifierMedecin(@PathVariable Long id, @RequestBody Medecin medecin) {
        Medecin modifie = medecinService.modifierMedecin(id, medecin);
        if (modifie != null) {
            return ResponseEntity.ok(modifie);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE /api/medecins/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerMedecin(@PathVariable Long id) {
        medecinService.supprimerMedecin(id);
        return ResponseEntity.ok("Medecin supprime avec succes");
    }
}
