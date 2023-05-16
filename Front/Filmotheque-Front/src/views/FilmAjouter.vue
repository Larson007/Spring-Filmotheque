<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'
const URL_FILMS = 'http://localhost:8080/api/films'
const URL_GENRES = 'http://localhost:8080/api/genres'
const URL_PARTICIPANTS = 'http://localhost:8080/api/participants'


const titre = ref('')
const sortie = ref('')
const duree = ref('')
const synopsis = ref('')
const realisateur = ref('')
const acteurs = ref([])
const genre = ref([])

const listeFilms = ref([])
const listeGenres = ref([])
const listeParticipants = ref([])
var affiche = ref('');



async function init() {

    // FILMS
    const responseFillms = await axios.get(URL_FILMS);
    const listeFilmsFormatJson = responseFillms.data;
    listeFilms.value = listeFilmsFormatJson;

    // GENRES
    const responseGenres = await axios.get(URL_GENRES);
    const listeGenresFormatJson = responseGenres.data;
    listeGenres.value = listeGenresFormatJson;

    // PARTICIPANTS
    const responseParticipants = await axios.get(URL_PARTICIPANTS);
    const listeParticipantsFormatJson = responseParticipants.data;
    listeParticipants.value = listeParticipantsFormatJson;
}

function onFileChange(e) {
    var files = e.target.files || e.dataTransfer.files;
    affiche = files[0].name
}


async function creerFilm() {

    if (affiche.value === null || affiche.value === '') {
        affiche = 'placeholder.webp'
    }

    const body = {
        titre: titre.value,
        synopsis: synopsis.value,
        sortie: sortie.value,
        duree: duree.value + ':00',
        realisateur: realisateur.value,
        acteurs: acteurs.value,
        genre: genre.value,
        affiche: affiche
    }

    console.log({ body });


    await axios.post(URL_FILMS, body);

    titre.value = synopsis.value = sortie.value = duree.value = realisateur.value =  affiche = '';
    acteurs.value = genre.value = [];
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
        <h2 class="mt-2 mb-5">Nouveau film</h2>

        <div class="border rounded bg-light p-3 d-flex justify-content-between">
            <div class="col-6">
                <div class="mb-3">
                    <label for="titre" class="form-label">Titre</label>
                    <input type="text" class="form-control" id="titre" v-model="titre">
                </div>
                <div class="mb-3">
                    <label for="sortie" class="form-label">Date de sortie</label>
                    <input type="date" class="form-control" id="sortie" v-model="sortie">
                </div>
                <div class="mb-3">
                    <label for="duree" class="form-label">Durée</label>
                    <input type="time" class="form-control" id="duree" v-model="duree">
                </div>
                <div class="mb-3">
                    <label for="synopsis" class="form-label">Synopsis</label>
                    <textarea class="form-control" name="synopsis" id="synopsis" rows="5" v-model="synopsis"></textarea>
                </div>
            </div>
            <div class="col-5 position-relative">
                <div class="mb-3">
                    <label for="genre" class="form-label">Genre</label>
                    <select class="form-control" multiple v-model="genre" id="genre">
                        <option v-for="(genre, index) in listeGenres" :key="index" :value="genre">{{ genre.libelle }}
                        </option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="realisateur" class="form-label">Réalisateur</label>
                    <select class="form-control" v-model="realisateur" id="realisateur">
                        <template v-for="real in listeParticipants">
                            <option :value="real" v-if="real.realisateur === true">{{ real.prenom }} {{ real.nom }}</option>
                        </template>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="acteurs" class="form-label">Acteurs</label>
                    <select class="form-control" v-model="acteurs" multiple id="acteurs">
                        <template v-for="acteurs in listeParticipants" v-bind:key="acteurs.id">
                            <option :value="acteurs" v-if="acteurs.acteur === true">{{
                                acteurs.prenom }} {{ acteurs.nom }}</option>
                        </template>
                    </select>
                </div>
                <div class="mb-3">
                    <label class="formFile" for="affiche">Affiche</label>
                    <input class="form-control" type="file" name="affiche" id="affiche" v-on:change="onFileChange">
                </div>
                <div class="mb-3">
                    <button class="btn btn-success position-absolute bottom-0 end-0" @click="creerFilm()">Valider</button>
                </div>
            </div>
        </div>
</template>