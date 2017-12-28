public class Joueur {
    private int id;
    private String nom;
    private String nationalite;

    public Joueur() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String toString() {
        return "Joueur{" + "id=" + id + ", nom=" + nom + ", nationalite=" + nationalite + "}";
    }

    public int hashCode() {
        return id;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Joueur) {
            final Joueur other = (Joueur) obj;
            return this.id != other.id;
        }
        return false;
    }
}
