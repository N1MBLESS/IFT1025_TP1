# IFT1025–H26 : Travail pratique 1

_(dernière modification: 2026-02-06)_

## Introduction

Dans ce TP vous allez travailler avec du code qui modélise les musées et les touristes qui les visitent. Un musée sera representé par un ensemble de salles reliées entre elles par des passages. Chaque salle peut contenir un nombre des artefacts culturels. Chaque musée aura une entrée et [une sortie](https://www.imdb.com/title/tt1587707/).

Un musée est donc representé comme un graphe non orienté, où chaque salle est un noeud et chaque passage entre salles est une arête. Nous utilisons les listes d’adjacence (liste de voisins), implémentées avec des tableaux de Java.

Par exemple, voici une version fictive du plan du [Musée Pointe-à-Callière](https://fr.wikipedia.org/wiki/Pointe-%C3%A0-Calli%C3%A8re,_cit%C3%A9_d%27arch%C3%A9ologie_et_d%27histoire_de_Montr%C3%A9al): 

![](pointe.png)

Pour ce graphe, vous avez les listes d’adjacence suivants (l'ordre d'apparition des noeuds voisins n'est pas importante):

 - entree -> eperon
 - sortie -> marins
 - eperon -> entree, crypte, douane
 - crypte -> eperon, douane, station
 - douane -> crypte, station, eperon
 - station -> douane, marins, crypte
 - marins -> station, sortie

Les différents types d'artefacts sont representés par un [Type énuméré](https://fr.wikipedia.org/wiki/Type_%C3%A9num%C3%A9r%C3%A9): une classe qui regroupe une liste de constantes. Voir aussi: [Programmation Java/Énumérations](https://fr.wikibooks.org/wiki/Programmation_Java/%C3%89num%C3%A9rations) et [Java Enums](https://www.w3schools.com/java/java_enums.asp).

Vous avez 3 tâches à faire:

1. Comprendre le code et critiquer sa conception (6 points)
2. Coder quelques méthodes du code (10 points)
3. Décrire des modifications selon vos critiques (4 points)


## Code Squelette

Le code squelette comporte 3 packages avec 11 classes, ainsi que 2 packages de tests (sans et avec JUnit, comme les dévoirs) avec 6 classes de test.

Il y a beaucoup de code. C'est exprès. La majorité de votre travail sera de comprendre ce code.

**Assurez-vous de bien lire les commentaires javadoc!**

### Package musee

Classes et enum:

- Musee, classe abstraite. Voir la classe exemple.PointeACalliere pour une implémentation concrète. La classe inclut des fonctionnalités pour l'exportation du plan d'un musée en utilisant la langage DOT. Nous avons créé l'image ci-dessus [avec ces fonctionnalités](https://quickchart.io/graphviz?graph=graph{entree--eperon;sortie--marins;eperon--entree;eperon--crypte;eperon--douane;crypte--eperon;crypte--douane;crypte--station;douane--crypte;douane--station;douane--eperon;station--douane;station--marins;station--crypte;marins--station;marins--sortie;}).
- Salle, classe abstraite, avec les sous-classes:
	+ Entree 
	+ Sortie 
	+ SalleDExposition
- Artefact, type enuméré. Voir la classe exemple.PointeACalliere pour des exemples d'utilisation. 

Les classes Entree et Sortie sont un peu particuliers, car ils suivent le patron de conception «[Singleton](https://fr.wikipedia.org/wiki/Singleton_(patron_de_conception))». Cela veut dire qu'il y aura toujours une seule instance de Entree et une seule instance de Sortie.

### Package tourisme

Classes et interfaces:

- Visiteur, un interface
- Touriste, qui implémente l'interface Visiteur
- PlanDeVisite, une classe qui englobe une liste des noms des salles et qui peut être utilisée pour vérifier si le plan de visite à une corréspondance avec le plan du musée.

### Package exemple

Classes: 
- PointeACalliere (sous-classe de musee.Musee) vous donne un exemple de création d'une musée. 
- Main contient un fonction main, qui montre comment utiliser le reste.

Si tout était bien implémenté, la méthode Main.main() que nous vous donnons s'executerait avec la sortie:

```
--- Création du Musée Pointe-à-Callière ---
Structure du Musée (Liste d'Adjacence) :
  [entree] -> eperon
  [sortie] -> marins
  [eperon] -> entree, crypte, douane
  [crypte] -> eperon, douane, station
  [douane] -> crypte, station, eperon
  [station] -> douane, marins, crypte
  [marins] -> station, sortie

--- QuickChart URL ---
https://quickchart.io/graphviz?graph=graph{entree--eperon;sortie--marins;eperon--entree;eperon--crypte;eperon--douane;crypte--eperon;crypte--douane;crypte--station;douane--crypte;douane--station;douane--eperon;station--douane;station--marins;station--crypte;marins--station;marins--sortie;}
----------------------


--- Test 1 : Plan Valide ---
Le plan 1 est valide.

--- Test 2 : Plan Invalide (Saut impossible) ---
Plan invalide : Pas de connexion entre entree et douane
Le plan 2 est invalide.

--- Test 3 : Plan Invalide (Salle inexistante) ---
Plan invalide : La salle 'Salle Imaginaire' n'existe pas dans ce musée.
Le plan 3 est invalide.

--- Test 4 : Simulation de Visite ---
Alice va suivre le plan 1 (Valide).
Alice entre dans le musée par l'entree.
  Aucun artéfact dans cette salle.
  Chemins possibles : eperon
Début de la visite planifiée...
Alice se déplace vers : eperon
  Artéfacts visibles : SCULPTURE, VETEMENT
  Chemins possibles : entree, crypte, douane
Alice se déplace vers : crypte
  Artéfacts visibles : VASE
  Chemins possibles : eperon, douane, station
Fin de la visite planifiée.
Alice est sortie ? false

Bob essaie de suivre le plan 2 (Invalide).
Plan invalide : Pas de connexion entre entree et douane
Le plan est invalide. Visite annulée.
Bob est sorti ? false

--- Test 5 : Visite Complète (avec Sortie) ---
Charlie entre dans le musée par l'entree.
  Aucun artéfact dans cette salle.
  Chemins possibles : eperon
Début de la visite planifiée...
Charlie se déplace vers : eperon
  Artéfacts visibles : SCULPTURE, VETEMENT
  Chemins possibles : entree, crypte, douane
Charlie se déplace vers : crypte
  Artéfacts visibles : VASE
  Chemins possibles : eperon, douane, station
Charlie se déplace vers : station
  Aucun artéfact dans cette salle.
  Chemins possibles : douane, marins, crypte
Charlie se déplace vers : marins
  Artéfacts visibles : SCULPTURE
  Chemins possibles : station, sortie
Charlie se déplace vers : sortie
  Aucun artéfact dans cette salle.
  Chemins possibles : marins
Charlie sort du musée. Visite terminée.
Fin de la visite planifiée.
Charlie est sorti ? true

```


### Packages de test

Comme dans les dévoirs, vous avez une version avec et sans JUnit4. Vos soumissions finales devraient au moins passer ces tests.

## Tâches à faire

_Il n'est pas necessaire de faire les tâches dans l'ordre présentée._

### 1. Comprendre et critiquer (6 points)

Dans cette partie, il n’est pas demandé de proposer des corrections ou des améliorations. Il s’agit uniquement d’analyser et de critiquer la conception existante.

Supposez que le code a été créé par un collègue (ou généré par un système d’IA) selon la spécification (ou prompt) suivante:

#### Exigences Fonctionnelles: 

1.  Domaine : Un Musée composé de plusieurs Salles connectées.
    -   Certaines salles contiennent des Artefacts.
    -   Un musée a une seule Entrée et une seule Sortie.
2.  Visiteurs :
    -   Un Visiteur (Touriste) entre dans le musée, se déplace entre les salles connectées, et observe les artefacts.
    -   Les visiteurs peuvent suivre un itinéraire précis (PlanDeVisite).
3.  Structure de Graphe :
    -   Le musée est un graphe où les Salles sont les nœuds et les connexions sont des arêtes bidirectionnelles.
4.  Exemple de Simulation :
    -   Inclure un exemple concret basé sur le plan du musée "Pointe-à-Callière".


Répondez aux questions suivantes. Vous avez au maximum 1500 charactères par question, espaces compris (ce qui correspond à environ 2 paragraphes). Mettez chaque réponse dans un fichier text (q1.txt, q2.txt, q3.txt). Respectez les limites, elles seront vérifiées automatiquement avec [le programme wc](https://www.man7.org/linux/man-pages/man1/wc.1.html)! Les réponses qui listent plusieurs exemples sans les expliquer seront pénalisées.

#### Q1: Choix de conception non imposés par les exigences

En vous basant uniquement sur les exigences fonctionnelles ci-dessus, identifiez un choix de conception important qui n'est pas explicitement imposé par ces exigences, mais qui aparaît dans le code:

- Indiquez où il apparaît dans le code (classe, attribut, méthode)
- Expliquez brièvement ce que ce choix implique pour le fonctionnement du système

#### Q2: Hypothèses implicites et conséquences

Le code repose sur plusieurs hypothèses implicites concernant l’utilisation correcte des classes (par exemple sur l’ordre des appels, l’état des objets, ou les valeurs possibles). Identifiez une hypothèse de ce type, et expliquez:

- Comment elle apparaît dans le code.
- Ce qui se passe si elle n'est pas respectée.

#### Q3: Cohérence et couplage entre classes

En vous appuyant sur une seule interaction précise (un appel de méthode concret) entre deux classes parmi Musee, Salle, Touriste, PlanDeVisite:

- Décrivez ce que chaque classe doit connaître de l’autre pour fonctionner,
- Expliquez en quoi cette interaction est cohérente (ou non) avec le rôle de chaque classe,
- Identifiez un risque potentiel lié à ce couplage (par exemple pour la compréhension du code ou son utilisation correcte).


### 2. Coder les lacunes (10 points)-------------------------------------------------------------------------------------------

Complétez les méthodes marquées par des `TODO` afin de faire fonctionner la simulation et de passer les tests.

Vous êtes autorisés à modifier **uniquement le corps** des méthodes listées ci-dessous.

Vous pouvez créer des **méthodes auxiliaires `private`** si cela améliore la clarté de votre code, à condition qu’elles soient utilisées uniquement par votre propre code.

Vous **ne devez pas** :

* modifier les signatures des méthodes existantes ;
* changer la visibilité (`public`, `protected`, `private`) ;
* ajouter, supprimer ou modifier des éléments `static` ;
* ajouter ou modifier des attributs ;
* créer de nouvelles classes ou interfaces.

Toute modification en dehors de ces règles entraînera l’échec automatique des tests.

Les tests évaluent le comportement du programme ; l’affichage sert uniquement à la simulation et au débogage, sauf indication contraire dans le code fourni.

Si vous le préférez, vous pouvez utiliser le `Makefile` fourni pour compiler et tester votre code:

- `make compile`: Vérifier que votre code compile.
- `make test`: Lancer les tests unitaires (JUnit).
- `make run`: Lancer la simulation principale.

_Le [Makefile](https://fr.wikipedia.org/wiki/Make) est fourni pour votre commodité et sera utilisé lors de la correction pour compiler et exécuter votre code. Il n’est pas obligatoire de l’utiliser : votre IDE peut très bien convenir. Assurez-vous toutefois que l’IDE ne modifie pas la structure du code (emplacement des fichiers, déclarations de package, etc)._

Soumettez uniquement les quatre fichiers Java suivants (Salle.java, SalleDExposition.java, PlanDeVisite.java, Touriste.java). Pour la correction, ils seront placés directement dans le code squelette fourni. Assurez-vous donc que ces fichiers contiennent les bonnes déclarations de `package`.

#### 1. `musee.Salle`
- `ajouterVoisin(Salle s)` : Gérer la connexion bidirectionnelle entre les salles sans récursion infinie.
- `estVoisin(Salle s)` : Vérifier si deux salles sont connectées.

#### 2. `musee.SalleDExposition`
- `ajouterArtefact(Artefact a)` : Ajouter un objet dans le tableau (redimensionnement manuel).

#### 3. `tourisme.PlanDeVisite`
- `valider(Musee m)` : Vérifier que toutes les étapes du plan existent et sont connectées.

#### 4. `tourisme.Touriste`
- `seDeplacer(Salle s)` : Déplacer le touriste d'une salle à l'autre en vérifiant la connexion.
- `visiter(PlanDeVisite plan, Musee m)` : Suivre un plan de visite complet.

### 3. Décrire des modifications de conception (4 points)----------------------------------------------------------------------------

Dans cette partie, vous devez revenir sur vos analyses de la partie 1 et proposer une modification ciblée de la conception, sans écrire de code.

L’objectif n’est pas de corriger tout le système, mais de montrer que vous êtes capables d’identifier un problème de conception, de proposer une modification cohérente et de raisonner sur ses effets et ses compromis.

Répondez à la question suivante. Vous avez au maximum 2000 caractères, espaces compris. Mettez votre réponse dans un fichier texte (`q4.txt`). Respectez la limite, elle sera vérifiée automatiquement avec [le programme wc](https://www.man7.org/linux/man-pages/man1/wc.1.html).

Vous n’êtes pas évalués sur la “bonne” conception, mais sur la clarté de votre raisonnement.


#### Q4 : Proposition de modification et analyse des compromis

En vous appuyant sur un point précis identifié dans la partie 1 (Q1, Q2 ou Q3) :

1. décrivez une modification de conception ciblée (au niveau des classes et de leurs responsabilités) ;
2. expliquez quel problème identifié en partie 1 cette modification cherche à adresser ;
3. analysez un avantage concret apporté par cette modification ;
4. analysez un inconvénient ou un compromis qu’elle introduit ;
5. indiquez dans quel type de contexte cette modification serait pertinente, et dans quel type de contexte elle le serait moins.

Les cinq points doivent porter sur la même modification.

**Aucun code n’est attendu**


## Précisions globales

Vous devez travailler en équipes de deux. Le travail individuel n’est pas permis, sauf dans des cas exceptionnels et **avec une approbation préalable du professeur**.

Le TP est dû le **vendredi 27 février à 23 h 59**. Aucun retard ne sera accepté.

### Soumission

Les fichiers doivent être soumis via StudiUM.

Un seul membre de l’équipe doit soumettre **uniquement** les fichiers suivants :

1. Les fichiers texte `q1.txt`, `q2.txt`, `q3.txt`, `q4.txt`.
   Ces fichiers doivent respecter strictement les limites de caractères indiquées. Les limites seront vérifiées automatiquement. Tout fichier qui dépasse la limite sera rejeté d’office.

2. Les quatre fichiers Java suivants :

   * `Salle.java`
   * `SalleDExposition.java`
   * `PlanDeVisite.java`
   * `Touriste.java`

   Pour la correction, ces fichiers seront placés directement dans le code squelette fourni. Assurez-vous donc qu’ils contiennent les bonnes déclarations de `package` et qu’ils compilent sans modification du reste du projet.

3. Un fichier `README.txt`, contenant obligatoirement :

   * les noms des deux membres de l’équipe ;
   * les matricules des deux membres de l’équipe ;
   * les adresses courriel des deux membres de l’équipe.

Le second membre de l’équipe doit soumettre **uniquement une copie identique** du fichier `README.txt`.

### À noter

* Lisez le code et les commentaires Javadoc attentivement avant de commencer.
* Pour les questions ouvertes (Q1–Q4), rédigez vos réponses dans un français technique clair, précis et sans ambiguïté. Justifiez vos affirmations. La qualité de la rédaction sera prise en compte dans l’évaluation.
* Votre code doit compiler et s’exécuter tel quel avec le squelette fourni. Tout code qui ne compile pas ou ne s’exécute pas obtiendra la note de zéro pour la partie concernée.
* Vous devez respecter strictement les contraintes indiquées dans la partie «Coder les lacunes». Toute modification hors de ces règles entraînera l’échec automatique des tests.
* Vous devez utiliser uniquement les concepts vus en classe à ce stade du cours. En particulier, l’utilisation de collections Java (`ArrayList`, `LinkedList`, `HashMap`, etc.) ou de bibliothèques externes est interdite.
* Le non-respect des consignes de soumission ou de structure pourra entraîner des pénalités importantes, indépendamment de la qualité fonctionnelle du code.

### Rappel : IA générative

Est-il possible de faire le TP à l’aide d’une IA générative ? Probablement oui. Dans l’ensemble, ce n’est pas un problème très difficile pour un agent de programmation. Il n’est pas non plus difficile de confier le travail à une personne ayant quelques années d’expérience en programmation.

Mais dans ce cas, pourquoi suivre le cours? Si vous prenez votre formation au sérieux, respectez la règle du cours : **l’IA générative n’est pas autorisée pour les devoirs**. Sinon, vous ne faites que perdre votre temps.
