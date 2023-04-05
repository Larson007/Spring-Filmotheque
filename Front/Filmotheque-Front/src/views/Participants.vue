<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'
const URL = 'http://localhost:8080/api/participants'

const listeParticipants = ref([])
console.log(listeParticipants);
async function init() {

    const response = await axios.get(URL);
    const listeParticipantsFormatJson = response.data;
    listeParticipants.value = listeParticipantsFormatJson;
}

onMounted(() => {
    init();
})
</script>

<template>
    <h2 class="mt-2 mb-5">Listes des participants</h2>
    <div class="row">
        <template v-for="participant in listeParticipants">
            <div class="col-3 mb-4">
                <div class="card rounded" style="width: 19rem;">
                    <RouterLink :to="'/participants/' + participant.id">
                    <img :src="'/images/participants/' + participant.photo" :alt="participant.prenom + ' ' + participant.nom"
                    class="card-img rounded-0 img-fluid">
                </RouterLink>
                    <div class="card-body text-center">
                        <h5 class="card-title">{{ participant.prenom + ' ' + participant.nom }}</h5>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Rôles :
                            <span class="badge bg-primary" v-if="participant.acteur" style="margin-right: 0.3rem;">Acteur</span>
                            <span class="badge bg-success" v-if="participant.realisateur">Réalisateur</span>
                        </li>
                        <li class="list-group-item">Date de naissance : {{ participant.naissance }}</li>
                    </ul>
                    <div class="card-body text-center bg-primary-subtle">
                        <RouterLink :to="'/participants/' + participant.id">Voire la fiche</RouterLink>
                    </div>
                </div>
            </div>
        </template>
    </div>
</template>