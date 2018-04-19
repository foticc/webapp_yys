<template>
  <div>
    <mt-header fixed title="固定在顶部">

    </mt-header>
    <mt-tab-container v-model="selected">
      <mt-tab-container-item id="test1">
        <CellList></CellList>
      </mt-tab-container-item>
      <mt-tab-container-item id="test2">

      </mt-tab-container-item>
      <mt-tab-container-item id="test3">

      </mt-tab-container-item>
    </mt-tab-container>
    <mt-tabbar v-model="selected" fixed>
      <mt-tab-item id="test1">
        <img slot="icon" src="../assets/logo.png">
      </mt-tab-item>
      <mt-tab-item id="test2">
        <img slot="icon" src="../assets/logo.png">
      </mt-tab-item>
      <mt-tab-item id="test3">
        <img slot="icon" src="../assets/logo.png">
      </mt-tab-item>
    </mt-tabbar>
  </div>
</template>

<script>
import CellList from './CellList.vue'
export default {
  name: 'Home',
  components: { CellList },
  data() {
    return {
      selected: 'test1'
    }
  }
}
</script>
