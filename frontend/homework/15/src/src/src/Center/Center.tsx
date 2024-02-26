import "./center.scss"
import {AddItems} from "../AddItems/AddItems"
import {Items} from "../Items/Items"
export  function Center() {  
  return (
    <div className="center">
       <AddItems />
        <Items />
    </div>
  )
}

