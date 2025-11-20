import React, { Component } from 'react'

export default class MovieCardClass extends Component {
  constructor (props) {
    super(props);
    this.state = { watched: false }
    console.log('Constructor: MovieCardClass')
  }
  componentDidMount () {
    console.log('Component Mounted')
  }
  componentDidUpdate (prevProps, prevState) {
    console.log('Component Updated')
  }
  componentWillUnmount () {
    console.log('Component will unmount')
  }
  render () {
    return (
      <div style={{ border: '1 px solid blue', margin: '5px', padding: '5px' }}>
        <h3>{this.props.title}</h3>
        <h3>{this.props.genre}</h3>
        <h3>{this.state.watched ? 'watched' : 'Not Watched'}</h3>
      </div>
    )
  }
}
