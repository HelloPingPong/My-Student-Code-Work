<template>
  <div class="product" v-bind:class="{ bestseller: product.is_top_seller }">
      <h2>{{ product.name }}</h2>
      <img v-bind:src="require('../assets/product-images/' + product.image_name)">
      <div class="rating">
          <img src="../assets/star.png" class="ratingStar" v-for="n in product.rating" v-bind:key="n" />
          <img src="../assets/star_empty.png" class="ratingStar" v-for="e in numberOfEmptyStars" v-bind:key="'empty' + e" />
      </div>
      <p>${{ Number(product.price).toFixed(2) }}</p>
      <div class="notices">
          <span v-show="product.is_top_seller" class="topseller">Top Seller</span>
          <span v-show="product.quantity === 0" class="limitedstock">Sold Out</span>
          <span v-show="product.quantity > 0 && product.quantity <= 5" class="limitedstock">Only {{ product.quantity }} Left</span>
      </div>
  </div>
</template>

<script>
export default {
    name: 'product-list-item',
    props: ['product'],
    computed: {
        numberOfEmptyStars() {
            return 5 - Number(this.product.rating);
        }
    }

}
</script>

<style>
div.product {
 border: 1px black solid;
 /* width: 30%; */
 margin: 20px;
 border-radius: 5px;
 display: flex;
 flex-direction: column;
 justify-content: space-between;
 align-items: center;
 background-color: whitesmoke;
}
div.product.bestseller {
 background-color: lightyellow;
}
div.product img {
 width: 75%;
 max-height: 200px;
 align-self: center;
}
div.product h2 {
 font-size: 1.1rem;
 color: black;
}
div.rating {
 display: flex;
 justify-content: center;
 margin-top: 5px;
}
div.rating img.ratingStar {
 width: 20px;
}
div.product div.notices {
 display: flex;
 justify-content: space-between;
 align-content: flex-end;
 margin-right: 10px;
 margin-left: 10px;
 margin-bottom: 5px;
 width: 80%;
 font-weight: 800;
}
div.product div.notices span.topseller {
 color: blue;
}
div.product div.notices span.limitedstock {
 color: red;
}

</style>