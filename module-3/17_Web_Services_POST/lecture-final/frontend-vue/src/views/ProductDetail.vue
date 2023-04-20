<template>
<div>
   <div class="loading" v-if="isLoading">
       <img src="../assets/loading_icon.gif" alt="">
   </div>
   <div class="error" v-if="errorMessage">
       Error: {{errorMessage}}
   </div>
  <div id="app" class="main" v-if="!isLoading && !errorMessage">
      <h1>{{product.name}}</h1>
      <p class="description">{{ product.description }}</p>
      <div class="actions">
          <router-link v-bind:to="{ name:'products' }">Back to Products</router-link>
          &nbsp;|&nbsp;
          <router-link v-bind:to="{ 
              name: 'add-review', 
              params: {
                  id: product.id
              }
          }">
              Add Review
          </router-link>
      </div>
      <div class="well-display">
          <AverageSummary v-bind:reviews="product.reviews" />
          <StarSummary rating="1" v-bind:reviews="product.reviews" />
          <StarSummary rating="2" v-bind:reviews="product.reviews" />
          <StarSummary rating="3" v-bind:reviews="product.reviews" />
          <StarSummary rating="4" v-bind:reviews="product.reviews" />
          <StarSummary rating="5" v-bind:reviews="product.reviews"/>
      </div>
      <ReviewList v-bind:reviews="product.reviews" />
  </div>
</div>
</template>

<script>
import AverageSummary from '@/components/AverageSummary'
import StarSummary from '@/components/StarSummary'
import ReviewList from '@/components/ReviewList'
import ProductsService from '@/services/ProductsService'

export default {
    components: {
        AverageSummary,
        StarSummary,
        ReviewList
    },
    data() {
        return {
            product: {},
            isLoading: true,
            errorMessage: ''
        }
    },
    created() {
        const activeProductId = this.$route.params.id;
        this.$store.commit('SET_ACTIVE_PRODUCT', activeProductId);

        ProductsService.getProductById(activeProductId)
            .then( response => {
                this.product = response.data;
                this.isLoading = false;
            })
            .catch ( error => {
                console.error(error)
                // If there is a response, we know it is a response error
                if (error.response) {
                    if (error.response.status === 404) {
                        this.$router.push({ name: 'not-found'} );
                    } else {
                        this.errorMessage = error.response.status + ": " + error.response.statusText;
                        console.error(error);
                    }
                }
                // If there is no response, but there is a request we know it was a failed connection
                else if (error.request) {
                    this.errorMessage = "The server could not be reached";
                } 
                // If no response and no request something horrible has happened in our code
                else {
                    this.errorMessage = "Unexpected error!";
                    console.error(error);
                }
                this.isLoading = false;
            });
    }
}
</script>

<style>
div.loading {
    height: 75vw;
    display:flex;
    justify-content: center;
    align-items: center;
}

div.error {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top:50px;
    background-color: red;
    color: white;
    height: 50px;
    font-size: 1.5rem;
}
</style>