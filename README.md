# 🏥 Cabinet Médical — API REST

> Projet **Applications Réparties** réalisé avec **Spring Boot**, **Maven**, **Spring Data JPA** et la base de données **H2** en mémoire.

Cette application expose une API REST pour gérer un cabinet médical avec ses **médecins**, ses **patients** et leurs **rendez-vous**.

---

## 👥 Membres du groupe

- [Feki Ali]
- [Feki Youssef]
- [Elloumi Mahdi]

---

## 📋 Pré-requis (à installer une seule fois)

Avant de commencer, assurez-vous d'avoir installé sur votre PC :

| Outil | Version | Lien |
|---|---|---|
| **JDK** | 17 ou plus | [Télécharger Oracle JDK](https://www.oracle.com/java/technologies/downloads/) |
| **IntelliJ IDEA** | Community ou Ultimate | [Télécharger IntelliJ](https://www.jetbrains.com/idea/download/) |
| **Git** | dernière version | [Télécharger Git](https://git-scm.com/downloads) |
| **Postman** *(optionnel)* | dernière version | [Télécharger Postman](https://www.postman.com/downloads/) |

> 💡 **Note** : Maven n'est PAS nécessaire à installer séparément, le projet inclut le **Maven Wrapper** (`mvnw`).

---

## 🚀 Comment récupérer et lancer le projet

### Étape 1 : Cloner le repository

Ouvrez un terminal (PowerShell, CMD ou Git Bash) dans le dossier de votre choix, puis exécutez :

```bash
git clone https://github.com/alifeki21/cabinetMedecin.git
```

Cela crée un dossier `cabinetMedecin` contenant tout le projet.

### Étape 2 : Ouvrir le projet dans IntelliJ IDEA

1. Lancez **IntelliJ IDEA**
2. Cliquez sur **File → Open** (ou **Open** sur l'écran d'accueil)
3. Naviguez jusqu'au dossier `cabinetMedecin` que vous venez de cloner
4. Sélectionnez ce dossier et cliquez sur **OK**
5. IntelliJ détectera automatiquement le `pom.xml`. Cliquez sur **"Load Maven Project"** ou **"Trust Project"** si une popup apparaît
6. **Patientez 1 à 3 minutes** : IntelliJ télécharge toutes les dépendances Maven (Spring Boot, JPA, H2...). Vous verrez une barre de progression en bas

### Étape 3 : Vérifier la configuration du JDK

1. Allez dans **File → Project Structure** (ou `Ctrl+Alt+Shift+S`)
2. Dans **Project**, vérifiez que le **SDK** est bien sur **Java 17** (ou plus récent)
3. Si ce n'est pas le cas, sélectionnez le bon JDK puis cliquez sur **Apply** et **OK**

### Étape 4 : Lancer l'application

1. Dans le panneau de gauche, ouvrez : `src/main/java/gl2/example/cabinet/CabinetApplication.java`
2. Cliquez sur le **petit triangle vert ▶️** à côté de la méthode `main`
3. Sélectionnez **Run 'CabinetApplication.main()'**
4. Attendez quelques secondes... vous devriez voir dans la console :

```
=========================================
  Cabinet Medical demarre sur port 8080
  Console H2 : http://localhost:8080/h2-console
=========================================
```

✅ **L'application est lancée et prête à recevoir des requêtes !**

---

## 🔧 Méthode alternative : ligne de commande

Si vous préférez ne pas utiliser IntelliJ, vous pouvez lancer le projet directement depuis le terminal :

**Sur Windows (PowerShell ou CMD) :**
```bash
cd cabinetMedecin
.\mvnw.cmd spring-boot:run
```

**Sur Linux / macOS :**
```bash
cd cabinetMedecin
./mvnw spring-boot:run
```

---

## 🧪 Tester l'API

Une fois l'application lancée, vous pouvez tester les endpoints de **3 manières** :

### Méthode 1 — Navigateur (uniquement pour les requêtes GET)

Ouvrez votre navigateur et tapez :
```
http://localhost:8080/api/medecins
http://localhost:8080/api/patients
http://localhost:8080/api/rendezvous
```

### Méthode 2 — Postman (recommandé)

Voir les exemples de requêtes plus bas.

### Méthode 3 — curl en ligne de commande

Exemple pour ajouter un médecin :
```bash
curl -X POST http://localhost:8080/api/medecins ^
  -H "Content-Type: application/json" ^
  -d "{\"nom\":\"Ben Ali\",\"prenom\":\"Ahmed\",\"specialite\":\"Cardiologue\",\"telephone\":\"71234567\"}"
```

---

## 🗄️ Console H2 (visualiser la base de données)

Pour voir les données en direct dans la base :

1. Ouvrez votre navigateur sur : **http://localhost:8080/h2-console**
2. Configurez la connexion :
   - **JDBC URL** : `jdbc:h2:mem:cabinetdb`
   - **User Name** : `sa`
   - **Password** : `password`
3. Cliquez sur **Connect**

Vous verrez les tables `MEDECIN`, `PATIENT` et `RENDEZ_VOUS` avec toutes les données ajoutées.

> ⚠️ La base est **en mémoire** : toutes les données disparaissent quand vous arrêtez l'application.

---

## 📋 Liste des Endpoints

### 👨‍⚕️ Médecins
| Méthode | URL | Description |
|---|---|---|
| GET | `/api/medecins` | Liste tous les médecins |
| GET | `/api/medecins/{id}` | Détails d'un médecin |
| GET | `/api/medecins/specialite/{spec}` | Filtre par spécialité |
| POST | `/api/medecins` | Ajouter un médecin |
| PUT | `/api/medecins/{id}` | Modifier un médecin |
| DELETE | `/api/medecins/{id}` | Supprimer un médecin |

### 🧑 Patients
| Méthode | URL | Description |
|---|---|---|
| GET | `/api/patients` | Liste tous les patients |
| GET | `/api/patients/{id}` | Détails d'un patient |
| POST | `/api/patients` | Inscrire un patient |
| PUT | `/api/patients/{id}` | Modifier un patient |
| DELETE | `/api/patients/{id}` | Supprimer un patient |

### 📅 Rendez-vous
| Méthode | URL | Description |
|---|---|---|
| GET | `/api/rendezvous` | Tous les rendez-vous |
| GET | `/api/rendezvous/medecin/{id}` | Agenda d'un médecin |
| GET | `/api/rendezvous/patient/{id}` | Historique d'un patient |
| POST | `/api/rendezvous?medecinId=X&patientId=Y` | Planifier un RDV |
| PUT | `/api/rendezvous/{id}/annuler` | Annuler un RDV |
| DELETE | `/api/rendezvous/{id}` | Supprimer un RDV |

---

## 📝 Exemples de requêtes JSON (pour Postman)

**POST `/api/medecins`**
```json
{
  "nom": "Ben Ali",
  "prenom": "Ahmed",
  "specialite": "Cardiologue",
  "telephone": "71234567"
}
```

**POST `/api/patients`**
```json
{
  "nom": "Sassi",
  "prenom": "Sami",
  "dateNaissance": "1995-03-12",
  "telephone": "98765432",
  "email": "sami@mail.com"
}
```

**POST `/api/rendezvous?medecinId=1&patientId=1`**
```json
{
  "dateHeure": "2026-05-20 10:30",
  "motif": "Consultation cardiologique"
}
```

---

## 🏗️ Architecture du projet

```
cabinetMedecin/
├── pom.xml
├── mvnw / mvnw.cmd          (Maven Wrapper)
└── src/main/
    ├── java/gl2/example/cabinet/
    │   ├── CabinetApplication.java   ← classe principale
    │   ├── model/                    ← entités JPA
    │   │   ├── Medecin.java
    │   │   ├── Patient.java
    │   │   └── RendezVous.java
    │   ├── repository/               ← accès aux données
    │   │   ├── MedecinRepository.java
    │   │   ├── PatientRepository.java
    │   │   └── RendezVousRepository.java
    │   ├── service/                  ← logique métier
    │   │   ├── MedecinService.java
    │   │   ├── PatientService.java
    │   │   └── RendezVousService.java
    │   └── controller/               ← endpoints REST
    │       ├── MedecinController.java
    │       ├── PatientController.java
    │       └── RendezVousController.java
    └── resources/
        └── application.properties    ← config H2
```

---

## ❓ Problèmes fréquents

### "Port 8080 already in use"
Une autre application utilise déjà le port 8080. Solutions :
- Fermez l'autre application
- OU modifiez le port dans `src/main/resources/application.properties` en ajoutant : `server.port=8081`

### "Java version not supported"
Votre JDK est trop ancien. Installez le **JDK 17** minimum et reconfigurez-le dans IntelliJ (File → Project Structure).

### Les dépendances Maven ne se téléchargent pas
- Vérifiez votre connexion internet
- Faites un clic droit sur `pom.xml` → **Maven → Reload Project**

### Erreur "cannot find symbol" dans le code
Faites : **File → Invalidate Caches → Invalidate and Restart**

---

## 🛠️ Technologies utilisées

- **Java 17**
- **Spring Boot 3.3.4**
- **Spring Web** (pour les endpoints REST)
- **Spring Data JPA** (pour la persistance)
- **H2 Database** (base en mémoire)
- **Maven** (gestion des dépendances)

