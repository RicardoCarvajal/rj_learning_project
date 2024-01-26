<script setup>

import { generateClient } from 'aws-amplify/api';
import { listTareas } from './../graphql/queries';

import { ref } from 'vue';

defineProps({
  msg: {
    type: String,
    required: true
  }
})

const cliente = generateClient();

let tasks = ref([]);

async function listTask() {
  try {
    const result = await cliente.graphql({
      query: listTareas,
      variables: {
        limit: 2
      }
    });
    tasks = result;
    console.log(result);
  } catch (error) {
    console.error('Error listando las tareas', error);
  }
}

</script>

<template>
  <div class="greetings">
    <h1 class="green">{{ msg }}</h1>
    <button @click="listTask">Listar tareas</button> 
  </div>
</template>

<style scoped>

h1 {
  font-weight: 500;
  font-size: 2.6rem;
  position: relative;
  top: -10px;
}

h3 {
  font-size: 1.2rem;
}

.greetings h1,
.greetings h3 {
  text-align: center;
}

@media (min-width: 1024px) {
  .greetings h1,
  .greetings h3 {
    text-align: left;
  }
}

button {
  height: 50px;
  width: 300px;
  margin-top: 2%;
  background-color: #00bd7e;
  border-color: #00bd7e;
}
</style>