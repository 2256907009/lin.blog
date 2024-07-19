<template>
  <div class="home">
    <div class="home-title">首页</div>
    <div class="blank"></div>
    <!-- change事件是每次更新按住enter才可以刷新，blur是失焦事件，input是对事件进行同步操作-->
    <!-- 改为只使用键盘的enter才跳转路由，change事件发生在元素失去焦点且值发生变化的时候触发 -->
    <input type="text" :placeholder="placeholder" class="search" v-model="test" @keyup.enter="ho()"  @input="changePathEnter" @click="showT=true" @blur="showT=false"/>
      <ul class="search-list" v-if="showT">
        <li v-for="(item,index) in filteredItems" :key="index" @click="changePath(item.path)">{{item.name}}</li>
      </ul>
    <div class="swiper-style">
      <div class="swiper-container">
        <div class="swiper-wrapper">
          <div class="swiper-slide" v-for="(item,index) in list" :key="index" >
            <img :src="item.imgs" alt="" />
          </div>
        </div>
        <!-- 如果需要分页器 -->
        <div class="swiper-pagination"></div>
        <!-- 如果需要导航按钮 -->
        <div class="swiper-button-prev"></div>
        <div class="swiper-button-next"></div>

        <!-- 如果需要滚动条 -->
        <div class="swiper-scrollbar" style="display: none;"></div>
      </div>
    </div>
    <div class="referral-service">
      <div style="font-size: 20px;padding: 5px;">推荐服务</div>
      <div class="referral-service-topic">
        <div v-for="(item,index) in service" :key="index" @click="changePath(item.path)">
          <img :src="item.iconPath" alt="" />
          {{item.name}}
        </div>
      </div>
    </div>
    <div class="takeAway" @click="takeAway">
      <div class="order-takeAway">订单外卖-></div>
      <div style="padding: auto;font-size: 30px;">></div>
    </div>
    <div class="theme">
      <div class="theme-title" >热门主题</div>
      <div class="theme-topic">
        <div v-for="(item,index) in theme" :key="index" @click="takeAway"  >
          <img :src="item.pic" alt=""></img>
        </div>
      </div>
    </div>
    <div class="content">
      <div class="contnet-title">新闻专栏</div>
      <div v-for="(item,index) in news" :key="index" @click="changeNewsPath(item.newsPage)">
        <div class="content-news">
          <img :src="item.img" alt="" />
          <div class="content-news-topic">{{item.news}}</div>
        </div>
        <div class="new-solid"></div>
      </div>
    </div>



  </div>


</template>

<style scoped>

  .home{
    width: 390px;
    /* 超出部分实现滚动 */
    overflow-y: scroll;
    overflow-x: hidden;
    height: 775px;
    position: fixed;
  }

  .home-title{
    width: 100%;
    height: 60px;
    background-color: blue;
    color: white;
    font-size: 20px;
    padding: 15px 5%;
    box-sizing: border-box;/*确保内边距不会改变盒子的大小*/
    top:0;
    position: fixed;
    z-index: 999;

  }
  .blank{
    width: 100%;
    height: 60px;
  }
  .search{
    width: 90%;
    height: 35px;
    margin-top: 10px;
    margin-left: 6px;
    font-size: 20px;
    border: 0;
    border-radius: 20px;
    box-shadow: 1px 5px 10px rgb(210, 210, 210),
    -1px -1px 0px rgb(210, 210, 210);
    outline: none;
    color: black;
    padding-left: 3vh;
  }


  .search-list{
    position: fixed;
    z-index: 10;

    width: 98%;
    background-color: white;
    margin-top: 5px;
    margin-left: 5px;
    opacity: 0.8;
    gap: 5px;
    padding-left: 10px;
    box-sizing: border-box;
    list-style: none;
    font-size: 19px;
  }


  .swiper-style{
    width: 95%;
    margin-top: 10px;
    margin-left: 8px;
  }
  .swiper-slide img{
    width: 100%;
  }

  .referral-service{
    width: 97%;
    height: 200px;
    background-color: antiquewhite;
    margin-top: 5px;
    margin-left: 5px;
    border-radius: 5px;
    /* 右 下 */
    box-shadow: 0px 5px 15px rgb(210, 210, 210);
  }
  .referral-service-topic{
    display: flex;
    /* 使其可以换行 */
    flex-wrap: wrap;
    justify-content: space-evenly;
  }

  .referral-service-topic img{
    display: block;
    border-radius: 50%;
    width: 50px;
    height: 50px;
  }

  .takeAway{
    display: flex;
    width: 97%;
    height: 50px;
    background-color: blue;
    margin-left: 1.5%;
    border-radius: 2px;
    justify-content: space-between;
    margin-top: 20px;
    box-shadow: 0px 5px 5px rgb(210, 210, 210);
  }
  .order-takeAway{
    color: white;
    font-size: 20px;
    padding: 10px;
    padding-left: 30%;
  }

  .theme{
    width: 97%;
    background-color: antiquewhite;
    margin-left: 6px;
    margin-top: 10px;
    border-radius: 10px;
    box-shadow: 0px 5px 5px rgb(210, 210, 210);
  }
  .theme-title{
    font-size: 20px;
    margin-top: 3px;
    padding-top: 10px;
    padding-left: 10px;
  }
  .theme-topic{
    display: flex;
    flex-wrap: wrap;
    gap: 50px;
    justify-content: center;
    padding-top: 10px;
    padding-bottom: 5px;

  }
  .theme-topic img{
    width: 130px;
    height: 130px;
    border-radius: 20px;
    box-shadow: 5px 5px 5px rgb(210, 210, 210);
  }
  .content{
    width: 100%;
    height: 600px;
    font-size: 20px;
    box-sizing: border-box;
  }
  .contnet-title{

    background-color: blue;
    width: 97.5%;
    margin-top: 13px;
    margin-left: 6px;
    padding: 8px;
    box-sizing: border-box;
    border-radius: 5px;
    height: 40px;
    color: white;
  }
  .content-news{
    display: flex;
    margin-top: 10px;
    margin-bottom: 5px;
    margin: 10px;
  }
  .content-news img{
    width: 35%;
    height: 35%;
    margin-right: 5px;


  }
  .content-news-topic{
    font-size: 20px;
  }
  .new-solid{
    width: 100%;
    height: 1px;
    background-color: rgb(210, 210, 210);
  }

</style>

<script >
  import Swiper from 'swiper' ;

  import 'swiper/css/swiper.min.css'
  var a = require('@/assets/img1.jpg')
  var b = require('@/assets/img2.jpg')
  var c = require('@/assets/img3.jpg')
  var icon = require('@/assets/icon.jpg')
  var img = require('@/assets/news.jpg')
  export default{
    name:'Home',
    data(){
      return{
        test:'',
        news:[
          {
            img:img,
            news:'中国共产党第二十届中央委员会第三次全体会议公报',
            newsPage:'/page'
          },
          {
            img:img,
            news:'中国共产党第二十届中央委员会第三次全体会议公报',
            newsPage:'/page'
          },
          {
            img:img,
            news:'中国共产党第二十届中央委员会第三次全体会议公报',
            newsPage:'/page'
          },
          {
            img:img,
            news:'中国共产党第二十届中央委员会第三次全体会议公报',
            newsPage:'/page'
          },
          {
            img:img,
            news:'中国共产党第二十届中央委员会第三次全体会议公报',
            newsPage:'/page'
          }

        ],
        theme:[
          {pic:icon},
          {pic:icon}
        ],
        list:[
          {imgs: a},
          {imgs: b},
          {imgs: c}
        ],
        service:[
          {
            'name':'数据分析',
            'ename':'shujufenxi',
            'iconPath':icon,
            'path':'/page'
          },
          {
            'name':'青年驿站',
            'ename':'qingnianyizhan',
            'iconPath':icon,
            'path':'/page'
          },
          {
            'name':'爱心捐赠',
            'ename':'aixinjuanzeng',
            'iconPath':icon,
            'path':'/page'
          },
          {
            'name':'数据分析',
            'ename':'shujufenxi',
            'iconPath':icon,
            'path':'/page'
          },
          {
            'name':'数据分析',
            'ename':'shujufenxi',
            'iconPath':icon,
            'path':'/page'
          },
          {
            'name':'数据分析',
            'ename':'shujufenxi',
            'iconPath':icon,
            'path':'/page'
          },
          {
            'name':'青年驿站',
            'ename':'qingnianyizhan',
            'iconPath':icon,
            'path':'/page'
          },
          {
            'name':'爱心捐赠',
            'ename':'aixinjuanzeng',
            'iconPath':icon,
            'path':'/page'
          },
          {
            'name':'数据分析',
            'ename':'shujufenxi',
            'iconPath':icon,
            'path':'/page'
          },
          {
            'name':'数据分析',
            'ename':'shujufenxi',
            'iconPath':icon,
            'path':'/page'
          }
        ],
        placeholderIndex:0,
        aaa:null,
        showT:false,
        //空列表用于将过滤的信息存入
        filteredItems:[]
      }
    },
    created() {

    },
    computed:{
      placeholder() {
        //需要判断数据加载完成没有才可以将值付出
        //使用数据属性需要写this才会指向去使用的作用域
           if (this.service.length > 0) {
             return this.service[this.placeholderIndex].name;
           } else {
             return ''; // 或者其他默认值，处理数据加载时的初始情况
           }
      }

    },
    //create()是对页面还没有渲染之前的操作，mounted()是对页面渲染完成之后的对dom对象的操作
    mounted(){
        var swiper = new Swiper('.swiper-container',{
          loop:true,
          // 如果需要分页器
          pagination: {
            el: '.swiper-pagination',
          },
          // 如果需要前进后退按钮
          navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
          },
          // 如果需要滚动条
          scrollbar: {
            el: '.swiper-scrollbar',
          },
        });

        // 定时器逻辑
        this.aaa = setInterval(() => {
          //逻辑：通过每次递增下标去摸对列表长度，当达到最后一个下标的时候，又会重置
          this.placeholderIndex = (this.placeholderIndex + 1) % this.service.length;
        }, 2000); // 每2秒切换一次 placeholderIndex
    },
    methods:{
      changePathEnter(e){

        // console.log(test);
        // const se = this.service.find(obj => obj.name===test)
        //提示导航
        this.filteredItems = this.service.filter(item => {
          const nameLower = item.name.toLowerCase()
          const enameLower = item.ename.toLowerCase()
          return nameLower.includes(this.test.toLowerCase())||enameLower.includes(this.test.toLowerCase())
        });
      },
      //放在change中
      ho(){

        //二者皆可用
        //跳转路由当失去焦点的时候跳转
        for(let se of this.service){
          if(se.name === this.test){
            this.$router.push(se.path)
          }else{
            console.log('失败');
          }
        }

      },
      changePath(path){
        //用于直接替换路由
        this.$router.push(path)
      },
      takeAway(){
        //使用push可用于返回之前页面，使用this.$route.go(-1)或者this.$route.back()
        this.$router.push('/page')
      },
      changeNewsPath(path){
        this.$router.push(path)
      }

    },
    beforeDestroy(){
      clearInterval(this.aaa)
    }



  }
</script>


