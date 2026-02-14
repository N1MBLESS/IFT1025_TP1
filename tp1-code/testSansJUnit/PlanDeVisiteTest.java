package testSansJUnit;

import musee.*;
import tourisme.*;
import exemple.PointeACalliere;

public class PlanDeVisiteTest {

    public static void main(String[] args) {
        testValiderPlanValide();
        testValiderPlanInvalideSaut();
        testValiderPlanInvalideSalleInexistante();
        testPlanVide();
    }

    public static void success(String nomDeTest) {
        System.out.println("Test " + nomDeTest + " reussi.");
    }

    public static void echec(String nomDeTest, String message) {
        System.err.println("Test " + nomDeTest + " echoue! " + message);
    }

    public static void testValiderPlanValide() {
        Musee musee = new PointeACalliere();
        musee.construire();
        PlanDeVisite plan = new PlanDeVisite();
        plan.ajouterEtape("entree");
        plan.ajouterEtape("eperon");
        plan.ajouterEtape("crypte");

        if (plan.valider(musee)) {
            success("testValiderPlanValide");
        } else {
            echec("testValiderPlanValide", "Le plan valide a été refusé.");
        }
    }

    public static void testValiderPlanInvalideSaut() {
        Musee musee = new PointeACalliere();
        musee.construire();
        PlanDeVisite plan = new PlanDeVisite();
        plan.ajouterEtape("entree");
        plan.ajouterEtape("douane");

        if (!plan.valider(musee)) {
            success("testValiderPlanInvalideSaut");
        } else {
            echec("testValiderPlanInvalideSaut", "Le plan invalide (saut) a été accepté.");
        }
    }

    public static void testValiderPlanInvalideSalleInexistante() {
        Musee musee = new PointeACalliere();
        musee.construire();
        PlanDeVisite plan = new PlanDeVisite();
        plan.ajouterEtape("entree");
        plan.ajouterEtape("Narnia");

        if (!plan.valider(musee)) {
            success("testValiderPlanInvalideSalleInexistante");
        } else {
            echec("testValiderPlanInvalideSalleInexistante", "Le plan avec salle inexistante a été accepté.");
        }
    }

    public static void testPlanVide() {
        Musee musee = new PointeACalliere();
        musee.construire();
        PlanDeVisite plan = new PlanDeVisite();

        if (plan.valider(musee)) {
            success("testPlanVide");
        } else {
            echec("testPlanVide", "Un plan vide devrait être valide.");
        }
    }
}
