import java.util.*;
import java.util.stream.Collectors;

public class Fifa {
    private Map<Competition, EnsembleEquipe> mapFifa;

    public Fifa() {
        mapFifa = new HashMap<>();
    }

    public void ajouterCompetition(Competition c) {
        if (!mapFifa.containsKey(c)) {
            mapFifa.put(c, new EnsembleEquipe());
        }
    }

    public void ajouterEquipe(Competition c, Equipe e) {
        ajouterCompetition(c);
        EnsembleEquipe ensembleEquipe = mapFifa.get(c);
        if (!ensembleEquipe.rechercherEquipe(e)) {
            ensembleEquipe.ajouterEquipe(e);
        }
    }

    public void afficherFifa() {
        mapFifa.values().forEach(EnsembleEquipe::afficherEquipes);
//        mapFifa.forEach((key, value) -> {
//            value.afficherEquipes();
//            System.out.println(key.toString());
//        });
    }

    public List<Equipe> retournerEquipesParPays(String pays) {
        return mapFifa.values().stream()
                .flatMap(e -> e.getEquipes().stream())
                .filter(e -> e.getPays().equals(pays))
                .collect(Collectors.toList());
    }

    public void afficherEquipesPersonnalisees(Competition c, String nationalite) {
        mapFifa.get(c).getEquipes()
                .stream()
                .filter(equipe -> equipe.rechercherJoueurParNationalite(nationalite))
                .forEach(System.out::println);
    }

    public List<Competition> retournerCompetitionParJoueurTunisien() {
        List<Competition> list = new ArrayList<>();
        mapFifa.forEach((competition, ensembleEquipe) -> {
            boolean tunisian =
                    ensembleEquipe.getEquipes()
                            .stream()
                            .flatMap(equipe -> equipe.getJoueurs().stream())
                            .anyMatch(s -> s.getNationalite().equalsIgnoreCase("Tunisien"));
            if (tunisian) {
                list.add(competition);
            }
        });
        return list;
    }

//    public List<Competition> retournerCompetitionParJoueurTunisien() {
//        List<Competition> list = new ArrayList<>();
//        mapFifa.entrySet().stream().forEach((map) -> {
//            if (map.getValue().getEquipes().stream()
//                    .flatMap(equipe -> equipe.getJoueurs().stream())
//                    .anyMatch(s -> s.getNationalite().equals("tunisie")))
//                list.add(map.getKey());
//        });
//        return list;
//    }


    public boolean returnSiUneEquipeParticpeEnPlusieursCompetitions() {
        Map<Equipe, Integer> map = new HashMap<>();
        mapFifa.values().stream().forEach(ensembleEquipe -> {
            ensembleEquipe.getEquipes().stream().forEach(equipe -> {
                if (!map.containsKey(equipe)) {
                    map.put(equipe, 1);
                } else {
                    int x = map.get(equipe);
                    map.put(equipe, ++x);
                }
            });
        });

        return map.values().stream().anyMatch(s -> s >= 2);
    }
}
