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
    cy.findByTestId('search-box').should('exist');
    cy.get('.Heading').should('have.text', 'Item Lister');
  })
})