import React from 'react'
import {App} from '../../src/App'
import { Provider } from 'react-redux'
import { store } from '../../src/redux/Store'
import '@testing-library/cypress/add-commands';


describe('<Main />', () => {
  
  it('mounts', () => {
    cy.viewport(700, 700);
    cy.mount(
      <React.StrictMode>
      <Provider store={store}>
      <App />
      </Provider>
      </React.StrictMode>
    )

    const newItem = 'Test Item';
    cy.findByTestId('inputbox').type(newItem);
    cy.findByTestId('submitbtn').click();

    cy.findByTestId('todoitem').should('have.length', 1);

    cy.contains('Test Item').should('exist'); 
    
    cy.findByTestId('checkbox').should('exist');

  })
})