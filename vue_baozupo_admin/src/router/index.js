import { createRouter, createWebHashHistory } from 'vue-router'
import NProgress from "nprogress"
import 'nprogress/nprogress.css' //这个样式必须引入
import Layout from '../layout/index'
// import HomeView from '../views/HomeView.vue'
NProgress.configure({ showSpinner: false })// NProgress Configuration

const routes = [
  // {
  //   path: '/',
  //   name: 'home',
  //   component: HomeView
  // },
  {
    path: '/',
    component: Layout,
    //name: 'home',
    redirect: '/home',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    // component: () => import(/* webpackChunkName: "about" */ '../views/home.vue')
    children: [
      {
        path: 'home',
        // component: (resolve) => require(['@/views/home'], resolve),
        component: () => import(/* webpackChunkName: "about" */ '../views/home.vue'),
        name: 'home',
        meta: { title: '首页', icon: 'index', affix: true, noCache: true }
      }
    ]
  }
  // {
  //   path: '/about',
  //   name: 'about',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  // }
]
console.log(routes);
const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
