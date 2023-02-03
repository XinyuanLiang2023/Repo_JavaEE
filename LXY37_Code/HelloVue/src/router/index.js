
import {createRouter,createWebHistory} from 'vue-router'

import HomeView from '../views/HomeView.vue'
import UserView from '../views/UserView.vue'


const router = createRouter({
  history:createWebHistory(import.meta.env.BASE_URL),
  routes:[
     {
    path: '/',
    name: 'Home',
    component: HomeView
  },
  {
    path: '/user',
    name: 'User',
    component: UserView
  },
  //这里，导入用到Book
  {
    path: '/user/add',
    name: 'UserAdd',
    component: () => import('../components/User/UserAdd.vue')
  }
]

})
export default router
