import React, { useState } from 'react'
import { useSelector, useDispatch } from 'react-redux'
import { increment, decrement, incrementByAmount, reset } from './counterSlice'

export default function Counter () {
  const count = useSelector(state => state.counter.value)
  const dispactch = useDispatch()
  const [amount, setAmount] = useState(5)
  return (
    <div>
      <h2>React Redux Toolkit Counter App</h2>
      <div style={{ fontSize: 48 }}>{count}</div>
      <div>
        <button onClick={() => dispactch(decrement())} aria-label='decrement'>
          -
        </button>
        <button onClick={() => dispactch(increment())} aria-label='increment'>
          +
        </button>
      </div>
      <div>
        <input
          type='number'
          value={amount}
          onChange={e => setAmount(Number(e.target.value))}
        />
        <button
          onClick={() => dispactch(incrementByAmount(Number(amount) || 0))}
        >
          Add Amount
        </button>
      </div>
      <div>
        <button onClick={()=>dispactch(reset())}>Reset</button>
      </div>
    </div>
  )
}
