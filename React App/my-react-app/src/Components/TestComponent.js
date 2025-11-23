import React from 'react'

function TestComponent () {
  throw new Error('Test Component Created')
  return <div>Not Rendering</div>
}

export default TestComponent
