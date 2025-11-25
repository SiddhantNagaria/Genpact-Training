import './App.css'
import React from 'react'
import { Routes, Route, Link } from 'react-router-dom'
import Counter from './components/Counter'
import FetchUsers from './components/FetchUsers'
import Home from './components/Home'

function App () {
  return (
    <div>
      <nav>
        <Link to='/'>Home</Link>
        <Link to='/counter'>Counter</Link>
        <Link to='/users'>Users</Link>
      </nav>
      <br />
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/counter' element={<Counter initial={0} />} />
        <Route path='/users' element={<FetchUsers />} />
      </Routes>
    </div>
  )
}

export default App
