import { Provider } from "react-redux"
import{store} from"../redux/Store"
import { render, screen,fireEvent } from '@testing-library/react'
import App from"../App"
import { test,describe, it, expect } from 'vitest'

test('title test',()=>{
  const{getByText}=render(
    <Provider store={store}>
      <App />
    </Provider> 
  )
  expect(getByText("Item Lister")).not.toBeNull();
})
  test('title test',()=>{
    const{getByText}=render(
      <Provider store={store}>
        <App />
      </Provider> 
    )
    expect(getByText("Add Items")).not.toBeNull();

  })
  test('title test',()=>{
    const{getByText}=render(
      <Provider store={store}>
        <App />
      </Provider> 
    )
    expect(getByText("Items")).not.toBeNull();
  })

  test('search box ',()=>{
    const{getByTestId}=render(
      <Provider store={store}>
        <App />
      </Provider> 
    )
    expect(getByTestId("search-box")).not.toBeNull();
    const searchbox= screen.getByTestId('search-box');
    fireEvent.change(searchbox, {target: {value: 'y'}})
    expect(getByTestId('search-box').value).toBe('y');
  })

  
  test('submit button ',()=>{
    const{getByTestId}=render(
      <Provider store={store}>
        <App />
      </Provider> 
    )
    expect(getByTestId("submitbtn").click('submitbtn'));
    
  })

  test('clear button ',()=>{
    const{getByTestId}=render(
      <Provider store={store}>
        <App />
      </Provider> 
    )
    expect(getByTestId("clearbtn").click('clearbtn'));
  })
  test("new task",()=>{
    const{getByTestId}=render(
      <Provider store={store}>
        <App />
      </Provider> 
    )
    const button= screen.getByTestId('submitbtn');
    const inp= screen.getByTestId('inputbox');
    fireEvent.change(inp, {target: {value: 'hello'}})

    fireEvent.click(button);
    expect(getByTestId("todoitem")).not.toBeNull();
  })

  test("search item",()=>{
    const{queryByTestId}=render(
      <Provider store={store}>
        <App />
      </Provider> 
    )
    const searchbox= screen.getByTestId('search-box');
     const button= screen.getByTestId('submitbtn');
    const inp= screen.getByTestId('inputbox');
    fireEvent.change(inp, {target: {value: 'hello'}})
    fireEvent.click(button);

    fireEvent.change(searchbox, {target: {value: 'y'}})
    expect(queryByTestId("todoitem")).toBeNull();
  })

  test("checkbox",()=>{
    const{queryAllByTestId}=render(
      <Provider store={store}>
        <App />
      </Provider> 
    )
    const button= screen.getByTestId('submitbtn');
    const inp= screen.getByTestId('inputbox');
    fireEvent.change(inp, {target: {value: 'hello'}})
    fireEvent.click(button);
    expect(queryAllByTestId("checkbox")).not.toBeNull();
  })