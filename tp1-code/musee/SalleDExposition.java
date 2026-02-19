package musee;

/**
 * Représente une salle d'exposition standard contenant des artefacts.
 */
public class SalleDExposition extends Salle {
    private Artefact[] objets;

    /**
     * Constructeur.
     * 
     * @param nom Le nom de la salle.
     */
    public SalleDExposition(String nom) {
        super(nom);
        this.objets = new Artefact[0];
    }

    /**
     * Ajoute un objet (artefact) à la collection de la salle.
     * Redimensionne le tableau d'objets manuellement.
     * 
     * @param a L'artefact à ajouter.
     */
    public void ajouterArtefact(Artefact a) {
        // TODO: Ajouter un artefact à la collection 'objets'.
        // Rappel: Les tableaux en Java ont une taille fixe.
        // Il faut donc créer un nouveau tableau de taille +1 et remplacer
        // l'ancien tableau par le nouveau.

        //cree nouveau tab de taille +1
        Artefact nouveauObjets[] =  new Artefact[this.objets.length + 1];
        for (int i = 0; i < this.objets.length; i++) {
            nouveauObjets[i] = this.objets[i];  
        }
        //ajout de nouveau artefact "a" a la fin de tab
        nouveauObjets[this.objets.length] = a; 
        this.objets = nouveauObjets; //ancien tab = nouveau tab
    }

    @Override
    public Artefact[] getObjets() {
        return objets;
    }
}
