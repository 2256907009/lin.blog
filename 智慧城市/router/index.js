import Vue from 'vue'
import Router from 'vue-router'
import TodoMain from '../components/TodoMain.vue'

//路由懒加载
const Home = () => import('@/views/home/Home.vue')

const News = () => import('@/views/news/News.vue')
const Personal = () => import('@/views/personal/Personal.vue')
const Services = () => import('@/views/services/Services.vue')
const Topic = () => import('@/views/topic/Topic.vue')
const testdddd = () => import('@/views/testdddd.vue')
const tabbar = () => import('@/components/tabbar/TabBar.vue')
import page from '../views/page.vue'
import Test from '../components/Test.vue'
Vue.use(Router)

const router =  new Router({
  mode:'history',
  routes: [
    {
        path:'',
        redirect:'/home',

    },
    {
      path:'/tabbar',
      component:tabbar,

    },
    {
      path:'/testdddd',
      component:testdddd
    },
    {
        path:'/home',
        component:Home,

    },
    {
        path:'/news',
        component:News,

    },
    {
        path:'/services',
        component:Services,

    },
    {
        path:'/topic',
        component:Topic,

    },
    {
        path:'/personal',
        component:Personal,

    },
    {
      path:'/page',
      component:page
    },
    {
      path:'/test',
      component:Test
    }

  ]
})




export default router;
