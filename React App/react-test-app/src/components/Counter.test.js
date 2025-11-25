// unit test file for counter component
import React from 'react'
import { render, screen } from '@testing-library/react'
import userEvent from '@testing-library/user-event'
import Counter from './Counter'

// render() -> render the component into a virtual DOM
// screen -> let you query elements by etxt, labels, role
// userEvent -> ssimulate real user interactions click, type
// Counter -> component taht we want to test

// describe block -> group all tests

describe('Counter component', () => {
  // Test 1 - Initial Render
  test('renders with initial value and buttons', () => {
    render(<Counter initial={3} />)
    expect(
      screen.getByRole('heading', { name: /counter/i })
    ).toBeInTheDocument()
    expect(screen.getByLabelText('count-value')).toHaveTextContent('Count : 3')
    expect(
      screen.getByRole('button', { name: /increment/i })
    ).toBeInTheDocument()
  })

  // Test 2 - Increment & Decrement
  test('increments and decrements the count', async () => {
    render(<Counter initial={1} />)
    const user = userEvent.setup() // create user instance that simluates click asynchronously
    const inc = screen.getByRole('button', { name: /increment/i })
    const dec = screen.getByRole('button', { name: /decrement/i })
    const value = screen.getByLabelText('count-value')

    await user.click(inc)
    expect(value).toHaveTextContent('Count : 2')

    await user.click(dec)
    await user.click(dec)
    expect(value).toHaveTextContent('Count : 0')
  })

  // Test 3 - Inc and reset
  // Initial value - 5
  // simulate inc - value - 6 expected
  // simulate reset - value - 5 expected
  test('reset button restore initial', async () => {
    render(<Counter initial={5} />)
    const user = userEvent.setup() // create user instance that simluates click asynchronously
    const inc = screen.getByRole('button', { name: /increment/i })
    const reset = screen.getByRole('button', { name: /reset/i })
    const value = screen.getByLabelText('count-value')

    await user.click(inc)
    expect(value).toHaveTextContent('Count : 6')

    await user.click(reset)
    expect(value).toHaveTextContent('Count : 5')
  })
})
