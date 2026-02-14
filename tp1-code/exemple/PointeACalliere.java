package exemple;

import musee.*;
import tourisme.*;

/**
 * Une implémentation concrète de la classe Musee, inspirée du musée
 * Pointe-à-Callière:
 * https://pacmusee.qc.ca/fr/planifiez-votre-visite-se-situer-dans-le-musee/
 * Salles :
 * - "eperon" : L'Éperon
 * - "crypte" : Crypte archéologique
 * - "douane" : Ancienne-Douane
 * - "station" : Station de pompage D'Youville
 * - "marins" : Maison des-Marins
 */
public class PointeACalliere extends Musee {

    /**
     * Construit le musée avec les salles spécifiques.
     */
    @Override
    public void construire() {
        // Création des salles
        SalleDExposition eperon = new SalleDExposition("eperon");
        eperon.ajouterArtefact(Artefact.SCULPTURE);
        eperon.ajouterArtefact(Artefact.VETEMENT);

        SalleDExposition crypte = new SalleDExposition("crypte");
        crypte.ajouterArtefact(Artefact.VASE);

        SalleDExposition douane = new SalleDExposition("douane");
        douane.ajouterArtefact(Artefact.PEINTURE);
        douane.ajouterArtefact(Artefact.LIVRE);

        SalleDExposition station = new SalleDExposition("station");

        SalleDExposition marins = new SalleDExposition("marins");
        marins.ajouterArtefact(Artefact.SCULPTURE);

        // Ajout des salles au musée
        ajouterSalle(eperon);
        ajouterSalle(crypte);
        ajouterSalle(douane);
        ajouterSalle(station);
        ajouterSalle(marins);

        // Connexions logiques (ne suivent pas le plan réel)
        // Entrée -> Éperon
        this.entree.ajouterVoisin(eperon);

        // Éperon <-> Crypte
        eperon.ajouterVoisin(crypte);

        // Crypte <-> Douane
        crypte.ajouterVoisin(douane);

        // Douane <-> Station
        douane.ajouterVoisin(station);

        // Station <-> Marins
        station.ajouterVoisin(marins);

        // Éperon <-> Douane
        eperon.ajouterVoisin(douane);

        // Crypte <-> Station
        crypte.ajouterVoisin(station);

        // Marins <-> Sortie
        marins.ajouterVoisin(this.sortie);

    }
}
