<template>
  <div class="reviews">
      <ReviewDisplay v-bind:review="currentReview"
        v-for="currentReview in filteredReviews" v-bind:key="currentReview.id" />
  </div>
</template>

<script>
import ReviewDisplay from './ReviewDisplay.vue'

export default {
    name: 'review-list',
    components: {
        ReviewDisplay
    },
    computed: {
        filteredReviews() {
            return this.$store.state.reviews.filter( review => {
                return this.$store.state.filter === 0 ? true : this.$store.state.filter === review.rating;
            });
        }
    }
}
</script>

<style>

</style>