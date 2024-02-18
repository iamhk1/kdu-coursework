const express=require('express')
const posts=require("../../server/data/posts");
const userData=require('../../server/data/user');
const uuid=require("uuid");
const router=express.Router()
router.post("/user/login",(req,res)=>{
    console.log(req.body);
    const { username, password } = req.body;
    const isValidUser = userData.some(user => user.user_name === username && user.password === password);
    if(isValidUser)
    res.status(200).json({status:true});
    else
    res.status(400).json({status:false});
})
router.post("/posts",(req,res)=>{
    const { username, userHandle, post ,url} = req.body;
    const id=uuid.v4();
    posts.unshift({ id,username, userHandle, post ,url});
    res.status(201).json(posts[0]);
    console.log(posts)
})
router.get("/posts",(req,res)=>{
    const { pageNumber = 1, pageSize = 5 } = req.query;
    const startIndex = (pageNumber - 1) * pageSize;
    const endIndex = pageNumber * pageSize;
    const paginatedPosts = posts.slice(startIndex, endIndex);
    res.status(200).json(paginatedPosts);
})
router.get('/userdetail', (req, res) => {
    const { username } = req.query;
    const user = userData.find(user => user.user_name === username);
  
    if (!user) {
      return res.status(404).json({ error: 'User not found' });
    }
    res.json(user);
  });
router.get("/posts/:id",(req,res)=>{
    const post = posts.find(eachPost => eachPost.id == req.params.id);
    if(post)
    res.status(200).json(post);
    else
    res.status(400).json({message:"Post Not Found"});
})
module.exports=router