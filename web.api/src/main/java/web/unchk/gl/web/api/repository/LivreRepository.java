package web.unchk.gl.web.api.repository;

import web.unchk.gl.web.api.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, Long> {
    List<Livre> findByDisponibleTrue();
}
