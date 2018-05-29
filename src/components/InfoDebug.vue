<template>
  <div class="page-cell-wrapper">
    <mt-cell title="标题文字" value="说明文字"></mt-cell>
    <mt-cell title="标题文字" is-link>
      <span style="color: green">这里是元素</span>
    </mt-cell>

</div>
</template>

<script>
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

</style>
