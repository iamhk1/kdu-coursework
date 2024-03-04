const express=require('express')
const path=require('path')
const http=require('http')
const app=express()
const server=http.createServer(app)
const cors=require('cors')

const socketIo=require('socket.io')
app.use(cors())
const io=new socketIo.Server(server,{
    cors:{
        origin:"*"
    }
})
const PORT=3000||process.env.PORT;

let originalPrice=124.34;

app.use(express.json());
app.get("/price/stock",(req,res)=>{
    console.log("Hello world")
    res.json({
        name:"zomato",
        price:124.34
    });
})

function generateRandomPrice()
{
    let number=Math.floor(Math.random() * 11);
    let priceChange=0;
    if(number<=5)
    {
        priceChange=Math.floor(Math.random() * 6);
        originalPrice=0.94*originalPrice;
    }
    else{
        priceChange=Math.floor(Math.random() * 20);
        originalPrice=1.06*originalPrice;
        originalPrice=originalPrice.toFixed(2)
    }
    return originalPrice;
}
io.on('connection',socket=>{
    console.log("connection created")
   setInterval(function(){
    let change=generateRandomPrice();
    change=Math.round(change*100)/100
    // console.log(change,"change")
    socket.emit('message',({changePrice:change}))
   },12000)
})
server.listen(PORT,()=>{
    console.log(`Server running on ${PORT}`)
})

