package gl2.example.cabinetmedecin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class RendezVous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Un rendez-vous est lie a UN medecin (relation ManyToOne)
    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

    // Un rendez-vous est lie a UN patient (relation ManyToOne)
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private String dateHeure;   // ex: "2026-05-20 10:30"
    private String motif;        // ex: "Consultation generale"
    private String statut;       // "PLANIFIE", "ANNULE", "TERMINE"

    // Constructeur vide obligatoire pour JPA
    public RendezVous() {
    }

    public RendezVous(Medecin medecin, Patient patient, String dateHeure, String motif) {
        this.medecin = medecin;
        this.patient = patient;
        this.dateHeure = dateHeure;
        this.motif = motif;
        this.statut = "PLANIFIE"; // par defaut, un nouveau RDV est planifie
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(String dateHeure) {
        this.dateHeure = dateHeure;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
