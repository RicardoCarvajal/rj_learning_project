<script setup>

import { generateClient } from 'aws-amplify/api';
import { onCreateTareas } from './../graphql/subscriptions';
import { createTareas } from './../graphql/mutations';

import { onUpdateTareas } from './../graphql/subscriptions';
import { updateTareas } from './../graphql/mutations';

import { ref } from 'vue';

const cliente = generateClient();

const task_name = ref('');
const task_score = ref(0);

async function createNewTask() {
  try {
    const newTask = await cliente.graphql({
      query: createTareas,
      variables: {
        input: {
          nombre: task_name.value,
          puntuacion: task_score.value
        }
      }
    })
  } catch (error) {
    console.error('Error creando la tarea', error);
  }
}

const OnCreateTareas = cliente.graphql({
  query: onCreateTareas
}).subscribe({
  next: ({ data }) => console.log(data),
  error: (error) => console.warn(error)
})

</script>

<template>
  <div>
    <input v-model="task_name" placeholder="Nombre de la tarea..." />
    <br>
    <input v-model="task_score" placeholder="Puntuacion de la tarea..." />
    <br>
    <button @click="createNewTask">Crear tarea {{ task_name }} con puntacion {{ task_score }}</button>  
  </div>
</template>

<style scoped>
input {
  height: 50px;
  width: 400px;
  margin-top: 2%;
  border-color: #00bd7e;
}

button {
  height: 50px;
  width: 400px;
  margin-top: 2%;
  background-color: #00bd7e;
  border-color: #00bd7e;
}

</style>