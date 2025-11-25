// integration test suite
// testing entire APp
// Routing
// User interaction
// Component Comunication
// Fetch API calls
// Success & error handling
 
import React from 'react';
import { render, screen, waitFor } from "@testing-library/react";
// waitFor -> for async event Fetch()
import userEvent from '@testing-library/user-event';
import { MemoryRouter } from 'react-router-dom';
import App from '../App';
 
describe('App Integration Testing', () => {
    const realFetch = global.fetch; //Save the real fetch
 
    // Before -> Each Test -> restore original fetch
    beforeEach( () => {
        global.fetch = realFetch;
    });
    // After -> Each Test -> cleanup mocks
    afterEach( () => {
        global.fetch = realFetch;
        jest.restoreAllMocks();
    });
    // Prevent one test mock from affecting others
 
    test('navigate to counter, increment, then navigate to users and show fetched list', async () => {
     jest.spyOn(global, 'fetch').mockResolvedValue( {
        ok: true,
        json: async () => [
            { id:1, name: 'ABC'},
            { id:2, name: 'DEF' },
        ]
    });
    render (
        <MemoryRouter initialEntries={['/']}>
           <App />
        </MemoryRouter>
    );
    // on Home
    expect(await screen.getByRole('heading', { name: /home/i })).toBeInTheDocument();
 
    // navigate to counter
    const user = userEvent.setup();
    await user.click(screen.getByRole('link', {name: /counter/i}));
 
    // Counter should be visible
    // screen heading - Counter
    // inc value -> text content 0
    expect(screen.getByRole('heading', {name: /counter/i})).toBeInTheDocument();
    const incBtn = screen.getByRole('button', { name: /increment/i});
    const value = screen.getByLabelText('count-value');
    expect(value).toHaveTextContent('Count : 0');
 
    // Increment Twice
    await user.click(incBtn);
    await user.click(incBtn);
    expect(value).toHaveTextContent('Count : 2');
 
    // navigate to Users
    await user.click(screen.getByRole('link', {name: /users/i}));
 
    const usersHeading = await screen.findByRole('heading',  {name: /users/i});
    expect(usersHeading).toBeInTheDocument();
 
    // loading appears first
    //expect(await screen.findByText(/loading users/i)).toBeInTheDocument();
    // wait for users to appear
    //await waitFor( () => expect(screen.getByRole('heading', { name: /users/i}))).toBeInTheDocument();
   
    const list = await screen.getByLabelText('users-list');
    expect(list).toBeInTheDocument();
    expect(screen.getByText('ABC')).toBeInTheDocument();
    expect(screen.getByText('DEF')).toBeInTheDocument();
 
    // ensure fetch was called for the endpoint
    expect(global.fetch).toHaveBeenCalledWith('https://jsonplaceholder.typicode.com/users');
    });
 
    // Error Handling Test
    test('shows error message when fetch fails', async () => {
        jest.spyOn(global, 'fetch').mockRejectedValue(new Error('network fail'));
        render (
        <MemoryRouter initialEntries={['/users']}>
           <App />
        </MemoryRouter>
        );
        //show loading, then error
        expect(await screen.findByText(/loading users/i)).toBeInTheDocument();
        await waitFor( () => expect(screen.getByRole('alert')).toBeInTheDocument());
        expect(screen.getByRole('alert')).toHaveTextContent(/Error/i);
    });    
 
});
 