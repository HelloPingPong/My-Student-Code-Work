<template>
    <div class="well">
        <span class="amount" v-on:click="updateFilter()">{{ numberOfReviews }}</span>
        {{ rating }} Star Review{{ numberOfReviews === 1 ? '' : 's' }}
    </div>
</template>

<script>
export default {
    name: 'star-summary',
    props: ['rating'],
    methods: {
        updateFilter() {
            this.$store.commit('UPDATE_FILTER', Number(this.rating));
        }
    },
    computed: {
        numberOfReviews() {
            const reviews = this.$store.state.reviews;
           return reviews.reduce( (currentCount, review) => {
                return currentCount + (review.rating === Number(this.rating));
            }, 0);
        }
    }
}
</script>

<style>

</style>