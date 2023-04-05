<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
    <nav class="navbar">
      <ul class="nav mb-3">
        <li class="nav-item">
          <RouterLink to="/films">Films</RouterLink>
        </li>
        <li class="nav-item">
          <RouterLink to="/ajouterfilms">Nouveau Film</RouterLink>
        </li>
        <li class="nav-item">
          <RouterLink to="/genres">Gestion des genres</RouterLink>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Gestion des participants
          </a>
          <ul class="dropdown-menu">
            <li class="dropdown-item">
              <RouterLink to="/participants">Voire les participants</RouterLink>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>
            <li class="dropdown-item">
              <RouterLink to="/participants/nouveau">Ajout de participants</RouterLink>
            </li>
          </ul>
        </li>

        <!-- <li class="nav-item">
          <RouterLink to="/membres">Gestion des membres</RouterLink>
        </li> -->
      </ul>
    </nav>
  </header>

  <RouterView />
</template>

<style scoped>
header {
  line-height: 1.5;
  max-height: 100vh;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
}

nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  display: inline-block;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
}

nav a:first-of-type {
  border: 0;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }

  nav {
    text-align: left;
    margin-left: -1rem;
    font-size: 1rem;

    padding: 1rem 0;
    margin-top: 1rem;
  }
}</style>