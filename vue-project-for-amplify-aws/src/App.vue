<script setup>
import { Authenticator, AmplifyButton } from '@aws-amplify/ui-vue';
import '@aws-amplify/ui-vue/styles.css';
import { getUrl } from 'aws-amplify/storage';

import HelloWorld from './components/HelloWorld.vue'
import TheWelcome from './components/TheWelcome.vue'
import { onMounted, ref } from 'vue';

import { CONNECTION_STATE_CHANGE } from 'aws-amplify/api';
import { Hub } from 'aws-amplify/utils';

const imageUrl = ref('');

onMounted(async () => {
  const result = await getUrl({
    key: 'logointelix-removebg-preview.png'
  });
  imageUrl.value = result.url.toString();
  console.log('imageUrl', imageUrl);
})

const connectionState = ref('');

Hub.listen('api', (data) => {
  const { payload } = data;
  if (payload.event === CONNECTION_STATE_CHANGE ) {
    connectionState.value = payload.data.connectionState;
  }
  console.log('Hub', data);
});

</script>

<template>
  <Authenticator>
    <template v-slot="{ user, signOut }">
        <h1>¡Hola! Bienvenido al sistema</h1>
      <button @click="signOut">¡Adios!</button>
      <header>
        <img alt="Vue logo" class="logo" :src="imageUrl" width="200" height="125" />

        <div class="wrapper">
          <HelloWorld :msg="connectionState" />
        </div>
      </header>

      <main>
        <TheWelcome />
      </main>

    </template>
  </Authenticator>
</template>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}

button {
  height: 50px;
  width: 400px;
  margin-top: 2%;
  background-color: #00bd7e;
  border-color: #00bd7e;
}
</style>
