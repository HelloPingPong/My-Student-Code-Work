import axios from 'axios';

const productsApi = axios.create({
    baseURL: 'http://localhost:8080'
});

export default {

    getAllProducts() {
        return productsApi.get('/products');
    },
    getProductById(productId) {
        return productsApi.get(`/products/${productId}`);
    },
    updateReview(review) {
        return productsApi.put(`/reviews/${review.id}`, review);
    },
    addReview(review, productId) {
        const url = `/products/${productId}/reviews`;
        return productsApi.post(url, review);
    },
    deleteReview(reviewId) {
        return productsApi.delete(`/reviews/${reviewId}`);
    },
    getReviewById(reviewId) {
        return productsApi.get(`/reviews/${reviewId}`);
    }

}