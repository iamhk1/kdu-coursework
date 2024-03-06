const userActive=[];
function userJoin(id,name,username,url)
{
    const user={id,name,username,url};
    userActive.push(user);
    return user;
}
function getAllUsers()
{
    return userActive;
}
function userLeave(id){
    const index=userActive.findIndex(user=>user.id===id)
    if(index!==-1)
    {
        return userActive.splice(index,1)[0];
    }
}
module.exports={userJoin,getAllUsers,userLeave};