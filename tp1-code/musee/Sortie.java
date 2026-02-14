package musee;

/**
 * Représente la sortie unique du musée.
 * <p/>
 * Cette classe utilise le patron de conception «Singleton»: à tout moment, il
 * ne peut y avoir qu'une seule instance de cette classe. Son constructeur est
 * privé, et donc le seul moyen de prendre un objet de type Sortie est via la
 * méthode statique Sortie.getInstance(). Voir: @see <a href=
 * "https://fr.wikipedia.org/wiki/Singleton_(patron_de_conception)">Singleton
 * (patron de conception)</a>
 * <p/>
 */
public class Sortie extends Salle {
    private static Sortie instance;

    /**
     * Constructeur privé pour empêcher l'instanciation directe.
     */
    private Sortie() {
        super("sortie");
    }

    /**
     * Retourne l'instance unique de la Sortie.
     * 
     * @return L'instance unique.
     */
    public static Sortie getInstance() {
        if (instance == null) {
            instance = new Sortie();
        }
        return instance;
    }

    @Override
    public Artefact[] getObjets() {
        return new Artefact[0]; // La sortie n'a pas d'artefacts
    }
}
