// allowing users to edit an existing hotel
// handling PUT request
// HotelList -> send hotel data to edit

import React, { useEffect, useState } from 'react'
import { updateHotel } from '../services/hotelServices'

export default function HotelEditForm () {
  const [hotel, setHotel] = useState(null)
  const [loading, setLoading] = useState(false)

  // Listen for "edit-hotel" event from HotelList
  // this listens for that event
  // once eevnt is received -> update the hotel state with selected hotel data
  useEffect(() => {
    const listener = e => {
      setHotel(e.detail)
    }
    window.addEventListener('edit-hotel', listener)
    return () => window.removeEventListener('edit-hotel', listener)
  }, [])

  if (!hotel) return <p>Select a hotel to edit</p>

  const onChange = e => {
    const { name, value } = e.target
    setHotel(prev => ({
      ...prev,
      [name]:
        name === 'total_rooms' ||
        name === 'available_rooms' ||
        name === 'price_per_night'
          ? Number(value)
          : value
    }))
  }

  const onSubmit = async e => {
    e.preventDefault()
    setLoading(true)
    try {
      await updateHotel(hotel.id, hotel)
      alert('Hotel Updated successfully!')
      // refresh the list
      window.location.reload()
    } catch (err) {
      alert('Update Failed : ' + (err.message || err))
    } finally {
      setLoading(false)
    }
  }
  return (
    <div className='hotel-form'>
      <h2>Edit Hotel</h2>
      <form onSubmit={onSubmit}>
        <label>
          Name
          <input name='name' value={hotel.name} onChange={onChange} required />
        </label>
        <label>
          Address
          <input
            name='address'
            value={hotel.address}
            onChange={onChange}
            required
          />
        </label>
        <label>
          Total Rooms
          <input
            name='total_rooms'
            type='number'
            min='1'
            value={hotel.total_rooms}
            onChange={onChange}
            required
          />
        </label>
        <label>
          Available Rooms
          <input
            name='available_rooms'
            type='number'
            min='0'
            value={hotel.available_rooms}
            onChange={onChange}
            required
          />
        </label>
        <label>
          Price/Night
          <input
            name='price_per_night'
            type='number'
            min='0'
            value={hotel.price_per_night}
            onChange={onChange}
            required
          />
        </label>
        <button type='submit' disabled={loading}>
          {loading ? 'Updating...' : 'Update'}
        </button>
      </form>
    </div>
  )
}
