<script setup>
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router';
import axios from 'axios'

const URL = 'http://localhost:8080/api/films/'

const film = ref([])

async function init() {
    const route = useRoute();
    const reponse = await axios.get(`${URL}${route.params.id}`);
    film.value = reponse.data;
}

onMounted(() => {
    init();
})
</script>

<template>
    <div class="d-flex mb-5">
        <div class="col-3">
            <div class="card" style="width: 18rem;">
                <div class="card-body bg-primary-subtle text-center">
                    <h5 class="card-title">{{ film.titre }}</h5>
                </div>
                <img :src="'/images/films/' + film.affiche" class="card-img-top border-bottom" :alt="film.titre">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                        Genre :
                        <template v-for="genre in film.genre">
                            <span class="badge bg-secondary">{{ genre.libelle }}</span>
                        </template>
                    </li>
                    <li class="list-group-item">Date de sortie : <span class="badge bg-danger">{{ film.sortie }}</span></li>
                    <li class="list-group-item">Durée : <span class="badge bg-dark">{{ film.duree }}</span></li>
                </ul>
                <!-- <div class="card-body">
                                                                    <a href="#" class="card-link">Card link</a>
                                                                    <a href="#" class="card-link">Another link</a>
                                                                </div> -->
            </div>
        </div>
        <div class="col-9">
            <div class="col-8">
                <h3>Synopsis</h3>
                <p>{{ film.synopsis }}</p>
            </div>
            <hr>
            <div class="distribution col-12 mt-4">
                <h2 class="mt-2 mb-3">Distribution</h2>
                <!-- todo Real-->
                <div class="accordion" id="accordion-realisateur-liste">
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="accordion-realisateur-headingOne">
                            <button class="accordion-button" type="button" data-bs-toggle="collapse"
                                data-bs-target="#accordion-realisateur-collapseOne" aria-expanded="true"
                                aria-controls="accordion-realisateur-collapseOne">
                                Réalisateur
                            </button>
                        </h2>
                        <div id="accordion-realisateur-collapseOne" class="accordion-collapse collapse show"
                            aria-labelledby="accordion-realisateur-headingOne">
                            <div class="accordion-body">
                                <div class="col-2 mb-4">
                                    <template v-if="film.realisateur">
                                        <RouterLink :to="'/participants/' + film.realisateur.id"
                                            class="text-decoration-none">
                                            <div class="card rounded">
                                                <img :src="'/images/participants/' + film.realisateur.photo"
                                                    :alt="film.realisateur.prenom + ' ' + film.realisateur.nom"
                                                    class="card-img rounded-0 img-fluid">
                                                <div class="card-body text-center ">
                                                    <p class="card-title ">{{ film.realisateur.prenom + ' ' +
                                                        film.realisateur.nom }}</p>
                                                </div>
                                            </div>
                                        </RouterLink>
                                    </template>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <hr>

                <div class="accordion" id="accordion-acteur-liste">
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="accordeon-acteur">
                            <button class="accordion-button" type="button" data-bs-toggle="collapse"
                                data-bs-target="#accordeon-acteur-collapseOne" aria-expanded="true"
                                aria-controls="accordeon-acteur-collapseOne">
                                Acteurs
                            </button>
                        </h2>
                        <div id="accordeon-acteur-collapseOne" class="accordion-collapse collapse show"
                            aria-labelledby="accordeon-acteur">
                            <div class="accordion-body">
                                <div class="row col-12">
                                    <template v-for="participant in film.acteurs">
                                        <div class="col-2 mb-4">
                                            <RouterLink :to="'/participants/' + participant.id"
                                                class="text-decoration-none">
                                                <div class="card rounded">
                                                    <img :src="'/images/participants/' + participant.photo"
                                                        :alt="participant.prenom + ' ' + participant.nom"
                                                        class="card-img rounded-0 img-fluid">
                                                    <div class="card-body text-center ">
                                                        <p class="card-title ">{{ participant.prenom + ' ' + participant.nom
                                                        }}</p>
                                                    </div>
                                                </div>
                                            </RouterLink>
                                        </div>
                                    </template>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
