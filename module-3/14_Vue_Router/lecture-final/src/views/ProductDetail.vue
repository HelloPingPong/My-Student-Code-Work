<template>
  <!-- add main class to div#app -->
  <div id="app" class="main">
 
    <!-- Title and Description -->
    <h2>Product Reviews for {{ product.name }}</h2>
    <p class="description">{{ product.description }}</p>
    
    <div class="actions">
      <router-link v-bind:to="{ name: 'products' }">Back to Products</router-link>
      &nbsp;|&nbsp;
      <router-link v-bind:to="{
        name: 'add-review',
        params: {
          id: product.id
        }
      }">
        Add Review</router-link>
    </div>

    <!-- div.well-display -->
    <div class="well-display">
      <!-- Average Summary -->
      <AverageSummary />
      <!-- Star Summaries -->
      <StarSummary rating="1" />
      <StarSummary rating="2" />
      <StarSummary rating="3" />
      <StarSummary rating="4" />
      <StarSummary rating="5" />
    </div>
    <!-- Review List -->
    <ReviewList />
  </div>
</template>

<script>
import AverageSummary from '@/components/AverageSummary';
import StarSummary from '@/components/StarSummary';
import ReviewList from '@/components/ReviewList.vue';

export default {
    name: 'product-detail',
    components: {
      AverageSummary,
      StarSummary,
      ReviewList
    },
    computed: { 
        product() {
            return this.$store.getters.product;
        }
    },
    created() {
        const productIdFromTheUrl = this.$route.params.id;
        this.$store.commit('SET_ACTIVE_PRODUCT', productIdFromTheUrl);
    }
}
</script>

<style>

</style>