<template>
  <div class="card"
    v-bind:class="{'read':book.read}">
    <h2 class="book-title"> {{book.title}} </h2>
    <h3 class="book-author"> {{book.author}} </h3>
    <img class="book-image" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'">
    <button class="button" :class="{'mark-read': !book.read, 'mark-unread': book.read }"
    @click="readButton()"
    > {{book.read ? 'Mark Unread' : 'Mark Read'}} </button>

  </div>
</template>

<script>
export default {
    name: 'book-card',
    props: ['book'],
    methods: {
        readButton() {
            this.$store.commit('IS_BOOK_FINISHED',this.book)
        }
    }
}
</script>

<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
    position: relative;
}

.card.read {
    background-color: lightgray;
}

.card .book-title {
    font-size: 1.5rem;
}

.card .book-author {
    font-size: 1rem;
}

.book-image {
    width: 80%;
}

.mark-read, .mark-unread {
    display: block;
    position: absolute;
    bottom: 40px;
    width: 80%;
    left: 10%;
    font-size: 1rem;
}
</style>