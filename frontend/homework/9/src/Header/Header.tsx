import { IallData } from "../Data/Data";
import "./Header.scss"
interface HeaderProps {
  data: IallData;
}

export  function Header({data}:Readonly<HeaderProps>) {
  return (
    <div className="headings">
      <h1>{data.name}</h1>
      <h3>{data.fullName}</h3>
      <h1>{data.qualification}</h1>
    </div>
  )
}
