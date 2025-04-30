package web.unchk.gl.web.api.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ReservationRequest")
public class ReservationRequest {

    @XmlElement(name = "livreId")
    private Long livreId;

    @XmlElement(name = "nomUtilisateur")
    private String nomUtilisateur;

    // Getter et Setter pour livreId
    public Long getLivreId() {
        return livreId;
    }

    public void setLivreId(Long livreId) {
        this.livreId = livreId;
    }

    // Getter et Setter pour nomUtilisateur
    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }
}
