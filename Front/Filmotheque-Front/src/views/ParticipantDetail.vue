<script setup>
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router';
import axios from 'axios'

const URL_PARTICIPANTS = 'http://localhost:8080/api/participants/'
const URL_FILMS = 'http://localhost:8080/api/films'

const participant = ref([])
const listeFilms = ref([])

async function init() {
    // PARTICIPANT BY ID
    const route = useRoute();
    const reponseParticipants = await axios.get(`${URL_PARTICIPANTS}${route.params.id}`);
    participant.value = reponseParticipants.data;

    // FILMS WHERE ACTEURS.id = PARTCIPANT ID
    // const reponseFilm = await axios.get(URL_FILMS);
    // reponseFilm.data.forEach(e => {
    //     if (e.acteurs.id === participant.id) {
    //         listeFilms.value = reponseFilm.data;
    //     }
    // });
}

onMounted(() => {
    init();
})
</script>

<template>
    <div class="d-flex mb-3">
        <div class="col-3">
            <div class="card" style="width: 18rem;">
                <img :src="'/images/participants/' + participant.photo" :alt="participant.prenom + ' ' + participant.nom"
                    class="card-img img-fluid">
            </div>
        </div>
        <div class="col-9">
            <h2>{{ participant.prenom + ' ' + participant.nom }}</h2>
            <ul>
                <li>Métiers :
                    <span v-if="participant.acteur" class="badge bg-primary" style="margin-right: 0.3rem;">Acteur</span>
                    <span v-if="participant.realisateur" class="badge bg-success">Réalisateur</span>
                </li>
                <li>Date de naissance :
                    <span class="badge bg-danger">{{ participant.naissance }}</span>
                </li>
                <li>Biographie :
                    <p>{{ participant.biographie }}</p>
                </li>
            </ul>
        </div>
    </div>
    <hr>
    <!-- <div class="d-flex">
        <div class="row col-12">
            <h2 class="mb-3">Filmothèque</h2>
            <template v-for="film in listeFilms" :key="film.id">
                <div class="col-2">
                    <RouterLink :to="'/films/' + film.id" class="text-decoration-none">
                        <div class="card">
                            <img :src="'/images/films/' + film.affiche" class="card-img-top border-bottom"
                                :alt="film.titre">
                            <div class="card-body bg-warning text-center rounded-bottom">
                                <p class=" card-title title">{{ film.titre }}</p>
                            </div>
                        </div>
                    </RouterLink>
                </div>
            </template>
        </div>
    </div> -->
</template>