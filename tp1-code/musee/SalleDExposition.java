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
    }

    @Override
    public Artefact[] getObjets() {
        return objets;
    }
}
