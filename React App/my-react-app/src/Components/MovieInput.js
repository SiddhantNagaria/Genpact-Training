import React, {/*useState*/} from 'react'

function MovieInput ({ addMovie }) {
  const [movieTitle, setMovieTitle] = React.useState('')
  const [movieGenre, setMovieGenre] = React.useState('')

  const handleChange = event => {
    setMovieTitle(event.target.value)
  }
  const handleChange2 = event => {
    setMovieGenre(event.target.value)
  }

  const handleSubmit = event => {
    event.preventDefault()
    if (movieTitle.trim() !== '' && movieGenre.trim() !== '') {
      addMovie(movieTitle)
      setMovieTitle('')
      setMovieGenre('')
    }
    alert(`Movie Submitted : ${movieTitle}`)
  }

  return (
    <form onSubmit={handleSubmit}>
      <input
        type='text'
        placeholder='Enter movie title'
        value={movieTitle}
        onChange={handleChange}
      />
      <input
        type='text'
        placeholder='Enter movie genre'
        value={movieGenre}
        onChange={handleChange2}
      />
      <button type='Submit'> Add Movie </button>
    </form>
  )
}

export default MovieInput
