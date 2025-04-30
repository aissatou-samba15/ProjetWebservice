package web.unchk.gl.web.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.unchk.gl.web.api.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Tu peux ajouter des méthodes personnalisées ici plus tard si besoin
}
