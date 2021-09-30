# TD 1
## Remarques préliminaires
* Pour l'ensemble des TDs, vous créerez un compte individuel sur [github](https://github.com/) si vous n'en possédez pas déjà un.
Vous nommerez ce compte de la façon suivante: `uvsq<MonNuméroÉtudiant>`.
Par exemple, pour un étudiant de numéro *21601234*, le compte sera `uvsq21601234`.
* Les commandes `git` sont à taper en ligne de commande dans un *shell*.
* Vous pouvez utiliser l'IDE de votre choix.
Sur le cartable numérique, [Eclipse](www.eclipse.org), [IntelliJ IDEA](http://www.jetbrains.com/idea/) et [Visual Studio Code](https://code.visualstudio.com/) sont installés.
* Vous répondrez aux questions directement dans ce fichier en complétant les emplacements correspondants.
Ajoutez ensuite ce fichier au dépôt `git`.

## Partie I (à faire durant le TD) : découverte de `git`
Dans cet exercice, vous créerez une classe `Fraction` représentant un nombre rationnel et une classe `Main` qui testera les méthodes de la classe `Fraction` **avec des assertions**.
À chaque étape, consultez le statut des fichiers du projet ainsi que l'historique.

1. Sur la forge, créez le dépôt (_repository_) `SimpleFraction`;
En terme de *commits*, quelle différence constatez-vous entre cocher une (ou plusieurs) des cases *Initialize this repository with* et n'en cocher aucune ?
    Le faite de cocher une ou plusieurs cases lors de la création du dépot créé un ou plusieurs commits par défaut.

    *Pour la suite, ne cochez aucune de ces cases*.
1. Localement, configurez `git` avec votre nom (`user.name`) et votre email (`user.email`);
    ```bash
    git config --global user.name "uvsq21804428"
    git config --global user.email mickael.temim@ens.uvsq.fr
    ```
1. Initialisez le dépôt `git` local pour le projet;
    ```bash
    git clone https://github.com/uvsq21804428/SimpleFraction.git
    ```
1. Créez la classe `Fraction` (vide pour le moment) et la classe `Main` (avec un simple affichage) dans le projet;
Vérifiez que le projet compile et s'exécute dans l'IDE;
Validez les changements;
    ```bash
    git add src/Main.java
    git add src/Fraction.java
    git commit -m "Ajout des fichiers java"
    ```
1. Ajoutez un constructeur et la méthode `toString` à la classe `Fraction` et modifiez la classe `Main` en conséquence;
Validez les changements;
    ```Java
    Fraction f = new Fraction(1, 2); //On créé une instance de la classe "Fraction"
    assert "1.0/2.0".equals(f.toString()) : "Erreur, la fraction ne s'affiche pas correctement !"; //On test la méthode "toString"
    ```
1. Publiez vos modifications sur le dépôt distant;
Vous utiliserez le protocole `https` pour cela;
Vérifiez avec le navigateur;
    ```bash
    git add src/Main.java
    git add src/Fraction.java
    git commit -m "message"
    git push origin master
    ```
1. Sur la forge, ajoutez un fichier de documentation `README.md`.
Quelle syntaxe est utilisée pour ce fichier ?
    L'extension .md
1. Récupérez localement les modifications effectuées sur la forge.
    ```bash
    git pull origin master
    ```
1. Ajoutez les répertoires et fichiers issus de la compilation aux fichiers ignorés par `git` (fichier `.gitignore`);
    ```bash
   *.class
    ```
1. Retirez les fichiers de configuration de l'IDE du projet;
    ```bash
    git rm .classpath .project .settings
    ```
    Ajoutez-les aux fichiers ignorés par `git`.
    ```bash
    *.class
    .classpath
    .project
    .settings
    ```
1. Configurez l'accès par clé publique/clé privée à la forge (cf. [Connecting to GitHub with SSH](https://docs.github.com/en/authentication/connecting-to-github-with-ssh)).
    -Pour configurer l'accès par clé publique/privée à la forge, il faut commencer par generer la paire clé publique/privée:
      sur la machine locale depuis laquelle on veut se connecter au serveur, il faut tapper cette commande:
        ssh-keygen -b 4096
      id_rsa est la clé privé, tandis que id_rsa.pub est la clé public

    -Il faut ensuite copier la clé publique sur le serveur, pour cela il faut taper la commande suivante:
        user@localmachine$ scp ~/.ssh/id_rsa.pub user@remotemachine:/home/user/uploaded_key.pub : on copie la clé sur le serveur distant
      si le dossier .ssh n'existe pas, il faut alors faire cette suite de commande:
        user@remotemachine$ mkdir .ssh -> on créé le dossier .ssh
        user@remotemachine$ chmod 700 .ssh -> on obtient les permissions du dossier
        user@remotemachine$ touch .ssh/authorized_keys -> on créé ce fichier dans le dossier .ssh
        user@remotemachine$ chmod 600 .ssh/authorized_keys -> on obtient les permissions du fichier créé
      Ensuite, il faut copier la clé et supprimer le fichier copié sur le serveur:
        user@remotemachine$ echo `cat ~/uploaded_key.pub` >> ~/.ssh/authorized_keys
        user@remotemachine$ rm /home/user/uploaded_key.pub

## Partie II (à faire à la maison) : révisions et perfectionnement *shell* et *IDE*
### Maîtriser le *shell* de commandes
L'objectif de cet exercice est de vous faire réviser/découvrir les commandes de base du *shell* de votre machine.
Vous pouvez répondre en utilisant le shell de votre choix (*bash*, *Powershell*, …).
Pour répondre à ces questions, vous devez effectuer les recherches documentaires adéquates (livre, web, …).

1. Quel OS et quel shell de commande utilisez-vous ?
    J'utilise Mac OSX, et j'utilise le terminal pré installé sur Mac.

1. Quelle commande permet d'obtenir de l'aide ?
Donnez un exemple.
    ```bash
    man ls
    ```
1. Donnez la ou les commandes shell permettant de
    1. afficher les fichiers d'un répertoire triés par taille (taille affichée lisiblement)
        ```bash
        ls -lhS
        ```
    1. compter le nombre de ligne d'un fichier
        ```bash
        wc -l fichier.txt
        ```
    1. afficher les lignes du fichier `Main.java` contenant la chaîne `uneVariable`
        ```bash
        grep uneVariable Main.java
        ```
    1. afficher récursivement les fichiers `.java` contenant la chaîne `uneVariable`
        ```bash
        grep -IR uneVariable *.java
        ```
    1. trouver les fichiers (pas les répertoires) nommés `README.md` dans une arborescence de répertoires
        ```bash
        find . -type f -name README.md
        ```
    1. afficher les différences entre deux fichiers textes
        ```bash
        diff file1.txt file2.txt
        ```
1. Expliquez en une ou deux phrases le rôle de ces commandes et dans quel contexte elles peuvent être utiles pour un développeur.
    * `ssh`
        La commande "ssh" permet de se connecter à distance sur un autre ordinateur de manière sécurisée, les developpeurs peuvent utiliser
        cette commabe pour échanger des données de manière sécurisée.

    * `screen`/`tmux`
        -La commande "screen" permet de lancer plusieurs terminaux en un seul terminal, elle permet également de partager ces terminaux
         avec d'autres développeurs. Ceci peut être intéréssant pour les travaux en groupe car cela permet de s'organiser plus facilement.
        -La commande "tmux" permet également de lancer plusieurs terminaux en même temps, elle permet également d'afficher ces deniers dans une seule fenêtre. 

    * `curl`/[HTTPie](https://httpie.org/)
        Cette commande permet de faire des requêtes à un serveur via des protocoles, grace à cette fonctionnalité, on peut tester
        des applications ou des logiciels via des diagnostics précis sur ces derniers. 

    * [jq](https://stedolan.github.io/jq/)
        Avec cette commande, on peut manipuler facilement des données JSON, cela permet d'extraire des données et de les reformer
        dans un format JSON.


### Découverte de votre *IDE*
Dans cet exercice, vous expliquerez en quelques phrases comment vous réalisez les actions ci-dessous dans votre IDE.
Vous pouvez choisir l'IDE/éditeur de texte de votre choix.
Pour réaliser cette exercice, vous devez bien évidemment vous reporter à la documentations de l'IDE ([IntelliJ IDEA](https://www.jetbrains.com/help/idea/discover-intellij-idea.html#developer-tools), [Visual Studio Code](https://code.visualstudio.com/docs), [Eclipse](https://help.eclipse.org/2020-09/index.jsp), …).

1. Quels IDE ou éditeurs de texte utilisez-vous pour le développement Java ?
    J'utilise Visual Studio Code lorsque je travaille sur mon ordinateur fixe, ou Eclipse lorsque je travaille sur mon ordinateur portable.
    J'utiliserai Eclipse pour la suite de ce TD.

    Pour la suite, ne considérez que l'un de vos choix.
1. Comment vérifier/définir que l'encodage utilisé est *UTF-8* ?
    Pour cela, il faut aller dans les "Préférences", ensuite il suffit d'aller dans le "Workspace" puis dans le "text file encoding".
    Nous pouvons ensuite séléctionner le type d'encodage par défaut.

1. Comment choisir le JDK à utiliser dans un projet ?
    Pour cela, il faut aller dans les "Préférences" puis dans "Installed JREs", de là, on séléctionne le jdk que l'on souhaite utiliser.

1. Comment préciser la version Java des sources dans un projet ?
    Pour cela, il faut cocher la case "Utiliser une compatibilité propre au projet" lors de la création d'un projet java, puis de séléctionner
    la version voulue dans la liste déroulante.

1. Comment ajouter une bibliothèque externe dans un projet ?
    Pour ajouter une bibliothèque externe dans un projet Eclipse, il faut aller dans "mon projet > propriétés > java build path", on a plus qu'à sélectionner la bibliothèque java que l'on souhaite importer au projet.

1. Comment reformater un fichier source Java ?
    Pour ceci, il suffit de faire la combinaison "commande + Maj + f" sur le clavier du Mac.

1. Comment trouver la déclaration d'une variable ou méthode ?
    Lorsqu'on double clique sur le nom de la variable ou de la méthode en question, tous les endroits du code où apparaissent le nom de la variable ou de la méthode en question seront surlignés, on peut donc facilement retrouver la déclaration de la variable ou de la méthode sélectionnée.

1. Comment insérer un bloc de code prédéfini (*snippet*) ?
    pour un insérer un bloc de code prédéfini il suffit de faire la combinaison "commande + espace" sur le clavier du mac apres avoir ecrit la structure voulue.
    exemple: on écrit "for" dans le fichier source, puis on fait "commande + espace" pour que la structure du bloc for soit automatiquement inscrite sur le fichier source.
    Ceci est très pratique pour la création d'une classe ou d'une interface par exemple.

1. Comment renommer une classe dans l'ensemble du projet ?
    Pour renommer une classe dans l'ensemble du projet sur Eclipse, il faut faire un clique droit sur le fichier de la classe puis sélectionner "refractor" puis "Rename" puis rentrer le nom de la classe voulue.

1. Comment exécuter le programme en lui passant un paramètre en ligne de commande ?
    Une fois que le projet est compilé, on peut écrire en ligne de commande " java 'nom du fichier qui contient le main' 'liste des paramètres' ".
    exemple: "java Main Hello World", dans ce cas args[0]=Hello et args[1]=World.

1. Comment déboguer le programme en visualisant le contenu d'une ou plusieurs variables ?
      On commence par mettre un point d'arrêt à l'endroit voulu en faisant un double clique gauche sur la partie gauche de la ligne choisie.
      Ensuite on appuie sur le bouton de déboguage. On peut utiliser l'option "step over" pour pouvoir lire ligne par ligne le contenue de la variable souhaité et analyser son comportement au sein du programme, le contenue des variables sont situés sur en haut à gauche de la fenêtre.

1. Quels paramètres ou fonctionnalités vous semblent particulièrement importants/utiles pour le développement Java ?
    j'utilise Eclipse car il y a beaucoup d'options pratiques. La création d'un projet automatique sur Eclipse est très importante pour moi car elle me permet de gagner du temps, effectivement le dossier src est automatiquement créé tout comme le dossier qui contiendra les fichier .class.
    De même lorsque l'on créé une classe sur Eclipse, le corps du fichier source est créer automatiquement, de même pour les constructeurs, les getteurs ainsi que les setteurs. Les packages sont organiser automatiquement selon la demande de l'utilisateur, ce qui est très pratique pour ne pas générer des erreurs lors de l'ajout du mot clé "package" dans l'intégralités des fichiers sources.
    La fonction très simple du debogueur fourni avec Eclipse est très pratique.
    Tous ces paramètres permettent de gagner beaucoup de temps, et servent aussi à faire moins d'erreurs, ces deux notions sont très utilies pour développer en Java.