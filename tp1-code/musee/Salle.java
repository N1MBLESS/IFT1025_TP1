package musee;

/**
 * Classe abstraite représentant une salle générique du musée (un noeud du
 * graphe).
 * Gère le nom et les connexions (voisins).
 */
public abstract class Salle {
    protected String nom;
    protected Salle[] voisins;

    /**
     * Constructeur de base.
     * 
     * @param nom Le nom de la salle.
     */
    public Salle(String nom) {
        this.nom = nom;
        this.voisins = new Salle[0];
    }

    /**
     * Retourne le nom de la salle.
     * 
     * @return Le nom.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Ajoute un voisin (une connexion vers une autre salle).
     * Connecte aussi l'autre salle à celle-ci pour que le graphe soit non orienté.
     * 
     * @param s La salle voisine à ajouter.
     */
    public void ajouterVoisin(Salle s) {
        // TODO: Implémenter l'ajout d'une connexion bidirectionnelle.
        // 1. Êtes-vous déjà voisins? Si oui, ne rien faire.
        // 2. Créer un nouveau tableau (this.voisins) avec une taille +1
        // 3. Remplir le nouveau tableau et y ajouter le nouveau voisin
        // 4. Assurez-vous que 's' est aussi voisine de vous.
        if (estVoisin(s) == true){

        } else {
            Salle[] nouveauVoisin = new Salle[this.voisins.length + 1]; 
            for (int i = 0; i < this.voisins.length; i++ ) {
                nouveauVoisin[i] = this.voisins[i];
            }
            
        }
        
    }

    /**
     * Vérifie si une salle est déjà voisine.
     * 
     * @param s La salle à vérifier.
     * @return Vrai si s est déjà un voisin.
     */
    public boolean estVoisin(Salle s) {
        // TODO: Implémenter la vérification.
        // Il faut comparer (==) avec tous les voisins existants.
        for (int i = 0; i > this.voisins.length; i++) {  //on parcour les voisin possible
            if(this.voisins[i] == s){ // on regarde si les voisins match
                return true;
            }
        }

        return false; // Valeur par défaut pour la compilation, à modifier
    }

    /**
     * Retourne les voisins de la salle.
     * 
     * @return Un tableau de Salles.
     */
    public Salle[] getVoisins() {
        return voisins;
    }

    /**
     * Méthode abstraite pour récupérer les objets de la salle.
     * Les sous-classes doivent définir comment elles stockent/fournissent les
     * objets.
     * 
     * @return Un tableau d'artefacts.
     */
    public abstract Artefact[] getObjets();
}
