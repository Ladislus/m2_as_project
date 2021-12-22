# Projet Analyse Statique

## Composition du groupe
- Ladislas Walcak (2174867)
- Corentin Hervochon (2171782)
- Tom Ribardière (2171029)

## Description des packages
 - [ANTLR](src/main/java/antlr): Contient la grammaire ainsi que les parsers générés par ANTLR
 - [AST](src/main/java/ast): Contient les classes représentant l'AST
 - [Utils](src/main/java/utils):
   - [ASTBuilder](src/main/java/utils/ASTBuilder.kt): Classe utilisant les parsers ANTLR pour construire l'AST
   - [GlobalUtils](src/main/java/utils/GlobalUtils.kt): Classe contenant des fonctions utilitaires (ExitWithCode, parsing du fichier d'entrée, ...)
 - [Visitor](src/main/java/visitor):
   - [Printers](src/main/java/visitor/printers): Contient les visiteurs Printer (`-v` ou `--verbose`) & ASTPrinter (`-a` ou `--ast`)
   - [Flow](src/main/java/visitor/flow): Contient les visiteurs et classes permettant de créer le flow du programme
   - [Analyse](src/main/java/visitor/analyse): Contient les visiteurs de chacunes des analyses

## Éxécution du programme et des différentes analyses

Lien projet
`https://github.com/Ladislus/m2_as_project`

Pour lancer le projet, deux méthodes:  
 - Depuis l'IDE intelliJ en lancant la fonction main de la classe `Main.kt`
 - En utilisant l'executable gradlew fourni par Gradle, exemple:  
`./gradlew --console=plain --quiet run --args "src/main/resources/programs/personnal/prog1 -v --ast -ae"`

### Liste des flags:
- Options d'affichage et de rendu 
   - `-h` ou `--help` -> Affiche l'aide
   - `-v` ou `--verbose` -> Affiche le programme exécuté (à l'aide du Printer)
   - `-a` ou `--ast` -> Affiche l'abstract syntax tree du programme analysé
   - `-d` ou `--dot` -> Converti le fichier de sortie XXX.dot en un XXX.png (nécessite d'avoir Graphviz installé et dans le path)
 - Les différentes analyses misent en place :
   - `-ae` -> Available Expression Analysis
   - `-rd` -> Reaching Definition Analysis
   - `-vb` -> Very Busy Expression Analysis
   - `-lv` -> Live Variable Analysis

Le retour pour ces différentes analyses sont les entrées pour tous les points du programme analysé, en réalisant l'algorithme du Maximum Fixed-point.  
De plus, un fichier .dot correspondant au flow est automatiquement créé.
