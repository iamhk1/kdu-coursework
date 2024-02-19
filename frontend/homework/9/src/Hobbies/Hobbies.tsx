import { Ihobbies } from "../Data/Data";
import "./Hobbies.scss"
interface HobbiesData{
  hobbies:Ihobbies[];
}
export  function Hobbies({hobbies}:Readonly<HobbiesData>) {
  return (
    <div className="hobbies">
    <h3 className="heading">Hobbies</h3>
    <ul className="list">
      {
        hobbies.map((item) => (
        <li key={item.id}>{item.hobby}</li>
      ))
    }
    </ul>
    </div>
  )
}
