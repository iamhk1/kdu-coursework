import '@testing-library/cypress/add-commands';

describe('Search functionality', () => {
  beforeEach(() => {
   
    cy.visit('http://localhost:5173');
    cy.findByTestId('inputbox').type('hey{enter}');
    cy.findByTestId('submitbtn').click(); 
    cy.findByTestId('inputbox').type('hi{enter}');
    cy.findByTestId('submitbtn').click(); 
    cy.findByTestId('inputbox').type('hello{enter}');
    cy.findByTestId('submitbtn').click();
  });

  it('searches for items', () => {
  
    cy.findByTestId('search-box').type('he');
    cy.findAllByTestId('todoitem').should('have.length', 2);
  });
});

describe('Removing an item', () => {
  beforeEach(() => {
    cy.visit('http://localhost:5173'); 
    cy.findByTestId('inputbox').type('hi{enter}');
    cy.findByTestId('submitbtn').click();
    cy.findByTestId('inputbox').type('hey{enter}');
    cy.findByTestId('submitbtn').click(); 
    cy.findByTestId('inputbox').type('hello{enter}');
    cy.findByTestId('submitbtn').click(); 
  });

  it('removes an item from the list', () => {

    cy.get('.cross').eq(2).click();

    cy.findAllByTestId('todoitem').should('have.length', 2);
  });
});


describe('Checkbox selection', () => {
  beforeEach(() => {
   
    cy.visit('http://localhost:5173');

    cy.findByTestId('inputbox').type('hi{enter}');
    cy.findByTestId('submitbtn').click(); 
    cy.findByTestId('inputbox').type('hello{enter}');
    cy.findByTestId('submitbtn').click();
    cy.findByTestId('inputbox').type('hey{enter}');
    cy.findByTestId('submitbtn').click(); 
    cy.findByTestId('inputbox').type('bye{enter}');
    cy.findByTestId('submitbtn').click(); 

    cy.get('[data-testid="checkbox"]').eq(0).check();
    cy.get('[data-testid="checkbox"]').eq(1).check();
    cy.get('[data-testid="checkbox"]').eq(2).check();
  });

  it('checks if length of checked items is 3', () => {
    cy.get('[data-testid="checkbox"]:checked').should('have.length', 3);
    cy.findByTestId('clearbtn').click();
    cy.get('[data-testid="checkbox"]').its('length').should('eq', 1);

  });
  it('checks if length of list after deleting the checked items', () => {
    cy.findByTestId('clearbtn').click();
    cy.get('[data-testid="checkbox"]').its('length').should('eq', 1);
    
  });
});
