import "./AddItems.scss";
import { ThemeContext } from "../App";
import { useContext,useEffect,useRef } from "react";
import { useDispatch, useSelector } from 'react-redux'
import { addItem,removeChecked } from "../redux/ItemSlice";
import { RootState } from "../redux/Store";

export  function AddItems() {
    
  const inputRef = useRef<HTMLInputElement>(null
  );
  const items = useSelector((state: RootState) => state.item.items);
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
        console.log(items);
        if(item.trim().length>0)
        {
          reduxDispatch(addItem(item));
          
        }
        setItem('')
        inputRef.current!.value = '';
        
    }
  useEffect(() => {
    localStorage.setItem('lists', JSON.stringify(items));
}, [items]);

  return (
    <div className="addItems">
      <h2>Add Items</h2>
    <div className="both">
    <div id="input">
    <input data-testid="inputbox"ref={inputRef} className="input" type="text" id="textInput" onChange={itemName}placeholder="Type here..."/>
        <button data-testid="submitbtn" onClick={addNewItem}type="submit">Submit</button>
    </div>
    <div className="clearChecked">
      <button data-testid="clearbtn" onClick={clearChecked}>Clear Checked</button>
    </div>
    </div>
    </div>
  )
}
