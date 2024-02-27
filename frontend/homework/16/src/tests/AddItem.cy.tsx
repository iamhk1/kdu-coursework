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
    cy.contains('Add Items').should('exist');
    cy.findByTestId('inputbox').should('exist');
    cy.findByTestId('submitbtn').should('exist');
    cy.findByTestId('clearbtn').should('exist');
  })
})