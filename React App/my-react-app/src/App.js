import logo from './logo.svg'
import './App.css'
import First from './First'
import ClickBtn from './ClickBtn'
import Navbar from './Navbar'
import Header from './Header'
import MovieCard from './Components/MovieCard'
import MovieCardClass from './Components/MovieCardClass'

function App () {
  const movies = [
    { title: 'Inception', genre: 'Sci-Fi' },
    { title: 'Harry Poter', genre: 'Fiction' }
  ]

  return (
    <div className='App'>
      {/* <Navbar/>
      <Header/>
      <h1>Welcome to First React App</h1>
      <First name="Siddhant"/>
   <ClickBtn/> */}

      <h1>Movie App</h1>
      <h2>Functional Component</h2>
      {movies.map((movie, index) => (
        <MovieCard key={index} title={movie.title} genre={movie.genre} />
      ))}
      <h2>Class Component</h2>
      {movies.map((movie, index) => (
        <MovieCardClass key={index} title={movie.title} genre={movie.genre} />
      ))}
    </div>
  )
}

export default App
