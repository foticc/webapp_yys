<template>
  <div>
    <div class="header">
       <mt-header fixed title="固定在顶部"></mt-header>
    </div>
    <mt-tab-container v-model="selected">
      <mt-tab-container-item id="test1">
        <div>
          <CellList></CellList>
        </div>
      </mt-tab-container-item>
      <mt-tab-container-item id="test2">
        <InfoDebug></InfoDebug>
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
import InfoDebug from './InfoDebug.vue'
export default {
  name: 'Home',
  components: { CellList,InfoDebug },
  data() {
    return {
      selected: 'test1'
    }
  }
}
</script>
