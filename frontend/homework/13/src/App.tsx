import { Product } from "./Types/Types";
import { Nav } from "./Nav/Nav";
import { createContext, useContext, useEffect, useState } from "react";
import { CenterHeading } from "./CenterHeading/CenterHeading";
import { CenterContent } from "./CenterContent/CenterContent";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { ProductDetail } from "./ProductDetail/ProductDetail";
export interface ItemInterface {
  searchitem: Product[];
  setSearchitem: React.Dispatch<React.SetStateAction<Product[]>>;
  search: string;
  setSearch: React.Dispatch<React.SetStateAction<string>>;
  filterans: string;
  setFilterans: React.Dispatch<React.SetStateAction<string>>;
  sortoption: string;
  setSortoption: React.Dispatch<React.SetStateAction<string>>;
  allproducts: Product[];
  setAllproducts: React.Dispatch<React.SetStateAction<Product[]>>;
}

export const ThemeContext = createContext<ItemInterface>({
  searchitem: [],
  setSearchitem: () => {},
  search: "",
  setSearch: () => {},
  filterans: "",
  setFilterans: () => {},
  sortoption: "",
  setSortoption: () => {},
  allproducts: [],
  setAllproducts: () => {},
});
export interface ThemeProvider {
  children: React.ReactNode;
}
export const ThemeProvider = ({ children }: ThemeProvider) => {
  const [searchitem, setSearchitem] = useState<Product[]>([]);
  const [search, setSearch] = useState<string>("");
  const [filterans, setFilterans] = useState<string>("");
  const [sortoption, setSortoption] = useState<string>("");
  const [allproducts, setAllproducts] = useState<Product[]>([]);
  return (
    <ThemeContext.Provider
      value={{
        searchitem,
        setSearchitem,
        search,
        setSearch,
        filterans,
        setFilterans,
        sortoption,
        setSortoption,
        allproducts,
        setAllproducts,
      }}
    >
      {children}
    </ThemeContext.Provider>
  );
};

function App() {
  const { setSearchitem, setAllproducts } = useContext(ThemeContext);
  useEffect(() => {
    fetch("https://fakestoreapi.com/products")
      .then((response) => response.json())
      .then((data: Product[]) => {
        console.log("data", data);
        setAllproducts(data);
        setSearchitem(data);
      });
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
