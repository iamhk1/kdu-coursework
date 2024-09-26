import "./AddItems.scss";
import { ThemeContext } from "../App";
import { useContext } from "react";
interface AddItemsProps {
    item: string;
    setItem: React.Dispatch<React.SetStateAction<string>>;
  }
export  function AddItems() {
  const { items,setItems,item,setItem}=useContext(ThemeContext)
    function itemName(event:any)
    {
        setItem(event.target.value)
    }
    function addNewItem(event:any)
    {
        console.log(item);
        if(item.trim().length>0)
        setItems([...items,item]);
        
    }
  return (
    <div className="addItems">
      <h2>Add Items</h2>
    <div id="input">
    <input className="input" type="text" id="textInput" onChange={itemName}placeholder="Type here..."/>
        <button onClick={addNewItem}type="submit">Submit</button>
    </div>
    </div>
  )
}

//rfc