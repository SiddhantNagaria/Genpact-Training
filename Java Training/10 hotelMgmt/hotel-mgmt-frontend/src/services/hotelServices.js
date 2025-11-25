// This file will be responsible for connecting your React frontend to SB backend
// use Axios - library used to make HTTP calls-GET,PUT,POST,DELETE

import axios from 'axios'
const BASE_URL = '/api/hotels'
// axios call -> /api/hotels
// React send request -> Proxy forward -> http://localhost:8989/api/hotels

// Get all Hotels
export const getAllHotels = () => {
  return axios.get(BASE_URL)
  // call GET request : http://localhost:8989/api/hotels
  // Return all hotels from DB
}

// Get hotel by ID
export const getHotelById = id => {
  return axios.get(`${BASE_URL}/${id}`)
  // http://localhost:8989/api/hotels/2
  // GET/api/hotels/{id}
}

// Add new Hotel - POST
export const addHotel = hotel => {
  return axios.post(BASE_URL, hotel)
  // from the form take values
  // send hotel JSON body
}

// Update Hotel (PUT)
export const updateHotel = (id, hotel) => {
  return axios.put(`${BASE_URL}/${id}`, hotel)
  //send updated hotel object
}

// Delete Hotel
export const deleteHotel = id => {
  return axios.delete(`${BASE_URL}/${id}`)
}

// Search Hotel by Name
export const searchHotelByName = name => {
  return axios.get(`${BASE_URL}/search?name=${name}`)
}
