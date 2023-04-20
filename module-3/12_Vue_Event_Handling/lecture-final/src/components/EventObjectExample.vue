<template>
  <div v-bind:style="'background-color: ' + backgroundColor">
      <ul id="color" v-on:click="changeBackgroundColor($event)">
          <li>Red</li>
          <li>Blue</li>
          <li>Green</li>
          <li>Brown</li>
          <li>Yellow</li>
          <li>Cornflowerblue</li>
          <li>Goldenrod</li>
          <li>Transparent</li>
      </ul>
  </div>
</template>

<script>
export default {
    data() {
        return {
            backgroundColor: 'transparent'
        }
    },
    methods: {
        changeBackgroundColor(event) {
            this.backgroundColor = event.target.innerText;
        }
    }
}
</script>

<style>
ul {
    list-style: none;
}
li {
    cursor: pointer;
}
</style>