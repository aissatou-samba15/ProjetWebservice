package web.unchk.gl.web.api.dto;

public class ReservationRequest {

    private Long livreId;
    private Long utilisateurId; // étudiant ou professeur
    private String dateDebut;   // Date de début de la réservation (format ISO 8601)
    private String dateFin;     // Date de fin de la réservation

    // Constructeur vide
    public ReservationRequest() {
    }

    // Constructeur avec tous les champs
    public ReservationRequest(Long livreId, Long utilisateurId, String dateDebut, String dateFin) {
        this.livreId = livreId;
        this.utilisateurId = utilisateurId;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    // Getters et Setters
    public Long getLivreId() {
        return livreId;
    }

    public void setLivreId(Long livreId) {
        this.livreId = livreId;
    }

    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }
}
