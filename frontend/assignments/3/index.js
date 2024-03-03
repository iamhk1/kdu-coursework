const {joinUser,userLeave,getUser}=require("./data/user")
const express=require('express')
const cors=require('cors')
const path=require('path')
const http=require('http')
const socketIo=require('socket.io')
const PORT=3000||process.env.PORT;
const app=express()
app.use(cors())
const server=http.createServer(app);
const io=new socketIo.Server(server,{
    cors:{
        origin: "*",
    }
})
const names = ["John", "Emma", "Michael", "Sophia", "James", "Olivia", "William", "Isabella", "Benjamin", "Amelia"];
let i=0;
io.on('connection',socket=>{
    console.log("connection done",i++);
    socket.on('joinRoom',({stockSymbol})=>{
        const user=joinUser(stockSymbol,socket.id)
        socket.join(user.stockSymbol)
        console.log("Joined room successfully",stockSymbol);
        socket.broadcast.to(user.stockSymbol).emit('message',"he has joined the chat")
    })
    // socket.on("NewTransaction", (transactionData) => {
    //     console.log("New transaction received:", transactionData);
    //     const user=getUser(socket.id);
    //     console.log(user);
    //     if(user)
    //     {
    //         socket.broadcast.to(user.stockSymbol).emit("Transaction",transactionData);
    //     }
    //     // 
    //     // Handle the new transaction data here
    //   });
    

    socket.on("NewTransaction", (transactionData) => {
    console.log("New transaction received:", transactionData);
    const user = getUser(socket.id);
    console.log(user);
    if (user) {
        socket.broadcast.to(user.stockSymbol).emit("Transaction", transactionData);
    }
});
    socket.on('disconnect',()=>{
        const user=userLeave(socket.id)
        console.log(user);
    })
})
server.listen(3000,()=>{
    console.log("App Started on port 3000")
})