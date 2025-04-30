package web.unchk.gl.web.api.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import web.unchk.gl.web.api.model.Reservation;
import web.unchk.gl.web.api.service.ReservationService;

@Endpoint
public class ReservationEndpoint {

    private static final String NAMESPACE_URI = "http://web.unchk.gl/web/api/soap";

    private final ReservationService reservationService;

    @Autowired
    public ReservationEndpoint(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ReservationRequest")
    @ResponsePayload
    public ReservationResponse reserverLivre(@RequestPayload ReservationRequest request) {

        // Créer une nouvelle réservation à partir des données de la requête SOAP
        Reservation reservation = new Reservation();
        reservation.setLivreId(request.getLivreId());
        reservation.setNomUtilisateur(request.getNomUtilisateur());

        // Enregistrer la réservation dans la base de données
        reservation = reservationService.creerReservation(reservation);

        // Créer la réponse SOAP
        ReservationResponse response = new ReservationResponse();
        response.setMessage("Réservation effectuée avec succès !");

        return response;
    }
}
