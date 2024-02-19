import { Iskill } from "../Data/Data";
import "./Skills.scss"
interface SkillsData{
  skills:Iskill[];
}
export  function Skills({skills}:Readonly<SkillsData>) {
  return (
    <div className="skills">
    <h3 className="heading">Skills</h3>
    <ul className="list">
     {
       skills.map((item) => (
        <li key={item.id}>{item.skill}</li>
      ))
     }
    </ul>
    </div>
  )
}

// skills.map((item)=> {
//   return (
//       <ListItem key={item.id} text={item.text} />
//   )
// })