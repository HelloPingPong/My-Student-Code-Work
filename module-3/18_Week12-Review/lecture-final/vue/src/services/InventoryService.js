import axios from 'axios';

export default {

    getAllProducts() {
        return axios.get('/products');
    },
    getProductById(productId) {
        return axios.get(`/products/${productId}`);
    }
}