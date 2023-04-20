<template>
  <div class="productlist">
      <div v-for="currentProduct in products" v-bind:key="currentProduct.id">
          <router-link v-bind:to="{ name: 'product-detail', params: { id: currentProduct.id } }">
            <ProductListItem v-bind:product="currentProduct" />
         </router-link>
      </div>

  </div>
</template>

<script>
import ProductListItem from '@/components/ProductListItem'
import InventoryService from '@/services/InventoryService'

export default {
    name: 'product-list',
    components: {
        ProductListItem
    },
    data() {
        return {
            products: []
        }
    },
    created() {
        InventoryService.getAllProducts()
        .then( response => {
            this.products = response.data;
        })
        .catch( err => console.error(err) );
    }
}
</script>

<style>
div.productlist {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    align-items: center;
}
div.productlist > div {
    width: 30%;
}
div.productlist a {
    text-decoration: none;
    color: black;
}
</style>