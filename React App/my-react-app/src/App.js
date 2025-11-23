// import './App.css'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import Navbar from './Components/Navbar'
import Home from './pages/Home'
import About from './pages/About'
import MovieDetails from './pages/MovieDetails'
import React, { useState } from 'react'
import CreateUserForm from './Components/CreateUserForm'
import UsersList from './Components/UsersList'
import ErrorBoundary from './Components/ErrorBoundary'
import TestComponent from './Components/TestComponent'
import Counter from './features/counter/Counter'

function App () {
  // return (
  //   <Router>
  //     <Navbar />
  //       <Routes>
  //         <Route path="/" element={<Home />} />
  //         <Route path="/about" element={<About />} />
  //         <Route path="/movies/:movieId" element={<MovieDetails />} />
  //       </Routes>
  //   </Router>

  // );

  // const [newUsers, setNewUsers] = useState([])

  // function handleUserCreated (user) {
  //   setNewUsers(prev => [user, ...prev])
  //   alert(`User Created : ${user.name} (id ${user.id})`)
  // }
  // return (
  //   <div>
  //     <h1>React Axios - Users fetching</h1>
  //     <CreateUserForm onUserCreated={handleUserCreated} />
  //     <br />
  //     <br />
  //     <br />
  //     <br />
  //     <UsersList />
  //     {newUsers.length > 0 && (
  //       <div>
  //         <h3>Recently created (local)</h3>
  //         <ul>
  //           {newUsers.map(u => (
  //             <li key={u.id}>
  //               {u.name} - <small>{u.email}</small>
  //             </li>
  //           ))}
  //         </ul>
  //       </div>
  //     )}
  //   </div>
  // )


  // return(
  //   <div>
  //     <h1>ErrorBoundary Handling</h1>
  //     <ErrorBoundary>
  //       <TestComponent/>
  //     </ErrorBoundary>
  //   </div>
  // )


  return (
    <div>
      <Counter/>
    </div>
  )
}

export default App
