let user = [];
function joinUser(stockSymbol,userId)
{
    const newUser={stockSymbol,userId};
    user.push(newUser);
    return newUser;
}
function getUser(id)
{
    return user.filter((eachUser)=>eachUser.userId===id)[0];
}
function userLeave(id){
    const index=user.findIndex(user=>user.id===id)
    if(index!==-1)
    {
        return user.splice(index,1)[0];
    }
}
module.exports={joinUser,userLeave,getUser}