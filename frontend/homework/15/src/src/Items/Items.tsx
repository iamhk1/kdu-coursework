// import "./Items.scss"
// import { ThemeContext } from "../App";
// import { useContext } from "react";
// import { useDispatch, useSelector } from 'react-redux'
// import { deleteItem,toggleCheck } from "../redux/ItemSlice";
// import { RootState } from "../redux/Store";
// export  function Items() {
//   const {search}=useContext(ThemeContext)
//   const searchItem=useSelector((state:RootState)=>state.searchItem.searchItems)
//   const items=useSelector((state:RootState)=>state.item.items);
//   const checked=useSelector((state:RootState)=>state.item.checked);
//   const reduxDispatch=useDispatch()
//     function deleteEntry(index:number)
//     {
//         reduxDispatch(deleteItem(index))
        
//     }
//     function handleCheckboxChange(index:number)
//     {
//         reduxDispatch(toggleCheck(index));
//     }
//  return (
//   <div className="allItems">
//     <h2>Items</h2>
//     <div className="Items">
//     {search.trim().length > 0 && (
//       <div>
//         {searchItem.length === 0 ? (
//           <p>No matching results</p>
//         ) : (
//           searchItem.map((item, index) => (
//             <div className="each-item" key={index}>
//             <p>{item}<input type="checkbox"   onChange={() => handleCheckboxChange(index)} /></p>
//             <div className="cross" onClick={() => deleteEntry(index)}>
//               <p key={index}>X</p>
//             </div>
//           </div>
//           ))
//         )}
//       </div>
//     )}
//     </div> 
//     <div className="Items">
//     {
//     search.trim().length === 0 &&
//     <div>
//     {
//       items.map((item, index) => (
//       <div className="each-item" key={index}>
//       <p>{item}<input type="checkbox"   onChange={() => handleCheckboxChange(index)} /></p>
//       <div className="cross" onClick={() => deleteEntry(index)}>
//         <p>X</p>
//       </div>
//     </div>
//     ))
//     }
//     </div>
//   }
//   </div>
// </div>
// )
// }


import "./Items.scss";
import { ThemeContext } from "../App";
import { useContext } from "react";
import { useDispatch, useSelector } from "react-redux";
import { deleteItem, toggleCheck } from "../redux/ItemSlice";
import { RootState } from "../redux/Store";

export function Items() {
  const { search } = useContext(ThemeContext);
  const searchItem = useSelector((state: RootState) => state.searchItem.searchItems);
  const items = useSelector((state: RootState) => state.item.items);
  const checked = useSelector((state: RootState) => state.item.checked);
  const reduxDispatch = useDispatch();

  function deleteEntry(index: number) {
    reduxDispatch(deleteItem(index));
  }

  function handleCheckboxChange(index: number) {
    reduxDispatch(toggleCheck(index));
  }

  return (
    <div className="allItems">
      <h2>Items</h2>
      <div className="Items">
        {search.trim().length > 0 && (
          <div>
            {searchItem.length === 0 ? (
              <p>No matching results</p>
            ) : (
              searchItem.map((item, index) => (
                <div className="each-item" key={index}>
                  <div className="item">
                  <p className={checked[index] ? "strike-through" : "" }>
                    {item}
                   
                  </p>
                  <input
                    className="checkbox"
                      type="checkbox"
                      onChange={() => handleCheckboxChange(index)}
                      checked={checked[index]} // Set checked attribute based on the value in the 'checked' array
                    />
                  </div>
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
        {search.trim().length === 0 && (
          <div>
            {items.map((item, index) => (
              <div className="each-item" key={index}>
                <div className="item">
                <p className={checked[index] ? "strike-through" : ""}>
                  {item}
                 
                </p>
                <input
                    className="checkbox"
                    type="checkbox"
                    onChange={() => handleCheckboxChange(index)}
                    checked={checked[index]}
                  />
                </div>
                <div className="cross" onClick={() => deleteEntry(index)}>
                  <p>X</p>
                </div>
              </div>
            ))}
          </div>
        )}
      </div>
    </div>
  );
}
