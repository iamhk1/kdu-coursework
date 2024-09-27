
import "./Nav.scss"
interface NavProps {
  item: string[]; 
  settingItem: React.Dispatch<React.SetStateAction<string[]>>; 
  sitem: string[]; 
  searchingItem: React.Dispatch<React.SetStateAction<string[]>>; 
}

export function Nav({ item, settingItem, sitem,searchingItem  }: NavProps) {
    function updateSearch(event:any)
    {
      const searchText = event.target.value.toLowerCase();
      const filteredItems = item.filter((itemName) =>
        itemName.toLowerCase().includes(searchText)
      );
      searchingItem(filteredItems);
    }
  return (
    <div className="nav">
      <h1 className="Heading">Item Lister</h1>
      <input className="Search" type="text" onChange={updateSearch} placeholder="Search Item" />
    </div>
  )
}
