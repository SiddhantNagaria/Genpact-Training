import React from 'react'

export default function Counter ({ initial = 0 }) {
  const [count, setCount] = React.useState(initial)

  return (
    <div>
      <h1>Counter</h1>
      <p aria-label='count-value'>Count : {count}</p>
      <div>
        <button onClick={() => setCount(c => c + 1)}>Increment</button>
        <button onClick={() => setCount(c => c - 1)}>Decrement</button>
        <button onClick={() => setCount(initial)}>Reset</button>
      </div>
    </div>
  )
}
