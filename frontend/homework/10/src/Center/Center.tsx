import { useState } from "react";
import "./center.scss"
import {AddItems} from "../AddItems/AddItems"
import {Items} from "../Items/Items"
interface itemProp{
  allItems:string[],
  set: React.Dispatch<React.SetStateAction<string[]>>
  allSearchItems:string[],
  searchItems:React.Dispatch<React.SetStateAction<string[]>>
}

export  function Center({allItems,set,allSearchItems,searchItems}:itemProp) {
  const [item, addItem] = useState('');
  
  return (
    <div className="center">
       <AddItems itemProp={{ allItems, set }} item={item} addItem={addItem} />
      <Items itemsProp={{allItems,set,allSearchItems,searchItems}} />
    </div>
  )
}

