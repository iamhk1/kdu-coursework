import { useDispatch, useSelector } from 'react-redux'
import "./Nav.scss"
import { ThemeContext } from "../App";
import { useContext } from "react";
import { displayItems } from '../redux/SearchItemSlice';
import { RootState } from '../redux/Store';
  export function Nav() {

    const {setSearch}=useContext(ThemeContext)
    const items=useSelector((state:RootState)=>state.item.items);
    const reduxDispatch=useDispatch()
    function updateSearch(event:any)
    {
      setSearch(event.target.value);
      reduxDispatch(displayItems({ searchString: event.target.value, items: items }));
    }
    return (
    <div className="nav">
      <h1 className="Heading">Item Lister</h1>
      <input data-testid="search-box" className="Search" type="text" onChange={updateSearch} placeholder="Search Item" />
    </div>
  )
}
