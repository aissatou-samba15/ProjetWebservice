package web.unchk.gl.web.api.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // L'identifiant de l'utilisateur qui a réservé
    private LocalDate dateDebut; // La date de début de la réservation
    private LocalDate dateFin; // La date de fin de la réservation

    @ManyToOne
    @JoinColumn(name = "livre_id")
    private Livre livre; // Lien avec l'entité Livre

    // Constructeurs
    public Reservation() {}

    public Reservation(Long userId, LocalDate dateDebut, LocalDate dateFin, Livre livre) {
        this.userId = userId;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.livre = livre;
    }

    // Getters et Setters
    public Long getId() { return id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public LocalDate getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }

    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }

    public Livre getLivre() { return livre; }
    public void setLivre(Livre livre) { this.livre = livre; }

    // Méthodes supplémentaires pour manipuler livreId et nomUtilisateur

    // Si tu veux manipuler le livreId directement (au lieu de l'objet livre entier)
    public Long getLivreId() {
        return livre != null ? livre.getId() : null;
    }

    // Si tu veux obtenir un nom d'utilisateur basé sur l'userId
    public String getNomUtilisateur() {
        // Exemple simple : retourne "Utilisateur " suivi de l'userId
        return "Utilisateur " + userId;
    }

    // Si tu veux directement assigner livreId et nomUtilisateur dans ton endpoint ou service
    public void setLivreId(Long livreId) {
        if (livre != null) {
            livre.setId(livreId); // Assigne l'ID au livre
        }
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        // Logique pour lier un nom d'utilisateur spécifique
        // Par exemple, tu pourrais stocker le nom de l'utilisateur dans une variable ou l'utiliser pour trouver l'utilisateur
        this.userId = Long.parseLong(nomUtilisateur); // Exemple de transformation
    }
}
