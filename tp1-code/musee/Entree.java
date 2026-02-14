package musee;

/**
 * Représente l'entrée unique du musée.
 * 
 * <p/>
 * Cette classe utilise le patron de conception «Singleton»: à tout moment, il
 * ne peut y avoir qu'une seule instance de cette classe. Son constructeur est
 * privé, et donc le seul moyen de prendre un objet de type Entree est via la
 * méthode statique Entree.getInstance(). Voir: @see <a href=
 * "https://fr.wikipedia.org/wiki/Singleton_(patron_de_conception)">Singleton
 * (patron de conception)</a>
 * 
 * <p/>
 */
public class Entree extends Salle {
    private static Entree instance;

    /**
     * Constructeur privé pour empêcher l'instanciation directe.
     */
    private Entree() {
        super("entree");
    }

    /**
     * Retourne l'instance unique de l'Entrée.
     * 
     * @return L'instance unique.
     */
    public static Entree getInstance() {
        if (instance == null) {
            instance = new Entree();
        }
        return instance;
    }

    @Override
    public Artefact[] getObjets() {
        return new Artefact[0]; // L'entrée n'a pas d'artefacts
    }
}
