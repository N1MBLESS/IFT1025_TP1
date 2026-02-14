package testSansJUnit;

import musee.*;
import tourisme.*;
import exemple.PointeACalliere;

public class TouristeTest {

    public static void main(String[] args) {
        testSeDeplacerValide();
        testSeDeplacerInvalide();
        testVisiterReussite();
        testVisiterEchec();
    }

    public static void success(String nomDeTest) {
        System.out.println("Test " + nomDeTest + " reussi.");
    }

    public static void echec(String nomDeTest, String message) {
        System.err.println("Test " + nomDeTest + " echoue! " + message);
    }

    public static void testSeDeplacerValide() {
        Musee musee = new PointeACalliere();
        musee.construire();
        Touriste touriste = new Touriste("Testeur");

        touriste.entrer(musee);
        Salle destination = musee.getSalle("eperon");
        touriste.seDeplacer(destination);

        if ("eperon".equals(touriste.getSalleCourante().getNom())) {
            success("testSeDeplacerValide");
        } else {
            echec("testSeDeplacerValide", "Touriste n'est pas arrivé dans la bonne salle.");
        }
    }

    public static void testSeDeplacerInvalide() {
        Musee musee = new PointeACalliere();
        musee.construire();
        Touriste touriste = new Touriste("Testeur");

        touriste.entrer(musee);
        Salle destinationLointaine = musee.getSalle("douane");

        touriste.seDeplacer(destinationLointaine);

        if ("entree".equals(touriste.getSalleCourante().getNom())) {
            success("testSeDeplacerInvalide");
        } else {
            echec("testSeDeplacerInvalide", "Touriste ne devrait pas avoir bougé.");
        }
    }

    public static void testVisiterReussite() {
        Musee musee = new PointeACalliere();
        musee.construire();
        Touriste touriste = new Touriste("Testeur");

        PlanDeVisite plan = new PlanDeVisite();
        plan.ajouterEtape("entree");
        plan.ajouterEtape("eperon");
        plan.ajouterEtape("crypte");
        plan.ajouterEtape("station");
        plan.ajouterEtape("marins");
        plan.ajouterEtape("sortie");

        boolean result = touriste.visiter(plan, musee);
        boolean sorti = (touriste.getSalleCourante() == null);

        if (result && sorti) {
            success("testVisiterReussite");
        } else {
            echec("testVisiterReussite", "La visite complète aurait dû réussir et sortir.");
        }
    }

    public static void testVisiterEchec() {
        Musee musee = new PointeACalliere();
        musee.construire();
        Touriste touriste = new Touriste("Testeur");

        PlanDeVisite plan = new PlanDeVisite();
        plan.ajouterEtape("entree");
        plan.ajouterEtape("eperon");
        // Arrêt prématuré

        boolean result = touriste.visiter(plan, musee);
        boolean encoreDedans = (touriste.getSalleCourante() != null);

        if (!result && encoreDedans) {
            success("testVisiterEchec");
        } else {
            echec("testVisiterEchec", "La visite incomplète aurait dû échouer et laisser le touriste dedans.");
        }
    }
}
