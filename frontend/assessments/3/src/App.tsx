import { useEffect } from 'react';
import './App.css'
import { AppDispatch, RootState } from './redux/Store';
import { useDispatch, useSelector } from 'react-redux';
import { getProducts } from './redux/thunk/GetProducts';
import { Info } from './Info';

function App() {

  const reduxDispatch: AppDispatch = useDispatch();
  const state = useSelector((state: RootState) => state.product.state);
  useEffect(() => {
    reduxDispatch(getProducts());
  }, []);
  if (state === "pending") {
    return (
      <>Pending</>
    );
  }
  if(state==="rejected")
  {
    return <>Rejected</>
  }
  return(
    <Info />
  )
}

export default App
