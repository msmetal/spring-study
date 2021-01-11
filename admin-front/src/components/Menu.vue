<template>
  <div>
    <h1>Hello App!</h1>
    <p>
      <router-link to="/vuetifyGrid">Vuetify Grid</router-link>
    </p>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'Menu'
}
</script>