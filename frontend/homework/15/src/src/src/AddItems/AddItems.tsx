import "./AddItems.scss";
import { ThemeContext } from "../App";
import { useContext,useRef } from "react";
import { useDispatch } from 'react-redux'
import { addItem,removeChecked } from "../redux/ItemSlice";

export  function AddItems() {
  
  
  const inputRef = useRef<HTMLInputElement>(null
  );
 
  const reduxDispatch=useDispatch()
  const {item,setItem}=useContext(ThemeContext)
  function clearChecked()
  {
      reduxDispatch(removeChecked());
  }
    function itemName(event:React.ChangeEvent<HTMLInputElement>)
    {
        setItem(event.target.value)
    }
    function addNewItem()
    {
        console.log(item);
        if(item.trim().length>0)
        {
          reduxDispatch(addItem(item));

        }
        setItem('')
        inputRef.current!.value = '';
        
    }
  return (
    <div className="addItems">
      <h2>Add Items</h2>
    <div className="both">
    <div id="input">
    <input ref={inputRef} className="input" type="text" id="textInput" onChange={itemName}placeholder="Type here..."/>
        <button onClick={addNewItem}type="submit">Submit</button>
    </div>
    <div className="clearChecked">
      <button onClick={clearChecked}>Clear Checked</button>
    </div>
    </div>
    </div>
  )
}
