import { useState } from "react"
import {Nav} from "./Nav/Nav"
import {Center} from "./Center/Center"
import "./App.css"
export function App()
{
  const [items,setItems]=useState<string[]>(
    []
  )
  const [searchitem,searchItems]=useState<string[]>(
    []
  )
  return(
  <div className="container">
    <Nav item={items} settingItem={setItems} sitem={searchitem} searchingItem={searchItems} />
    <div className="middle">
      <Center allItems={items} set={setItems} allSearchItems={searchitem} searchItems={searchItems} />
    </div>
  </div>
  )
}