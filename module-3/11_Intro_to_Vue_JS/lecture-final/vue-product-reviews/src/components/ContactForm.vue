<template>
  <div>
      <h1>Contact Form</h1>
      <div>
          <label for="name">Name:</label>
          <input type="text" id="name" v-model="name">
      </div>
      <div>
          <label for="email">Email:</label>
          <input type="text" id="email" v-model="email">
      </div>
      <div>
          <label for="emailType">Email Type</label>
          <select id="emailType" v-model="emailType">
              <option value="PERSONAL">Personal</option>
              <option value="WORK">Work</option>
              <option value="OTHER">Other</option>
          </select>
      </div>
      <div>
          <p>{{ name }}</p>
          <p>{{ email }}</p>
          <p>{{ emailType }}</p>
      </div>
  </div>
</template>

<script>
export default {
    data() {
        return {
            name: '',
            email: '',
            emailType: ''
        }
    }
}
</script>

<style>

</style>