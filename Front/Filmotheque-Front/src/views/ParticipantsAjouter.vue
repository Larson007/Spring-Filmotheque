<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'
const URL = 'http://localhost:8080/api/participants'



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
const prenom = ref('')
const nom = ref('')
const acteur = ref('')
const realisateur = ref('')
const naissance = ref('')
const biographie = ref('')
// 2 - la liste des personnes (valeur par défaut : liste vide)
const listeParticipants = ref([])
var photo = ref('');



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
    const listeParticipantsFormatJson = response.data;

    // 3 - on met à jour la valeur de notre modèle avec cette liste de tache au format JSON
    // => le HTML de notre template va automatiquement se mettre à jour
    listeParticipants.value = listeParticipantsFormatJson;
}


function onFileChange(e) {
    var files = e.target.files || e.dataTransfer.files;
    photo = files[0].name
}
/*
* Fonction asynchrone creerTache() qui 
 - recupère la valeur saisie par l'utilisateur dans le champs de saisie HTML
 - effectue une requête POST sur l'API 
 - recharge les personnes avec une autre requête HTPP (déjà codé dans fonction init())
*/
async function creerParticipant() {

    // 1 - on recupère la valeur du champs de saisi avec description.value
    // car on a lmis v-model="description" sur notre champs de saisi
if (photo.value === null || photo.value === '') {
    photo = 'placeholder.webp'
}

    const body = {
        prenom: prenom.value, // c'est ici qu'on renseigne la valeur de l'utilisateur
        nom: nom.value,
        acteur: acteur.value,
        realisateur: realisateur.value,
        photo:photo,
        naissance: naissance.value,
        biographie: biographie.value
    }

    console.log({ body });
    // 2 - on lance la requête
    await axios.post(URL, body);

    // 3 on recharge les personnes + on met à jour le HTML
    // on vide le champs de saisi après la création 
    prenom.value = nom.value = acteur.value = realisateur.value = naissance.value = biographie.value = '';
    photo = '';
    init();
}

/*
* Fonction asynchrone supprimerPersonne() qui 
 - effectue une requête DELETE sur l'API avec l'id passé en paramètre
 - recharge les taches avec une autre requête HTPP (déjà codé dans fonction init())
*/
async function supprimerParticipant(idASupprimer) {
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
    <h2 class="mt-2 mb-5">Gestion des participants</h2>

    <div class="border rounded bg-light p-3 d-flex justify-content-between ">
        <div class="col-6">
            <div class="mb-3">
                <label for="prenom" class="form-label">Prénom</label>
                <input type="text" class="form-control" id="prenom" v-model="prenom" >
            </div>
            <div class="mb-3">
                <label for="nom" class="form-label">Nom</label>
                <input type="text" class="form-control" id="nom" v-model="nom">
            </div>
            <div class="mb-3">
                <label for="naissance" class="form-label">Date de naissance</label>
                <input type="date" class="form-control" id="naissance" v-model="naissance">
            </div>
            <div class="mb-3">
                <label for="biographie" class="form-label">Biographie</label>
                <textarea class="form-control" name="biographie" id="biographie" rows="5" v-model="biographie"></textarea>

            </div>
        </div>
        <div class="col-5 position-relative">
            <div class="border rounded p-2 partcipants-roles">
                <p class="form-label">Rôles</p>
                <div class="mb-3 form-check">
                    <label for="isActeur" class="form-label">Acteur</label>
                    <input type="checkbox" class="form-check-input" id="isActeur" v-model="acteur">
                </div>
                <div class="mb-3 form-check">
                    <label for="isRealisateur" class="form-label">Réalisateur</label>
                    <input type="checkbox" class="form-check-input" id="isRealisateur" v-model="realisateur">
                </div>
            </div>
            <div class="my-3">
                <label class="formFile" for="photo">Photo</label>
                <input class="form-control" type="file" name="photo" id="photo" v-on:change="onFileChange">
            </div>
            <div class="mt-5">
                <button class="btn btn-success position-absolute bottom-0 end-0"
                    @click="creerParticipant()">Valider</button>
            </div>
        </div>
    </div>
    <div class="mt-5">
        <h3 class="mb-3">Liste des participants</h3>
        <table class="table table-striped mb-5">
            <thead>
                <tr class="table-primary">
                    <th scope="col">Nom</th>
                    <th scope="col">Rôles</th>
                    <th scope="col">Détail</th>
                    <th scope="col" class="text-center">Supprimer</th>

                </tr>
            </thead>
            <tbody class="table-group-divider">
                <tr v-for="participant in listeParticipants">
                    <td scope="row">{{ participant.prenom }} {{ participant.nom }}</td>
                    <td>
                        <span class="badge text-bg-primary" style="margin-right: 0.3rem;"
                            v-if="participant.acteur === true">Acteur</span>
                        <span class="badge text-bg-success" v-if="participant.realisateur === true">Réalisateur</span>
                    </td>
                    <td class="text-center">
                        <RouterLink :to="'/participants/' + participant.id"><i class="fa-solid fa-magnifying-glass"
                                style="color: #16a2c5; font-size: 1.3rem;"></i></RouterLink>
                    </td>
                <td class="text-center"><button @click='supprimerParticipant(participant.id)'
                        class="btn btn-danger badge">X</button></td>
            </tr>
        </tbody>
    </table>
</div></template>