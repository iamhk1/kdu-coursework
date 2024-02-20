import "./AddItems.scss";
interface AddItemsProps {
    itemProp: {
      allItems: string[];
      set: React.Dispatch<React.SetStateAction<string[]>>;
    };
    item: string;
    addItem: React.Dispatch<React.SetStateAction<string>>;
  }
export  function AddItems({ itemProp, item, addItem }: AddItemsProps) {
    function itemName(event:any)
    {
        addItem(event.target.value)
    }
    function addNewItem(event:any)
    {
        console.log(item);
        if(item.trim().length>0)
        itemProp.set([...itemProp.allItems,item]);
        
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