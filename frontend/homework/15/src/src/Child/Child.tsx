// import React, { useState } from "react";
// import { eachUser } from "../App";

// interface ChildProps {
//     users: eachUser[];
//     set: React.Dispatch<React.SetStateAction<eachUser[]>>;
// }

// export function Child({ users, set }: ChildProps) {
//     const [message, setMessage] = useState('');
//     const [id, setId] = useState('');

//     const handleChangeName = (event:any) => {
//         setMessage(event.target.value);
//     };

//     const handleChangeId = (event:any) => {
//         setId(event.target.value);
//     };

//     const addUser = () => {
//       const newUser: eachUser = {
//         id: parseInt(id), name: message
//       }
//         set([...users, newUser]);
//         setMessage('');
//         setId('');
//     };

//     return (
//         <div>
//             <ul>
//                 {users.map((item) => (
//                     <li key={item.id}>{item.name} {item.id}</li>
//                 ))}
//             </ul>
//             <input type="text" name="message" onChange={handleChangeName} value={message} placeholder="Name" />
//             <input type="number" name="id" onChange={handleChangeId} value={id} placeholder="Id" />
//             <button onClick={addUser}>Submit</button>
//         </div>
//     );
// }


export{}