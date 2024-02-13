const uuid=require('uuid')
//Array of posts 
let posts=[
    {
        id:uuid.v4(),
        username:"iamhk",
        name:"Harsh",
        post:"Hey , this is my first post!"
    },
    {
        id:uuid.v4(),
        username:"rk",
        name:"Rohit",
        post:"Hey , Rohit here!"
    },
    {
        id:uuid.v4(),
        username:"czr",
        name:"Chirag",
        post:"Hey, How are ya'll doing?"
    },
    {
        id:uuid.v4(),
        username:"iampk",
        name:"Praveen",
        post:"Had a nice outing"
    }
]
module.exports=posts