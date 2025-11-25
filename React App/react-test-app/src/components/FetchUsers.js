import React from 'react'

export default function FetchUsers () {
  const [users, setUsers] = React.useState(null)
  const [loading, setLoading] = React.useState(false)
  const [error, setError] = React.useState(null)

  React.useEffect(() => {
    let mounted = true
    async function load () {
      setLoading(true)
      setError(null)
      try {
        const res = await fetch('https://jsonplaceholder.typicode.com/users')
        if (!res.ok) throw new Error('API Error')
        const data = await res.json()
        if (mounted) setUsers(data)
      } catch (err) {
        if (mounted) setError(err.message || 'Failed')
      } finally {
        if (mounted) setLoading(false)
      }
    }
    load()
    return () => {
      mounted = false
    }
  }, [])

  if (loading) return <p>Loading Users...</p>
  if (error) return <p role='alert'> Error : {error}</p>
  if (!users) return <p> No Users.</p>

  return (
    <div>
      <h1>Users</h1>
      <ul aria-label='users-list'>
        {users.map(u => (
          <li key={u.id}>{u.name}</li>
        ))}
      </ul>
    </div>
  )
}
