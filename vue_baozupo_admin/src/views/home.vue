<template>
  <div class="home">
    <!-- <img alt="Vue logo" src="../assets/logo.png"> -->
    <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
    <h1 style="color:red;">bestlmc</h1>
  {{ count }}
  <button @click="count++">Count</button>

  </div>
</template>



<script setup>
import { ref } from 'vue'

const count = ref(0)

</script>