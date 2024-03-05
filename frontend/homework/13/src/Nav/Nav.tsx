import React, { useContext, useRef } from "react";
import { ThemeContext } from "../App";
import { useLocation } from "react-router-dom"; 

const navStyles = {
  height: "40px",
  width: "100%",
  display: "flex",
  alignItems: "center",
  justifyContent: "space-between",
  padding: "0px 40px",
  backgroundColor: "#2A2A72",
};
const others = {
  display: "flex",
  gap: "10px",
};
const select = {
  color: "#000",
  fontSize: "12px",
};
const labelStyle = {
  color: "#fff",
};
const svgstyle = {
  height: "10px",
  width: "10px",
};

export function Nav() {
  const {
    searchitem,
    setSearchitem,
    allproducts,
    filterans,
    setFilterans,
    sortoption,
    setSortoption,
  } = useContext(ThemeContext);
  const searchInputRef = useRef<HTMLInputElement>(null);
  const location = useLocation(); 
  const handleSearchButtonClick = () => {
    const searchValue = searchInputRef.current?.value.toLowerCase();
    const filteredProducts = allproducts.filter((product) =>
      product.title.toLowerCase().includes(searchValue!)
    );
    setSearchitem(filteredProducts);
  };

  const handleFilterChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    const selectedFilter = event.target.value;
    setFilterans(selectedFilter);
    if (selectedFilter == "1") {
      setSearchitem(allproducts);
    } else {
      const filteredProducts = allproducts.filter(
        (product) =>
          product.category.toLowerCase() === selectedFilter.toLowerCase()
      );
      setSearchitem(filteredProducts);
    }
  };

  const handleSortChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    const selectedSortOption = event.target.value;
    setSortoption(selectedSortOption);
    if (selectedSortOption === "1") {
      const sortedProducts = [...searchitem].sort((a, b) => a.price - b.price);
      setSearchitem(sortedProducts);
    } else if (selectedSortOption === "2") {
      const sortedProducts = [...searchitem].sort((a, b) => b.price - a.price);
      setSearchitem(sortedProducts);
    }
  };
  console.log(location.pathname, "pathname");
  return (
    <div style={navStyles} className="Nav">
      <div className="Search">
        <input type="text" ref={searchInputRef} className="Searchbox" />
        <button className="Searchbutton" onClick={handleSearchButtonClick}>
          <svg
            style={svgstyle}
            xmlns="http://www.w3.org/2000/svg"
            viewBox="0 0 24 24"
            fill="currentColor"
          >
            <path d="M18.031 16.6168L22.3137 20.8995L20.8995 22.3137L16.6168 18.031C15.0769 19.263 13.124 20 11 20C6.032 20 2 15.968 2 11C2 6.032 6.032 2 11 2C15.968 2 20 6.032 20 11C20 13.124 19.263 15.0769 18.031 16.6168ZM16.0247 15.8748C17.2475 14.6146 18 12.8956 18 11C18 7.1325 14.8675 4 11 4C7.1325 4 4 7.1325 4 11C4 14.8675 7.1325 18 11 18C12.8956 18 14.6146 17.2475 15.8748 16.0247L16.0247 15.8748Z"></path>
          </svg>
        </button>
      </div>

      {location.pathname === "/" && (
        <div className="others" style={others}>
          <label style={labelStyle} htmlFor="filter">
            Filter:
          </label>
          <select
            name="filter"
            id="filter"
            value={filterans}
            onChange={handleFilterChange}
          >
            <option style={select} value="1">
              Category
            </option>
            <option style={select} value="jewelery">
              jewelery
            </option>
            <option style={select} value="men's clothing">
              men's clothing
            </option>
            <option style={select} value="electronics">
              electronics
            </option>
          </select>

          <label style={labelStyle} htmlFor="sort">
            Sort:
          </label>
          <select
            name="sort"
            id="filter"
            value={sortoption}
            onChange={handleSortChange}
          >
            <option value="0"></option>
            <option value="1">Ascending</option>
            <option value="2">Descending</option>
          </select>
        </div>
      )}
    </div>
  );
}
