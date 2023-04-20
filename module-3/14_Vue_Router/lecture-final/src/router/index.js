import Vue from 'vue'
import VueRouter from 'vue-router'
import Products from '@/views/Products'
import ProductDetail from '@/views/ProductDetail'
import AddReview from '@/views/AddReview'
import NotFound from '@/views/NotFound'
import Store from '@/store/index'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'products',
    component: Products
  },
  {
    path: '/products/:id',
    name: 'product-detail',
    component: ProductDetail
  },
  {
    path: '/products/:id/addreview',
    name: 'add-review',
    component: AddReview
  },
  {
    path: '/products',
    redirect: { name: 'products' }
  },
  {
    path: '*',
    name: 'notfound',
    component: NotFound
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

/*
to - where the user is trying to go
from - where the user is coming from
next - where the user is going to be sent
*/
router.beforeEach( (to, from, next) => {

  if (to.name === 'product-detail' || to.name === 'add-review') {
    const id = to.params.id;
    const product = Store.state.products.find( product => {
      return product.id == id;
    });
    if (!product) {
      // If the product is not found send the user to the 404 route
      next( { name: 'notfound' });
    }
  }
  // If we are still here then either the user was going to route without an id
  // or the product was found so let them continue on their way
  next();
});

export default router
