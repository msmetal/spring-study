import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import VuetifyGridComponent from "@/components/VuetifyGridComponent";
import ToastGridComponent from "@/components/ToastGridComponent";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/vuetifyGrid',
    name: 'VuetifyGrid',
    component: VuetifyGridComponent
  },
  {
    path: '/toastGrid',
    name: 'ToastGrid',
    component: ToastGridComponent
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
