<template>
  <div id="app">
    <router-view></router-view>
    <TabBar />
  </div>




</template>

<script>


  import TabBar from './components/tabbar/TabBar.vue'
  export default {
    name: 'App',
    data(){
      return{

      }
    },
    methods:{

    },
    components:{
     TabBar
    }




  }
</script>

<style >
  *{
    margin: 0;
    padding: 0;
  }
  #app{
    width: 100%;
    height: 800px;
  }




</style>
