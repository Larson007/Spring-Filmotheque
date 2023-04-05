<script setup>
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router';
import axios from 'axios'

const URL = 'http://localhost:8080/api/participants/'

const participant = ref([])

async function init() {
    const route = useRoute();
    const reponse = await axios.get(`${URL}${route.params.id}`);
    participant.value = reponse.data;
}

onMounted(() => {
    init();
})
</script>

<template>
    <div class="d-flex">
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
</template>