const express=require('express')
const posts=require('../../data/posts')
const router=express.Router()

//Importing UUID
const uuid=require('uuid')

/**
 * Function to get all the posts
 * @request
 * @param {object} req - Request object
 * @param {object} res - Response object
 * @returns {number} Status code along with the message.
 */
router.get('/',(req,res)=>{
    if(posts.length==0)
    {
        res.status(200).json({msg:"There are no posts"})
    }
    else{
        res.json(posts);
    }
})
/**
 * Function to get  post for a given Id
 * @request
 * @param {string} uuid-Users uuid
 * @param {object} req - Request object
 * @param {object} res - Response object
 * @returns {json} Status code along with the message.
 */
router.get('/:id',(req,res)=>{
    const found=posts.some(post=>post.id===req.params.id);
    if(found)
    {
        res.json(posts.filter(post=>post.id===req.params.id))
    }
    else 
    {
        res.status(400).json({msg:"Member not found"})
    }
})
/**
 * Function to get update a given post
 * @request
 * @param {string} uuid-Users uuid
 * @param {object} req - Request object
 * @param {object} res - Response object
 * @returns {json} Status code along with the message.
 */
router.put('/:id',(req,res)=>{
    const found=posts.some(post=>post.id===req.params.id);
    console.log(found)

    if(found)
    {
        const postDetails=req.body;
        posts.forEach(post=>{
            if(post.id===req.params.id)
            {
                post.post=postDetails.post;
                res.status(201).json(post);
            }
        })
        
    }
    else 
    {
        res.status(400).json({msg:"Member not found"})
    }
})

/**
 * Function to get add a given post
 * @request
 * @param {object} req - Request object
 * @param {object} res - Response object
 * @returns {json} Status code along with the details of the post
 */
router.post('/',(req,res)=>{
    const newPost={
        id:uuid.v4(),
        username:req.body.username,
        name:req.body.name,
        post:req.body.post
    }
    posts.push(newPost)
    res.status(201).json({newPost});
})

module.exports=router