const express=require('express')
const path=require('path')
const app=express();
const PORT=process.env.PORT||5000


//Body parser Middleware
app.use(express.json())
app.use('/api/posts',require('./routes/api/posts'))
app.listen(PORT,()=>{
    console.log(`Server started on ${PORT}`);
})