import "./Items.scss"
import { ThemeContext } from "../App";
import { useContext } from "react";
export  function Items() {
  const {items,searchitem,search,setItems}=useContext(ThemeContext)
    function deleteEntry(index:number)
    {
        const updatedItems = [...items];
        updatedItems.splice(index, 1);
        setItems(updatedItems);   
    }
  return (
    <div className="allItems">
      <h2>Items</h2>
      <div className="Items">
      {search.trim().length > 0 && (
        <div>
          {searchitem.length === 0 ? (
            <p>No matching results</p>
          ) : (
            searchitem.map((item, index) => (
              <div className="each-item" key={index}>
              <p>{item}</p>
              <div className="cross" onClick={() => deleteEntry(index)}>
                <p key={index}>X</p>
              </div>
            </div>
            ))
          )}
        </div>
      )}
      </div> 
      <div className="Items">
      {
      search.trim().length === 0 &&
      <div>
      {
        items.map((item, index) => (
        <div className="each-item" key={index}>
        <p>{item}</p>
        <div className="cross" onClick={() => deleteEntry(index)}>
          <p key={index}>X</p>
        </div>
      </div>
      ))
      }
      </div>
    }
    </div>
  </div>
  )
}
