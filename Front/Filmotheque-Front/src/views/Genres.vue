<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'
const URL = 'http://localhost:8080/api/genres'



/********************* MODEL (variables reactives) ************
on crée des variables disponibles dans notre model Vue en affectant une valeur avec ref()
les variables du model sont accessibles dans le template avec {{nom_variable}}
les valeurs des variables du model sont accessibles en javascript avec nom_variable.value
pour la gestion personnes, on a besoin de partager :
- le prenom 
- le nom
- le statut
- la liste des personnes
**/

// 1 - prenom/nom/statut de la tâche remplie par le champs de saisi utilisateur (valeur par défaut : '')
const libelle = ref('')
const listeGenres = ref([])



/***************** autres METHODES (accessible dans le Javascript ou avec @click dabs le template) ************************/
/*
* Fonction asynchrone init() qui va chercher la liste des tâches en effectua,nt une requête d'API
*/
async function init() {
    // on utilise axios pour effectuer notre requête GET d'api
    // 1 - on récupère la réponse de la requête HTTP GET sur http://localhost:8080/api/personnes
    // await : attend que la fonction asyncrone (ici : fetch()) ait terminé avant de récupérer la réponse
    const response = await axios.get(URL);

    // 2 - on récupère les données (listeTaches) de la réponse au format JSON
    const listeGenresFormatJson = response.data;

    // 3 - on met à jour la valeur de notre modèle avec cette liste de tache au format JSON
    // => le HTML de notre template va automatiquement se mettre à jour
    listeGenres.value = listeGenresFormatJson;
}

/*
* Fonction asynchrone creerTache() qui 
 - recupère la valeur saisie par l'utilisateur dans le champs de saisie HTML
 - effectue une requête POST sur l'API 
 - recharge les personnes avec une autre requête HTPP (déjà codé dans fonction init())
*/
async function creerGenre() {

    // 1 - on recupère la valeur du champs de saisi avec description.value
    // car on a lmis v-model="description" sur notre champs de saisi
    const body = {
        libelle: libelle.value // c'est ici qu'on renseigne la valeur de l'utilisateur
    }

    // 2 - on lance la requête
    await axios.post(URL, body);

    // 3 on recharge les personnes + on met à jour le HTML
    // on vide le champs de saisi après la création 
    libelle.value = '';
    init();
}

/*
* Fonction asynchrone supprimerPersonne() qui 
 - effectue une requête DELETE sur l'API avec l'id passé en paramètre
 - recharge les taches avec une autre requête HTPP (déjà codé dans fonction init())
*/
async function supprimerGenre(idASupprimer) {
    // on utilise l'utl de l'API avec comme suffice l'id à supprimer
    await axios.delete(URL + '/' + idASupprimer);

    // on recharge les personnes + on met à jour le HTML
    init();
}


/*
* onMounted
* méthode speciale qui est appelée lorsque je charge mon composant
*/
onMounted(() => {
    console.log('onMounted : je vais appeler la méthode init()')
    init();
})
</script>

<template>
    <h2 class="mt-2 mb-5">Gestion des Genres</h2>

    <div class="border rounded bg-light p-3">
        <div class="col-6">
            <div class="mb-3">
                <label for="libelle" class="form-label">Libelle</label>
                <input type="text" class="form-control" id="libelle" v-model="libelle">
            </div>
            <div class="mb-3">
                <button class="btn btn-success" @click="creerGenre()">Valider</button>
            </div>
        </div>
    </div>
    <div class="mt-5">
        <h3 class="mb-3">Liste des genres</h3>
        <table class="table table-striped mb-5">
            <thead>
                <tr class="table-primary">
                    <th scope="col">Genre</th>
                    <th scope="col" class="text-center">Supprimer</th>

                </tr>
            </thead>
            <tbody class="table-group-divider">
                <tr v-for="genre in listeGenres">
                    <td scope="row">{{ genre.libelle }}</td>
                    <td class="text-center"><button @click='supprimerGenre(genre.id)' class="btn btn-danger badge">X</button></td>
                </tr>
            </tbody>
        </table>
    </div>
</template>