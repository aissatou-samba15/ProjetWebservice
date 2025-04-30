package web.unchk.gl.web.api.service;

import web.unchk.gl.web.api.model.Livre;
import web.unchk.gl.web.api.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    // Récupérer tous les livres
    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    // Récupérer un livre par son ID
    public Livre getLivreById(Long id) {
        return livreRepository.findById(id).orElse(null);
    }

    // Ajouter un nouveau livre
    public Livre addLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    // Mettre à jour un livre
    public Livre updateLivre(Long id, Livre livre) {
        Livre existingLivre = livreRepository.findById(id).orElse(null);
        if (existingLivre != null) {
            existingLivre.setTitre(livre.getTitre());
            existingLivre.setAuteur(livre.getAuteur());
            existingLivre.setDisponible(livre.isDisponible());
            return livreRepository.save(existingLivre);
        }
        return null;
    }

    // Supprimer un livre
    public void deleteLivre(Long id) {
        livreRepository.deleteById(id);
    }

    // Récupérer seulement les livres disponibles
    public List<Livre> getLivresDisponibles() {
        return livreRepository.findByDisponibleTrue();
    }

    // Récupérer seulement les titres des livres
    public List<String> getTitresLivres() {
        return livreRepository.findAll()
                .stream()
                .map(Livre::getTitre)
                .collect(Collectors.toList());
    }
}
