<template>
  <div class="well">
    <span class="amount" v-on:click="updateFilter()">{{ averageRating }}</span>
    Average Rating
  </div>
</template>

<script>
export default {
  name: "average-summary",
  props: ['reviews'],
  methods: {
    updateFilter() {
      this.$store.commit("UPDATE_FILTER", 0);
    }
  },
  computed: {
    averageRating() {

      let sum = this.reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      if (sum === 0) {
        return 0;
      } else {
        return (sum / this.reviews.length).toFixed(2);
      }
    }
  }
};
</script>
