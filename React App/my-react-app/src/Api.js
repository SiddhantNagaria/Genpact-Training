// central axios instance

import axios from 'axios'

const api = axios.create({
  baseURL: 'https://jsonplaceholder.typicode.com',
  timeout: 10000,
  headers: {
    'Content-Type': 'application/json'
  }
})

// executes before every API, request is sent
// attach some custom headers
// to attach auth tokens
// to load request details
api.interceptors.request.use(
  config => {
    return config
  },
  error => Promise.reject(error)
)

// response interceptor - executes after API responds
// before your component receives data
api.interceptors.response.use(
  response => {
    return response
  },
  error => Promise.reject(error)
);

export default api;
