
import "./Nav.scss"
import { ThemeContext } from "../App";
import { useContext } from "react";
  export function Nav() {
    const {items,setSearchitem,setSearch}=useContext(ThemeContext)
    function updateSearch(event:any)
    {
      setSearch(event.target.value);
      const searchText = event.target.value.toLowerCase();
      const filteredItems = items.filter((itemName) =>
        itemName.toLowerCase().includes(searchText)
      );
      setSearchitem(filteredItems);
    }
  return (
    <div className="nav">
      <h1 className="Heading">Item Lister</h1>
      <input className="Search" type="text" onChange={updateSearch} placeholder="Search Item" />
    </div>
  )
}
