<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'
const URL = 'http://localhost:8080/api/films'


const listeFilms = ref([])

async function init() {

    // FILMS
    const responseFillms = await axios.get(URL);
    const listeFilmsFormatJson = responseFillms.data;
    listeFilms.value = listeFilmsFormatJson;
}

async function supprimerFilm(idASupprimer) {
    await axios.delete(URL + '/' + idASupprimer);
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
    <h2 class="mt-2 mb-5">Liste des Films</h2>
    <div class="accordion accordion-flush mb-5 border" id="accordion-table">
        <div class="accordion-item">
            <h2 class="accordion-header" id="headingOne">
                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne"
                    aria-expanded="true" aria-controls="collapseOne">
                    Voir le tableau des films
                </button>
            </h2>
            <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne"
                data-bs-parent="#accordion-table">
                <div class="accordion-body p-0">
                    <table class="table table-striped">
                        <thead>
                            <tr class="">
                                <th scope="col">Titre</th>
                                <th scope="col">Date de sortie</th>
                                <th scope="col">Durée</th>
                                <th scope="col">Genre</th>
                                <th scope="col">Réalisateur</th>
                                <th scope="col">Acteurs</th>
                                <th scope="col">Détail</th>
                                <th scope="col">Modifier</th>
                                <th scope="col" class="text-center">Supprimer</th>
                            </tr>
                        </thead>
                        <tbody class="table-group-divider">
                            <tr v-for="film in listeFilms" :key="film.id">
                                <td scope="row">{{ film.titre }}</td>
                                <td>{{ film.sortie }}</td>
                                <td>{{ film.duree }}</td>
                                <td><span v-for="genre in film.genre" class="badge bg-secondary"
                                        style="margin-right: 0.3rem;">{{
                                            genre.libelle }}</span></td>
                                <td>

                                    <RouterLink :to="'/participants/' + film.realisateur_id">
                                        <!-- <span class="badge bg-success">{{ film.realisateur.nom }} {{ film.realisateur.prenom
                                        }}</span> -->
                                    </RouterLink>

                                </td>
                                <td>
                                    <template v-for="acteurs in film.acteurs">
                                        <RouterLink :to="'/participants/' + acteurs.id">
                                            <span class="badge bg-primary" style="margin-right: 0.3rem">{{ acteurs.nom }} {{
                                                acteurs.prenom
                                            }}</span>
                                        </RouterLink>
                                    </template>
                                </td>
                                <td class="text-center">
                                    <RouterLink :to="'/films/' + film.id"><i class="fa-solid fa-magnifying-glass"
                                            style="color: #16a2c5; font-size: 1.3rem;"></i></RouterLink>
                                </td>
                                <td class="text-center">
                                    <RouterLink :to="'/ajouterfilms/' + film.id"><i class="fa-solid fa-pen-to-square"
                                            style="color: #8ce61e;font-size: 1.3rem;"></i></RouterLink>
                                </td>
                                <td class="text-center"><button @click='supprimerFilm(film.id)' class="p-0 border-0"><i
                                            class="fa-solid fa-delete-left"
                                            style="color: red; font-size: 1.3rem;"></i></button></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="d-flex">

        <div class="row mb-5 col-12">
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
    </div>
</template>
