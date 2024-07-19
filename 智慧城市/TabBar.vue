<template>
<!-- find是语法池，封装了foreach循环，通过判断当前路由路径是否是底部导航的路径 -->
  <div v-if="list.find((i) => i.pagePath == this.$route.path)">
    <div class="tabar">
      <div v-for="(i,idx) in list" :key="idx" @click="changePath(i.pagePath)">
        <img :src="i.pagePath===$route.path ? i.selectedIconPath : i.iconPath " alt="" style="width: 35px;height: 35px;position: absolute;bottom: 25px;" />
          <div :style="{color:i.pagePath===$route.path?'purple':'black'}">{{i.name}}</div>
      </div>
    </div>

  </div>
</template>

<style scoped>
  .tabar{
      display: flex;
      position: fixed;
      width: 100%;
      height: 70px;
      background-color: antiquewhite;
      justify-content:space-evenly;
      align-items: flex-end; /* 调整项目底部对齐 */
      bottom: 0;
      margin-top: -20px; /* 向上移动固定像素 */

  }


</style>

<script>
  var home = require('@/assets/tabbar/MdHome.png')
  var homes =  require('@/assets/tabbar/MdHome1.png')
  var grid =  require('@/assets/tabbar/Grid1.png')
  var grids =  require('@/assets/tabbar/Grid.png')
  var heart = require('@/assets/tabbar/HeartCircle.png')
  var hearts = require('@/assets/tabbar/HeartCircle1.png')
  var newt = require('@/assets/tabbar/NewspaperOutline1.png')
  var newts = require('@/assets/tabbar/NewspaperOutline.png')
  var person = require('@/assets/tabbar/MdPerson.png')
  var persons = require('@/assets/tabbar/MdPerson1.png')


  export default{
    name:'TabBar',
    data(){
      return{
        display:true,

        list:[
          {
            'name':'首页',
            'iconPath':home,
            'selectedIconPath':homes,
            'pagePath':'/home'
          },
          {
            'name':'服务',
            'iconPath':grid,
            'selectedIconPath':grids,
            'pagePath':'/services'
          },
          {
            'name':'主题',
            'iconPath':heart,
            'selectedIconPath':hearts,
            'pagePath':'/topic'
          },
          {
            'name':'新闻',
            'iconPath':newt,
            'selectedIconPath':newts,
            'pagePath':'/news'
          },
          {
            'name':'中心',
            'iconPath':person,
            'selectedIconPath':persons,
            'pagePath':'/personal'
          }
        ]
      }
    },
    methods:{
      changePath(path){
        //router操作对象是一个路由对象，可用于替换路由，route只读信息
        this.$router.push(path)
      },


    },
    watch: {
      //指即将离开的路径和要去的路径，适用于生命周期和导航守卫
      $route(to, from) {
        this.display = to.path !== '/page'; // 进行条件判断
      }
    }
  }
</script>


