const socket=io()
let nameUser="";
let userName="";
let post_url="";
let user_id="";
let friend_id="";
const inputField = document.getElementById("input");
const submitBtn = document.getElementById("btn");

submitBtn.addEventListener("click", () => {
    
    const message = inputField.value;
    let data={
        userid:user_id,
        friendid:friend_id,
        message:message
    }
    
    socket.emit("NewMessage",data);

});
async function onLoad()
{
    const urlString = window.location.href;
    const url = new URL(urlString);
    const name = url.searchParams.get("name");
    const userDetailsUrl = `/api/userdetail?username=${encodeURIComponent(name)}`;
    const response = await fetch(userDetailsUrl);
    const data = await response.json();
    console.log(data,"user detail");
    nameUser=data.name;
    userName=data.user_name;
    post_url=data.profile_url;
    console.log(nameUser,userName,post_url)
     changeUserDetails()
     socket.emit("JoinRoom",{nameUser,userName,post_url});
    
}
onLoad();
socket.on("UserLeft",(allUsers)=>{
    console.log("from left",allUsers)
    updateUsers(allUsers);
})
function updateUsers(allUsers){
        allUsers.forEach((user)=>{
            if(user.username===userName)
            {
                user_id=user.id;
            }
        })
        console.log("newuser", allUsers);
    
        const centerElement = document.getElementById("center");
        centerElement.innerHTML = `<h2>Messages</h2>`;
        allUsers.forEach(user => {
        console.log(user,"each user");
        const eachUserDiv = document.createElement("div");
        eachUserDiv.classList.add("each-user");

        const imgElement = document.createElement("img");
        imgElement.classList.add("logo")
        imgElement.src = user.url;
        imgElement.alt = "";

        const nameDisplayElement = document.createElement("h4");
        nameDisplayElement.textContent = user.name;
        nameDisplayElement.id = "name-display";

        const usernameElement = document.createElement("h5");
        usernameElement.textContent = "@" + user.username;
        usernameElement.classList.add("grey");

        eachUserDiv.appendChild(imgElement);
        eachUserDiv.appendChild(nameDisplayElement);
        eachUserDiv.appendChild(usernameElement);
        
        eachUserDiv.addEventListener("click", function() {
           
            const rightContainer = document.getElementById("right");
            document.getElementById("right").style.display = "block";
            
            const clickedUsername = user.username;
        
            
            document.getElementById("username-1").textContent = clickedUsername;


            const clickedUser = user;
            friend_id=clickedUser.id;
            fetchAllMessages();

        });
        centerElement.appendChild(eachUserDiv);

       
    });
}
function fetchAllMessages()
{
    let data={
        userid:user_id,
        friendid:friend_id
    }
    socket.emit("FetchAllMessage",(data));

}
function updateMessage(allMessages)
{
    const allMessagesContainer =  document.querySelector(".all-messages");
    allMessagesContainer.innerHTML=''
    allMessages.forEach((message) => {
        const messageDiv = document.createElement("div");
        messageDiv.classList.add("message");

        const messageContent = document.createElement("p");
        messageContent.classList.add("message-content");
        messageContent.textContent = message.message;

        const messageTime = document.createElement("p");
        messageTime.classList.add("message-time");
       
        messageDiv.appendChild(messageContent);
        messageDiv.appendChild(messageTime);

        if (message.sent_by === "me") {
            messageDiv.classList.add("sent-message");
        } else {
            messageDiv.classList.add("received-message");
        }
        allMessagesContainer.appendChild(messageDiv);
    });
}
socket.on("ReceiveAllMessages",(allMessages)=>{
    console.log("received all messages",allMessages);
    
    updateMessage(allMessages);
})

socket.on("NewUserJoin", (allUsers) => {
    console.log(allUsers,"all users");
    updateUsers(allUsers);
});


function changeUserDetails()
{
    
    let name=document.querySelector("#user-id #name");
    let logo=document.querySelector(".logo");
    let person_logo=document.querySelector("#user-photo");
    person_logo.src=post_url;
    console.log(logo)
    logo.src=post_url;
    console.log(logo);
    
    let username=document.querySelector("#user-id #user");
    name.textContent=`${nameUser}`;
    let nameDisplay=document.querySelector(".each-user #name-display");
    let userName1=document.querySelector(".each-user #username");
    nameDisplay.textContent=`${nameUser}`;
    userName1.textContent=`${userName}`
    username.textContent=`${userName}`;
    
}
