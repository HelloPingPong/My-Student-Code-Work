<template>
  <div id="products">
      <h1>Products</h1>
      <ProductList />
  </div>
</template>

<script>
import ProductList from '@/components/ProductList'

export default {
    components: {
        ProductList
    }
}
</script>

<style>
#products h1 {
    text-align: center;
}
</style>