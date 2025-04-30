package web.unchk.gl.web.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.unchk.gl.web.api.model.Reservation;
import web.unchk.gl.web.api.repository.ReservationRepository;

import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // Enregistre une nouvelle réservation
    public Reservation creerReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // Recherche une réservation par son ID
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }
}


