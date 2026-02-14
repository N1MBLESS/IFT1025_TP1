package testSansJUnit;

import musee.*;

public class SalleTest {

    public static void main(String[] args) {
        testAjouterVoisin();
        testAjouterVoisinDoublon();
        testEstVoisin();
        testAjouterArtefact();
    }

    public static void success(String nomDeTest) {
        System.out.println("Test " + nomDeTest + " reussi.");
    }

    public static void echec(String nomDeTest, String message) {
        System.err.println("Test " + nomDeTest + " echoue! " + message);
    }

    public static void testAjouterVoisin() {
        Salle salleA = new SalleDExposition("Salle A");
        Salle salleB = new SalleDExposition("Salle B");

        salleA.ajouterVoisin(salleB);

        if (salleA.estVoisin(salleB) && salleB.estVoisin(salleA)) {
            success("testAjouterVoisin");
        } else {
            echec("testAjouterVoisin", "Les salles ne sont pas voisines après ajout.");
        }
    }

    public static void testAjouterVoisinDoublon() {
        Salle salleA = new SalleDExposition("Salle A");
        Salle salleB = new SalleDExposition("Salle B");

        salleA.ajouterVoisin(salleB);
        salleA.ajouterVoisin(salleB); // Ajout répété

        int count = 0;
        for (Salle s : salleA.getVoisins()) {
            if (s == salleB)
                count++;
        }

        if (count == 1) {
            success("testAjouterVoisinDoublon");
        } else {
            echec("testAjouterVoisinDoublon", "Il devrait y avoir exactement 1 instance du voisin.");
        }
    }

    public static void testEstVoisin() {
        Salle salleA = new SalleDExposition("Salle A");
        Salle salleB = new SalleDExposition("Salle B");

        boolean test1 = !salleA.estVoisin(salleB); // False au début
        salleA.ajouterVoisin(salleB);
        boolean test2 = salleA.estVoisin(salleB); // True après ajout

        if (test1 && test2) {
            success("testEstVoisin");
        } else {
            echec("testEstVoisin", "estVoisin ne retourne pas les bonnes valeurs.");
        }
    }

    public static void testAjouterArtefact() {
        SalleDExposition salleExpo = new SalleDExposition("Exposition");
        Artefact art = Artefact.PEINTURE;
        salleExpo.ajouterArtefact(art);

        Artefact[] objets = salleExpo.getObjets();
        boolean condition = (objets.length == 1) && (objets[0] == Artefact.PEINTURE);

        if (condition) {
            success("testAjouterArtefact");
        } else {
            echec("testAjouterArtefact", "L'artefact n'a pas été ajouté correctement.");
        }
    }
}
