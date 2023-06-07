<h1>Q-learning</h1>
L'algorithme du Q-learning est une méthode d'apprentissage par renforcement qui permet à un agent d'apprendre à prendre des décisions dans un environnement dynamique. Voici un résumé des principales étapes de l'algorithme Q-learning :

Initialisation : L'algorithme commence par initialiser une table de valeurs appelée la table Q, qui représente les actions possibles dans chaque état de l'environnement. Cette table est généralement initialisée avec des valeurs aléatoires ou à zéro.

Choix de l'action : L'agent choisit une action à prendre dans l'état actuel de l'environnement en utilisant une politique d'exploration/exploitation. Au début, l'agent peut privilégier l'exploration pour découvrir de nouvelles actions, puis il peut progressivement passer à une exploitation plus importante pour tirer parti des actions les plus prometteuses.

Exécution de l'action et observation de la récompense : L'agent exécute l'action choisie et observe la récompense obtenue ainsi que le nouvel état de l'environnement.

Mise à jour de la table Q : L'agent met à jour la valeur Q de l'état-action courant en utilisant la formule de mise à jour du Q-learning. Cette formule est basée sur la récompense obtenue, la valeur Q de l'état suivant et les paramètres d'apprentissage tels que le taux d'apprentissage et le facteur de remise.


![image](https://github.com/oussemou-mohamed/Qleurning_sequentiel-multi_agent/assets/123418439/b275661e-3d0e-473b-9803-450a96702ac3)
![image](https://github.com/oussemou-mohamed/Qleurning_sequentiel-multi_agent/assets/123418439/4a99dd89-5bf1-4027-8a04-cf947d61652f)


Répétition : Les étapes 2 à 4 sont répétées jusqu'à ce que l'agent atteigne un critère d'arrêt prédéfini, tel qu'un nombre fixe d'itérations ou une convergence des valeurs Q.

Exploitation : Une fois que l'apprentissage est terminé, l'agent peut utiliser la table Q mise à jour pour choisir les meilleures actions dans chaque état, en suivant simplement les valeurs Q maximales.

L'algorithme du Q-learning est un processus itératif qui permet à l'agent d'apprendre par essais et erreurs à partir des interactions avec l'environnement. Il peut être utilisé pour résoudre des problèmes d'apprentissage par renforcement tels que les jeux, la robotique, la planification de trajectoires, etc.
<h1>L'implémentation de cas Séquentiel:</h1>

https://github.com/oussemou-mohamed/Qleurning_sequentiel-multi_agent/assets/123418439/a3331c6e-96d4-49d3-97c4-ede6185b1e63
<h1>Cas multi agents:</h1>
On va démarrer plusieurs agents qui vont exécuter l'algorithme, et ils vont donner leur meilleur résultat au maître du jeu.
![1_EtWIjfFjiyHkS12sCZAGrA (1)](https://github.com/oussemou-mohamed/Qleurning_sequentiel-multi_agent/assets/123418439/95238c74-6bff-4cc0-bfb5-33e5d771caaa)


<h1>L'implémentation de cas multi agents:</h1>


https://github.com/oussemou-mohamed/Qleurning_sequentiel-multi_agent/assets/123418439/5d2de030-f317-46c2-99c1-927c781ab26b





