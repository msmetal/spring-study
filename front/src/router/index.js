import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import ReviewComponent from '@/components/ReviewComponent'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {name: 'Reviews', path: '/reviews', component: ReviewComponent}
  ]
})
