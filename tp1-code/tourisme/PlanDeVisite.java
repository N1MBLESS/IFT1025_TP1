package tourisme;

import musee.*;

/**
 * Représente un plan de visite planifié par un touriste.
 * Contient une séquence de noms de salles à visiter.
 */
public class PlanDeVisite {
    private String[] etapes;

    /**
     * Constructeur.
     */
    public PlanDeVisite() {
        this.etapes = new String[0];
    }

    /**
     * Ajoute une étape (nom de salle) au plan.
     * 
     * @param nom Le nom de la salle à ajouter.
     */
    public void ajouterEtape(String nom) {
        String[] nouvellesEtapes = new String[this.etapes.length + 1];
        for (int i = 0; i < this.etapes.length; i++) {
            nouvellesEtapes[i] = this.etapes[i];
        }
        nouvellesEtapes[this.etapes.length] = nom;
        this.etapes = nouvellesEtapes;
    }

    /**
     * Retourne les étapes du plan.
     * 
     * @return Le tableau des noms de salles.
     */
    public String[] getEtapes() {
        return etapes;
    }

    /**
     * Valide le plan de visite.
     * Vérifie que chaque étape consécutive est reliée par une connexion (voisin)
     * dans le musée donné.
     * 
     * @param m Le musée dans lequel valider le plan.
     * @return true si le plan est valide, false sinon.
     */
    public boolean valider(Musee m) {
        // TODO: Vérifier si la séquence d'étapes est physiquement possible.
        // Si le plan a 0 ou 1 étape, c'est valide par défaut.
        // Sinon, itérer sur les étapes
        // 1. Récupérer la salle 'Actuelle' (i) et 'Suivante' (i+1) via m.getSalle().
        // 2. Vérifier si ces salles existent (!=null) et s'ils sont voisins.
        // 3. Si tout est correct, retourner true.

        return false; // Pour la compilation, à modifier.
    }
}
