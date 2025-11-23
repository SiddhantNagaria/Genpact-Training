import React, { Component } from 'react'


class MovieCardClass extends Component {
  constructor (props) {
    super(props)
    this.state = { watched: false }
  }

  toggleWatched = () => {
    this.setState({ watched: !this.state.watched })
  }

  render () {
    return (
      <div className='movie-card'>
        <h3 className='movie-title'>{this.props.title}</h3>
        <p className='movie-genre'>{this.props.genre}</p>
        <p className={this.state.watched ? 'watched' : 'not-watched'}>
          {this.state.watched ? 'Watched ' : 'Not Watched '}
        </p>
        <button className='watch-btn' onClick={this.toggleWatched}>
          {this.state.watched ? 'Mark Unwatched' : 'Mark Watched'}
        </button>
      </div>
    )
  }
}

export default MovieCardClass
