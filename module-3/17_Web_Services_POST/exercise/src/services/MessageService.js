import axios from 'axios';
import { onUpdated } from 'vue';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  get(id) {
    return http.get(`/messages/${id}`);
  },

  create(message) {
    return http.post(`/messages`, message)
  },

  update(messageId, message) {
    return http.put(`/messages/${messageId}`, message)
  },

  delete(messageId) {
    return http.delete(`/messages/${messageId}`)
  }

}
