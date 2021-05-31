<template>
  <div>
    <div id="gird"></div>
  </div>
</template>

<script>
import Grid from 'tui-grid'
import 'tui-grid/dist/tui-grid.css'

const instance = new Grid({
  el: document.getElementById('grid'), // Container element
  columns: [
    {
      header: 'Name',
      name: 'name'
    },
    {
      header: 'Artist',
      name: 'artist'
    },
    {
      header: 'Release',
      name: 'release'
    },
    {
      header: 'Genre',
      name: 'genre'
    }
  ],
  data: [
    {
      name: 'Beautiful Lies',
      artist: 'Birdy',
      release: '2016.03.26',
      genre: 'Pop'
    }
  ]
});

const rowData = [
  {
    name: 'Beautiful Lies',
    artist: 'Birdy',
    release: '2016.03.26',
    genre: 'Pop'
  }
]

instance.resetData(rowData); // Call API of instance's public method

Grid.applyTheme('striped'); // Call API of static method

export default {
  name: 'ToastGrid',

  data: () => ({}),
}
</script>