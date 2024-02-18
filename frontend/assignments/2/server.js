const express=require('express')
const path=require('path')
const http=require('http')
const socketio=require('socket.io')
const userData=require('./server/data/user');
const app=express()
const server=http.createServer(app)
const io=socketio(server)
const PORT=3000||process.env.PORT;
const posts=require("./server/data/posts");
const postApi=require("./routes/api/api")
const {addMessage,socketMap}=require("./server/data/messages")
const {userJoin,getAllUsers,userLeave}=require("./server/data/active")
app.use(express.json())
//Set static folder
app.use(express.static(path.join(__dirname,'public')))
app.use("/api",postApi)

io.on("connection",socket=>{
    console.log("Connected");
    socket.on("newLogin",({name})=>{
        const user=userJoin(socket.id,name)
    })
    socket.on("JoinRoom",({nameUser,userName,post_url})=>{
        const user=userJoin(socket.id,nameUser,userName,post_url);
        console.log(user.id,"user id");
        io.emit("NewUserJoin",getAllUsers());
    }) 
    function fetchMessages(data) {
        const user_id = data.userid;
        const friend_id = data.friendid;
    
        const userMessages = socketMap.get(user_id);
        const friendMessages = socketMap.get(friend_id);
    
        const messages = [];
    
        
        if (userMessages) {
            messages.push(...userMessages.filter(message => message.id === friend_id));
        }
        
        return messages;
    }

    
    socket.on("FetchAllMessage",(data)=>{
      
        allMessages=fetchMessages(data)
        console.log("Filtered Messages:", allMessages);
        socket.emit("ReceiveAllMessages",(allMessages));
    })
    socket.on("NewMessage",(data)=>{
        console.log("Heyyyy I received this message",data)
        addMessage(data.userid,data.friendid,data.message);
        console.log("my socketmap",socketMap);
        allMessages=fetchMessages(data);

        socket.emit("ReceiveAllMessages",(allMessages))
    })
    socket.on('disconnect',()=>{
        const user=userLeave(socket.id)
        if(user){
            console.log(user,"left");
            io.emit("UserLeft",getAllUsers())
        }
    })
    
})

server.listen(PORT,()=>{
    console.log(`Server running on ${PORT}`)
})