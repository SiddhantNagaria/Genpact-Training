import { render, screen } from '@testing-library/react'
import App from './App'
import { MemoryRouter } from 'react-router-dom'
import { Routes, Route, Link } from 'react-router-dom'

// it uses memoryRouter
// Jest = routing cannot run in a real browser inside Jest
// use MemoryRouter to simulate routes during tests

//Test 1 : should show home page when visiting /
//Pretend the user is visiting "/" route
//App.js - match path = "/"
test('renders home page test', () => {
  render(
    <MemoryRouter initialEntries={['/']}>
      <App />
    </MemoryRouter>
  )
  expect(screen.getByRole('heading', { name: /home/i })).toBeInTheDocument()
})

test('navigates to counter route', () => {
  render(
    <MemoryRouter initialEntries={['/counter']}>
      <App />
    </MemoryRouter>
  )
  expect(screen.getByRole('heading', { name: /counter/i })).toBeInTheDocument()
})
