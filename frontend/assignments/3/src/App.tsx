import { useDispatch } from 'react-redux';
import './App.css'
import{Home} from"./Component/Home"
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import { useEffect } from 'react';
import { getStocks } from './redux/thunk/GetStocks';
import { AppDispatch } from './redux/Store';
import { Nav } from './Component/Nav'
import { Stock } from './Component/Stock';
import { Portfolio } from './Component/Portfolio';
import { getTransactions } from './redux/thunk/GetTransaction';
function App() {
  const reduxDispatch: AppDispatch = useDispatch();
  
  useEffect(() => {
    reduxDispatch(getTransactions());
  }, []);
  useEffect(() => {
    reduxDispatch(getStocks());
  }, []);
  return (
    <BrowserRouter>
      <Nav />
    <Routes>
      <Route path='/' element={<Home />} />
      <Route
          path="/stock-details/:symbol"
          element={
            <>
              <Stock />
            </>
          }
        />
      <Route 
      path="/portfolio" 
      element={
        <>
          <Portfolio />
        </>
      }
      />
    </Routes>
    </BrowserRouter>
  )
}

export default App