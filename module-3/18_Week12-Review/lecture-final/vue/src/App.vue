<template>
  <div id="app">
    <header>
      <h1>{{ $store.state.storeName }}</h1>
      <div id="nav">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'products' }">Show Products</router-link>&nbsp;|&nbsp;
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div>
    </header>
    <main>
      <router-view />
    </main>
  </div>
</template>
