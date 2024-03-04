import { createContext, useState } from "react"
import {Nav} from "./Nav/Nav"
import {Center} from "./Center/Center"

import "./App.css"
interface ItemInterface{
   search:string,
   item:string,
   setSearch:React.Dispatch<React.SetStateAction<string>>,
   setItem:React.Dispatch<React.SetStateAction<string>>
}
export const ThemeContext = createContext<ItemInterface>({
  search:"",
  item:"",
  setSearch:()=>{},
  setItem:()=>{}
});
export interface ThemeProvider {
  children: React.ReactNode;
}
export const ThemeProvider = ({ children }: ThemeProvider) => {
  const[search,setSearch]=useState<string>(
    ""
  )
  const [item, setItem] = useState<string>(
    ''
    );
  return (
    <ThemeContext.Provider value={{search,item,setSearch,setItem}}>
      {children}
    </ThemeContext.Provider>
  );
};

export function App()
{
  return(
  <ThemeProvider>
    <Nav />
    <Center />
  </ThemeProvider>
  )
}
export default App;