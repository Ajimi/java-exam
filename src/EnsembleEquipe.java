import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EnsembleEquipe {
    public Set<Equipe> equipes;

    public EnsembleEquipe() {
        equipes = new HashSet<>();
    }
    public Set<Equipe> getEquipes() {
        return equipes;
    }

    public void ajouterEquipe(Equipe e) {
        equipes.add(e);
    }

    public void supprimerEquipe(Equipe e) {
        equipes.remove(e);
    }

    public boolean rechercherEquipe(Equipe e) {
        return equipes.contains(e);
    }

    public void afficherEquipes() {
        equipes.stream().forEach(System.out::println);
    }

    public Set<Equipe> trierEquipesParNom() {
        return equipes.stream().sorted(Comparator.comparing(Equipe::getNom)).collect(Collectors.toSet());
    }
}
