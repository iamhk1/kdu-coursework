export interface Iskill{
    id:number,
    skill:string
}
  
export interface Ihobbies{
    id:number,
    hobby:string
}
  
export  interface IallData{
      name: string,
      fullName: string,
      qualification: string ,
      skills:Iskill[],
      hobbies : Ihobbies[]
}
  export const Json :IallData =
  {
    name: "Amey",
    fullName: "Amey Aditya",
    qualification: "SSE",
    skills: [
        {
            id: 1,
            skill: "Python"
        },
        {
            id: 2,
            skill: "React"
        }
    ],
    hobbies: [
        {
            id: 1,
            hobby: "Cricket"
        }
    ]
}
