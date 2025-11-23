// CreateUserForm.jsx
import React, { useState } from 'react'
import api from '../Api'

function CreateUserForm({ onUserCreated = () => {} }) {
  const [name, setName] = useState('')
  const [email, setEmail] = useState('')
  const [saving, setSaving] = useState(false)
  const [error, setError] = useState(null)

  async function handleSubmit(e) {
    e.preventDefault()
    setSaving(true)
    setError(null)
    try {
      const payload = { name, email }
      const response = await api.post('/users', payload)
      onUserCreated(response.data)
      setName('')
      setEmail('')
    } catch (err) {
      const message =
        err.response?.data?.message || err.message || 'Failed to create User'
      setError(message)
    } finally {
      setSaving(false)
    }
  }

  return (
    <form onSubmit={handleSubmit}>
      <h3>Create User</h3>
      <div>
        <input
          placeholder="Name"
          value={name}
          onChange={e => setName(e.target.value)}
          required
        />
      </div>
      <div>
        <input
          placeholder="Email"
          type="email"
          value={email}
          onChange={e => setEmail(e.target.value)}
          required
        />
      </div>
      {error && <div style={{ color: 'red' }}>{error}</div>}
      <button type="submit" disabled={saving}>
        {saving ? 'Saving...' : 'Create'}
      </button>
    </form>
  )
}

export default CreateUserForm
