import React, { useEffect, useReducer } from 'react'
import '../css/MovieCard.css'

function MovieCard ({ title, genre }) {
  //const [watched, setWatched] = useState(false);
  const initialState = { watched: false }
  const [state, dispatch] = useReducer(reducer, initialState)

  // useEffect
  useEffect(() => {
    console.log(`${title} watched: ${state.watched}`)
  }, [title, state.watched])

  function reducer (state, action) {
    switch (action.type) {
      case 'TOGGLE_WATCHED':
        return { ...state, watched: !state.watched }
      default:
        return state
    }
  }

  return (
    //<div className="movie-card">
    // <>
    <React.Fragment key={title}>
      <h3 className='movie-title'>{title}</h3>
      <p className='movie-genre'>{genre}</p>
      <p> {state.watched ? 'Watched' : 'Not Watched'}</p>
      {state.watched && <p> You have already seen this movie. </p>}
      <button onClick={() => dispatch({ type: 'TOGGLE_WATCHED' })}>
        {state.watched ? 'Mark as Unwatched' : 'Mark as Watched'}{' '}
      </button>
    </React.Fragment>
    //</div>

    // <div classname="movie-card">
    // h3 - movie title
  )
}

export default MovieCard

// {movies.map(movie => (
// <React.Fragment key={MovieCard.id}))}
