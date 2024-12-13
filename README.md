
## Doc KATA F B Q

### Backend 

#### Prérequis
- Java JDK 17 ou supérieur
- Maven
- IntelliJ IDEA

#### Méthode 1 : Exécution via IDE
1. Ouvrez le projet dans votre IDE
2. Localisez la classe principale de l'application (généralement annotée avec `@SpringBootApplication`)
3. Cliquez sur le bouton "Run" ou "Play" à côté de la classe principale

#### Méthode 2 : Exécution via Maven
1. Ouvrez un terminal
2. Naviguez jusqu'au répertoire racine du projet backend
3. Exécutez la commande :
```bash
mvn spring-boot:run
```


#### Configuration du Port
- Par défaut, Spring Boot utilise le port 8080


### Frontend 

#### Prérequis
- Node.js (version 14 ou supérieure)
- npm (Node Package Manager)

#### Installation des Dépendances
1. Naviguez jusqu'au répertoire frontend
```bash
cd kata-frontend
```
2. Installez les dépendances
```bash
npm install
```

#### Exécution en Mode Développement
```bash
npm start
```
- L'application démarrera généralement sur http://localhost:4200



### Démarrage Complet de l'Application
1. Démarrez le backend (Spring Boot)

3. Ouvrez votre navigateur à l'adresse http://localhost:4200

