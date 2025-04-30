package web.unchk.gl.web.api.contrller;

import web.unchk.gl.web.api.model.Livre;
import web.unchk.gl.web.api.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livres")
public class LivreController {

    @Autowired
    private LivreService livreService;

    // Tous les livres
    @GetMapping
    public List<Livre> getAllLivres() {
        return livreService.getAllLivres();
    }

    // Livre par ID
    @GetMapping("/{id}")
    public Livre getLivreById(@PathVariable Long id) {
        return livreService.getLivreById(id);
    }

    // Livres disponibles
    @GetMapping("/disponibles")
    public List<Livre> getLivresDisponibles() {
        return livreService.getLivresDisponibles();
    }

    // Ajouter un livre
    @PostMapping
    public Livre addLivre(@RequestBody Livre livre) {
        return livreService.addLivre(livre);
    }

    // Modifier un livre
    @PutMapping("/{id}")
    public Livre updateLivre(@PathVariable Long id, @RequestBody Livre livre) {
        return livreService.updateLivre(id, livre);
    }

    // Supprimer un livre
    @DeleteMapping("/{id}")
    public void deleteLivre(@PathVariable Long id) {
        livreService.deleteLivre(id);
    }

    // 🎯 Obtenir juste les titres
    @GetMapping("/titres")
    public List<String> getTitresLivres() {
        return livreService.getTitresLivres();
    }
}
