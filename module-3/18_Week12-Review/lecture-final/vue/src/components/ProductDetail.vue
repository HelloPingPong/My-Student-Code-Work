<template>
  <div class="productDetail">
      <h2>Showing {{ product.name }}</h2>
      <p>Product Id: {{ product.id }}</p>
      <ProductListItem v-bind:product="product" />
  </div>
</template>

<script>
import InventoryService from '@/services/InventoryService'
import ProductListItem from './ProductListItem.vue'

export default {
    name: 'product-detail',
    components: {
        ProductListItem
    },
    data() {
        return {
            product: {}
        }
    },
    created() {
        // Get the id from the URL
        // Use the inventory service to get the product
        // when the promise resolves set this.product to the returned object
        const productId = this.$route.params.id;
        InventoryService.getProductById(productId)
            .then( response => {
                this.product = response.data;
            }).catch( err => console.error(err) );
    }
}
</script>

<style>
div.productDetail {
    display: flex;
    flex-direction: column;
    align-items: center;
}
</style>