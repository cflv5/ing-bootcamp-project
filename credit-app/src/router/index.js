import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/report/:id',
    name: 'Report',
    component: () => import("@/views/Report.vue")
  },
  {
    path: '/:catchAll(.*)',
    name: 'NotFound',
    component: () => import("@/components/NotFound.vue")
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
