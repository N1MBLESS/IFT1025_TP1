package tourisme;

import musee.*;

/**
 * Implémentation d'un touriste qui parcourt le musée.
 */
public class Touriste implements Visiteur {
    private String nom;
    private Salle salleCourante;

    /**
     * Constructeur.
     * 
     * @param nom Nom du touriste.
     */
    public Touriste(String nom) {
        this.nom = nom;
    }

    @Override
    public void entrer(Musee m) {
        this.salleCourante = m.getEntree();
        System.out.println(nom + " entre dans le musée par l'" + salleCourante.getNom() + ".");
        voirArtefacts();
    }

    @Override
    public void seDeplacer(Salle s) {
        // TODO: Gestion du déplacement unitaire.
        
        // Est-ce que 'salleCourante' est null ?
        // Est-ce que 's' est un voisin valide de 'salleCourante'?
        if (this.salleCourante != null && this.salleCourante.estVoisin(s) == true) {
                // Si c'est un voisin :
                // Mettre à jour 'salleCourante'.
                this.salleCourante=s;
                // Appeler 'voirArtefacts()'.
                voirArtefacts();
                // Si la nouvelle salle est une Sortie, appeler 'sortir()'.
                if(s instanceof Sortie) { sortir();}
        }
        // Sinon, afficher : "Impossible d'aller à S depuis A".
        else{ System.out.println("Impossible d'aller à " + s.getNom() + " depuis " + this.salleCourante.getNom() + ".");}
    }

    @Override
    public void voirArtefacts() {
        if (salleCourante == null)
            return;

        Artefact[] objets = salleCourante.getObjets();
        if (objets.length > 0) {
            System.out.print("  Artéfacts visibles : ");
            for (int i = 0; i < objets.length; i++) {
                System.out.print(objets[i] + (i < objets.length - 1 ? ", " : ""));
            }
            System.out.println();
        } else {
            System.out.println("  Aucun artéfact dans cette salle.");
        }

        // Afficher les directions possibles
        Salle[] voisins = salleCourante.getVoisins();
        if (voisins.length > 0) {
            System.out.print("  Chemins possibles : ");
            for (int i = 0; i < voisins.length; i++) {
                System.out.print(voisins[i].getNom() + (i < voisins.length - 1 ? ", " : ""));
            }
            System.out.println();
        }
    }

    @Override
    public void sortir() {
        if (salleCourante instanceof Sortie) {
            System.out.println(nom + " sort du musée. Visite terminée.");
            salleCourante = null;
        } else {
            System.out.println(nom + " ne peut pas sortir d'ici. Il faut aller à la Sortie.");
        }
    }

    /**
     * Récupère la salle courante pour que le Main puisse guider le visiteur.
     * 
     * @return La salle actuelle.
     */
    public Salle getSalleCourante() {
        return salleCourante;
    }

    @Override
    public boolean visiter(PlanDeVisite plan, Musee m) {
        // TODO: Exécuter une visite complète.
        // Valider le plan avec 'plan.valider(m)'.
        // Récupérer les étapes du plan.
        // Assurer que on est dans le musée (appeler 'entrer(m)' si nécessaire).
        // Itérer sur chaque étape du plan :
        // a. Récupérer la salle cible via m.getSalle().
        // b. Si nécessaire, appeler 'seDeplacer(cible)'.
        // c. Vérifier si le déplacement a réussi avec (salleCourante == cible).
        // On retourne true si on est sorti du musée

        return false; // pour la compilation, à modifier
    }
}
