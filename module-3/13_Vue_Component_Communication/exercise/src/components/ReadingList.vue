<template>
  <div class="book-container">
    <BookCard v-bind:book="book"
    v-for="book in $store.state.books" v-bind:key="book.id"/>
 
  </div>
</template>

<script>
import BookCard from './BookCard.vue'

export default {
    name: 'reading-list',
    components: {
      BookCard
    }
}
</script>

<style>
.book-container {
    display: flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>