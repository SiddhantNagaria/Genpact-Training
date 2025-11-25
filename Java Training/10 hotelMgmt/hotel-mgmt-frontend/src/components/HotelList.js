// Will be responsible - fetching all hotels
// searching hotels, delete hotels, display list
// edit hotel (update) - trigger edit action
// Layout - list -> edit
// |_________| SEARCH
// Seaview  EDIT DELETE

import React, { useEffect, useState } from 'react'
import {
  getAllHotels,
  deleteHotel,
  searchHotelByName
} from '../services/hotelServices'

export default function HotelList () {
  const [hotels, setHotels] = useState([])
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState(null)
  const [query, setQuery] = useState('') // for search input box

  // Load All Hotels
  const loadHotels = async () => {
    setLoading(true)
    setError(null)
    try {
      const res = await getAllHotels()
      setHotels(res.data || [])
    } catch (e) {
      setError(e.message || 'Failed to load Hotels')
    } finally {
      setLoading(false)
    }
  }

  // useEffect -> Page Loads - Load all Hotels
  useEffect(() => {
    loadHotels()
  }, [])

  // handle delete
  const handleDelete = async id => {
    if (!window.confirm('Delete this hotel?')) return
    try {
      await deleteHotel(id)
      setHotels(prev => prev.filter(h => h.id !== id))
    } catch (e) {
      alert('Delete failed : ' + (e.message || e))
    }
  }

  // handle search
  const handleSearch = async e => {
    e.preventDefault() // prevent page refresh
    setLoading(true)
    setError(null)
    try {
      const res = await searchHotelByName(query)
      setHotels(res.data || [])
    } catch (e) {
      setError(e.message || 'Search failed.')
    } finally {
      setLoading(false)
    }
  }

  // Trigger edit -> send hotel data via custom event
  // broadcasting the hotel data to the form component so that update form
  // can hve prefill the fields (original values)
  // allow editing
  // Seaview EDIT - click -> EDIT Form will open - prefill fields for Seaview Hotel
  const onEdit = hotel => {
    window.dispatchEvent(new CustomEvent('edit-hotel', { detail: hotel }))
  }

  // UI Layout
  return (
    <div className='hotel-list'>
      {/* Search Bar */}
      <div className='search'>
        <form onSubmit={handleSearch}>
          <input
            value={query}
            onChange={e => setQuery(e.target.value)}
            placeholder='Search by name...'
          />
          <button type='submit'>Search</button>
          <button
            type='button'
            onClick={() => {
              setQuery('')
              loadHotels()
            }}
          >
            Reset
          </button>
        </form>
      </div>
      {/* Loading/Error */}
      {loading && <p> Loading...</p>}
      {error && <p className='error'>{error}</p>}
      {/* Hotel List */}
      <ul>
        {hotels.length === 0 && !loading ? (
          <li>No Hotels Found.</li>
        ) : (
          hotels.map(h => (
            <li key={h.id} className='hotel-item'>
              <div className='info'>
                <h3>{h.name}</h3>
                <p>{h.address}</p>
                <p>
                  Rooms: {h.available_rooms} / {h.total_rooms}
                </p>
                <p>Price/Nihgt: Rs.{h.price_per_night}</p>
              </div>
              <div className='actions'>
                <button
                  onClick={() => onEdit(h)}
                  style={{ marginRight: '10px' }}
                >
                  EDIT
                </button>
                <button onClick={() => handleDelete(h.id)}>DELETE</button>
              </div>
            </li>
          ))
        )}
      </ul>
    </div>
  )
}
