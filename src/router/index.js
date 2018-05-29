import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import info from '@/components/info'
import InfoDebug from '@/components/InfoDebug'
import App from '../App'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/info/:id',
      name: 'info',
      component: info
    }
  ]
})
