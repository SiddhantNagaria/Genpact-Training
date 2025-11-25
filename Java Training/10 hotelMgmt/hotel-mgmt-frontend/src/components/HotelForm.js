// POST request
import React, { use, useState } from 'react'
import { addHotel } from '../services/hotelServices'
export default function HotelForm () {
  const [form, setForm] = useState({
    name: '',
    address: '',
    total_rooms: 1,
    available_rooms: 1,
    price_per_night: 0
  })
  const [loading, setLoading] = useState(false)
  const onChange = e => {
    const { name, value } = e.target
    setForm(prev => ({
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
      await addHotel(form)
      alert('Hotel Added successfully!')
      setForm({
        name: '',
        address: '',
        total_rooms: 1,
        available_rooms: 1,
        price_per_night: 0
      })
      // refresh the list
      window.location.reload()
    } catch (err) {
      alert('Failed to add hotel: ' + (err.message || err))
    } finally {
      setLoading(false)
    }
  }

  return (
    <div className='hotel-form'>
      <h2>Add Hotel</h2>
      <form onSubmit={onSubmit}>
        <label>
          Name
          <input name='name' value={form.name} onChange={onChange} required />
        </label>
        <label>
          Address
          <input
            name='address'
            value={form.address}
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
            value={form.total_rooms}
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
            value={form.available_rooms}
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
            value={form.price_per_night}
            onChange={onChange}
            required
          />
        </label>
        <button type='submit' disabled={loading}>
          {loading ? 'Saving...' : 'Save'}
        </button>
      </form>
    </div>
  )
}
