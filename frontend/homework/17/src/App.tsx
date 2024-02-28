import { useEffect } from "react";
import "./App.css";
import { CenterContent } from "./CenterContent/CenterContent";
import { CenterHeading } from "./CenterHeading/CenterHeading";
import { useDispatch } from "react-redux";
import { getProducts } from "./redux/thunks/GetProducts";
import { AppDispatch } from "./redux/Store";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { Nav } from "./Nav/Nav";
import { ProductDetail } from "./ProductDetail/ProductDetail";
function App() {
  const reduxDispatch: AppDispatch = useDispatch();
  
  useEffect(() => {
    reduxDispatch(getProducts());
  }, []);

  return (
    <BrowserRouter>
      <Routes>
        <Route
          path="/"
          element={
            <>
            <Nav />
            <CenterHeading />
              <CenterContent />
              </>
          }
        />
        <Route
          path="/product/:id"
          element={
            <>
            <Nav />
            <CenterHeading />
              <ProductDetail />
              </>
          }
        />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
