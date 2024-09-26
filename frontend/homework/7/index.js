const express=require('express')
const http=require('http')
const cors=require('cors')
const socketIo=require('socket.io')
const app=express()
app.use(cors())
//Creating a new Server
const server=http.createServer(app);
const io=new socketIo.Server(server,{
    cors:{
        origin:"*"
    }
})
app.use(express.json())

app.get("/",(req,res)=>{
    res.json({"msg":"hello world"})
})
/**
 * Function performs tasks when connection is established 
 * @param {socket} socket - Socket.
 * 
 */
io.on("connection",(socket)=>{
    console.log("Connection Created")
    //emitting message to all the users
    socket.on("message",(payload)=>{
        console.log("Payload",payload)
        io.except(socket.id).emit("new-message",payload)
    })
    socket.on("room",(room)=>{
        console.log("Room =",room)
        console.log(socket.id)
        socket.join(room)
        socket.room = room;

    })
})

server.listen(3000,()=>{
    console.log("App Started on port 3000")
})