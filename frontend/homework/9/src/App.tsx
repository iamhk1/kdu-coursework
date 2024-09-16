
import {Header} from "./Header/Header"
import {Hobbies} from "./Hobbies/Hobbies"
import {Skills} from "./Skills/Skills"
import {Json} from"./Data/Data"
import "./App.scss"
export function App() {
    return (
      <>
      <Header data={Json}/>
      <div className="box">
      <Skills skills={Json.skills}/>
      <Hobbies hobbies={Json.hobbies} />
      </div>
      </>
    );
  }

