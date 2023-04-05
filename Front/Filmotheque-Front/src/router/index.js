import { createRouter, createWebHistory } from 'vue-router'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      component: () => import('../views/Accueil.vue')
    },
    {
      path: '/films',
      component: () => import('../views/Films.vue')
    },
    {
      path: '/ajouterfilms',
      component: () => import('../views/FilmAjouter.vue')
    },
    {
      path: '/ajouterfilms/:id',
      component: () => import('../views/FilmAjouter.vue')
    },
    {
      path: '/genres',
      component: () => import('../views/Genres.vue')
    },
    {
      path: '/participants/nouveau',
      component: () => import('../views/ParticipantsAjouter.vue')
    },
    {
      path: '/membres',
      component: () => import('../views/Membres.vue')
    },
    {
      path: '/films/:id',
      component: () => import('../views/FilmDetail.vue')
    },
    {
      path: '/participants/:id',
      component: () => import('../views/ParticipantDetail.vue')
    },
    {
      path: '/participants',
      component: () => import('../views/Participants.vue')
    }
  ]
})

export default router
