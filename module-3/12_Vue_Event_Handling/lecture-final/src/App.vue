<template>
  <div id="app">
    <EventObjectExample />
    <product-review></product-review>
  </div>
</template>

<script>
import ProductReview from "./components/ProductReview.vue";
import EventObjectExample from "./components/EventObjectExample.vue"

export default {
  name: "app",
  components: {
    ProductReview,
    EventObjectExample
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 800px;
  margin: 60px auto 0 auto;
}
</style>
