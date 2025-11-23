// UsersList.jsx
import React, { useState, useEffect } from 'react'
import Api from '../Api'

function UsersList() {
  const [users, setUsers] = useState([])
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState(null)

  useEffect(() => {
    const controller = new AbortController()
    const signal = controller.signal

    async function fetchUsers() {
      setLoading(true)
      setError(null)
      try {
        const response = await Api.get('/users', { signal })
        setUsers(response.data || [])
      } catch (err) {
        if (err.name === 'CanceledError' || err.message === 'canceled') {
          console.log('Request Cancelled')
        } else {
          const message =
            err.response?.data?.message ||
            err.response?.statusText ||
            err.message ||
            'Unknown Error'
          setError(message)
        }
      } finally {
        setLoading(false)
      }
    }

    fetchUsers()
    return () => {
      controller.abort()
    }
  }, [])

  if (loading) return <div>Loading Users ....</div>
  if (error) return <div style={{ color: 'red' }}>Error: {error}</div>

  return (
    <div>
      <h2>Users</h2>
      <ul>
        {users.map((u, index) => (
          <li key={u.id ?? `${u.name}-${u.email}-${index}`}>
            {u.name} - <small>{u.email}</small>
          </li>
        ))}
      </ul>
    </div>
  )
}

export default UsersList;