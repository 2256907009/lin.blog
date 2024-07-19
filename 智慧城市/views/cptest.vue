<template>
  <div>


    <div class="tabar">

      <div v-for="(i,idx) in tabar_list" :class="{'active':(index == idx),'unactive':(index != idx)}"><a :href='i.pagePath'>{{i.name}}</a>
      </div>
    </div>

  </div>
</template>

<style scoped>
.tabar{
  display: flex;
  justify-content: space-evenly;
  gap: 20px;
  height: 60px;
  background-color: rgb(122,122,122);
  align-items: center;
  position: fixed;
  bottom: 0;
  width: 100%;
}
.tabar div{
  width: 50px;
  height: 40px;
  color: white;
  text-align: center;
  line-height: 40px;
}
.active{
  background-color: red;
}
.unactive{

  background-color: #666;
}
</style>

<script>
  export default{
    name:'cptest',
    props:['index'],
    data(){
      return{
        tabar_list : [
          {'name':'首页','pagePath':'/home'},
          {'name':'订单'},
          {'name':'我的'}
        ]
      }
    },
    methods:{

    },
    components:{

    }

  }
</script>

