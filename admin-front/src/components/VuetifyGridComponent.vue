<template>
  <v-container>
    <v-layout row wrap>
      <v-flex xs12 sm4 class="box sample1">
        <div>Sample1</div>
      </v-flex>
      <v-flex xs12 sm4 class="box sample2">
        <div>Sample2</div>
      </v-flex>
      <v-flex xs12 sm4 class="box sample1">
        <div>Sample3</div>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
  export default {
    name: 'VuetifyGrid',

    data: () => ({

    }),
  }
</script>

<style>
.box {
  display: block;
  padding: 10px;
}
.sample1 {
  background: #ccc;
}
.sample2 {
  background: #eee;
}
</style>