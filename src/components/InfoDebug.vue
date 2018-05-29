<template>
  <div id="panel">
    Lv{{level}}/40<mt-range v-model="level" :max=40 :min=1 borHeigh=20 ></mt-range>
    <mt-cell title="攻击" value="说明文字"></mt-cell>
    <mt-cell title="生命" ></mt-cell>
    <mt-cell title="防御" value="说明文字"></mt-cell>
    <mt-cell title="速度"></mt-cell>
    <mt-cell title="暴击" value="说明文字"></mt-cell>
 
</div>
</template>

<script>
import { info } from "./info.vue";
export default {
  name: 'InfoDebug',
  data (){
      return {
          level: 1,
          username: '123',
          email: '132', 
      }
  },
  methods: {
      
  }
}
</script>


<style>
#panel{
  font-family: 'Console'
}
</style>
