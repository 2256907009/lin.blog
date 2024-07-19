<template>
  <div>
    <div @click="back" class="back">返回</div>
    <h2>新建页面</h2>
  </div>

</template>
<style scoped>
  .back{
    margin: 20px;
    font-size: 20px;
  }
</style>

<script>
  export default{
    name:'page',
    data(){
      return{

      }
    },
    methods:{
      back(){
        return this.$router.back()
      }
    }
  }
</script>

