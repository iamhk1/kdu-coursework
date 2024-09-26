import { createContext, useState } from "react"
import {Nav} from "./Nav/Nav"
import {Center} from "./Center/Center"
import "./App.scss"
interface ItemInterface{
   
   items:string[],
   searchitem:string[],
   search:string,
   item:string,
   setItems:React.Dispatch<React.SetStateAction<string[]>>,
   setSearchitem:React.Dispatch<React.SetStateAction<string[]>>,
   setSearch:React.Dispatch<React.SetStateAction<string>>,
   setItem:React.Dispatch<React.SetStateAction<string>>
}
export const ThemeContext = createContext<ItemInterface>({
  items:[],
  searchitem:[],
  search:"",
  item:"",
  setItems:()=>{},
  setSearchitem:()=>{},
  setSearch:()=>{},
  setItem:()=>{}
});
export interface ThemeProvider {
  children: React.ReactNode;
}
export const ThemeProvider = ({ children }: ThemeProvider) => {
  const [items,setItems]=useState<string[]>(
    []
  )
  const [searchitem,setSearchitem]=useState<string[]>(
    []
  )
  const[search,setSearch]=useState<string>(
    ""
  )
  const [item, setItem] = useState<string>(
    ''
    );
  return (
    <ThemeContext.Provider value={{items,searchitem,search,item,setItems,setSearchitem,setSearch,setItem}}>
      {children}
    </ThemeContext.Provider>
  );
};

export function App()
{
  return(
  <>
  <ThemeProvider>
    <Nav />
    <Center />
  </ThemeProvider>
  </>
  )
}