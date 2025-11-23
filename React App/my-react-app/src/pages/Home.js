import React from 'react'
import MovieCard from '../Components/MovieCard'
import MovieInput from '../Components/MovieInput'
import { Link } from 'react-router-dom'

function Home () {
  const [movies, setMovies] = React.useState([
    { id: 1, title: 'Inception', genre: 'Sci-fi' },
    { id: 2, title: 'Harry Potter ', genre: 'Fiction' }
  ])

  const addMovie = (title, genre) => {
    const newMovie = {
      id: movies.length + 1,
      title,
      genre
    }
    setMovies([...movies, newMovie])
  }

  return (
    <div>
      <h1>Movie App</h1>
      <MovieInput addMovie={addMovie} />
      {movies.map(movie => (
        <div key={movie.id}>
          <MovieCard title={movie.title} genre={movie.genre} />
          <Link to={`/movies/${movie.id}`}> View Details </Link>
        </div>
      ))}
    </div>
  )
}

export default Home
