package web.unchk.gl.web.api.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ReservationResponse")
public class ReservationResponse {

    @XmlElement(name = "message")
    private String message;

    // Getter pour message
    public String getMessage() {
        return message;
    }

    // Setter pour message
    public void setMessage(String message) {
        this.message = message;
    }
}
