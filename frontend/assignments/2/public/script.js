const socket=io()
let pageNumber = 1;
let nameUser="";
let userName="";
let profile_url=""


async function onLoad()
{
    const urlString = window.location.href;
    const url = new URL(urlString);
    const name = url.searchParams.get("name");
    console.log(name);
    const userDetailsUrl = `/api/userdetail?username=${encodeURIComponent(name)}`;
    const response = await fetch(userDetailsUrl);
    const data = await response.json();
    console.log(data);
    nameUser=data.name;
    userName=data.user_name;
    profile_url=data.profile_url;
    
     changeUserDetails()

}
onLoad();
function changeUserDetails()
{
   
    console.log(nameUser,userName);
    let name=document.querySelector("#user-id #name");
    console.log(name);
    let username=document.querySelector("#user-id #user");
    name.textContent=`${nameUser}`;
    username.textContent=`${userName}`;
    console.log(name);
    console.log(username)
    let profilePic=document.querySelector("#profile-pic")
    let profilePic2=document.querySelector("#profile-pic2")
    console.log(profilePic,"profilepic");
    profilePic.src=profile_url;
    profilePic2.src=profile_url;

}

async function firstLoadPosts()
{
   
    const postsContainer = document.querySelector('.posts');     
    postsContainer.innerHTML = '';
    
    const res = await fetch(`/api/posts?pageNumber=${pageNumber}`);
    const posts = await res.json();
    
    posts.forEach(post => {
        
        const { username, userHandle, post: postContent,url } = post;
        updatePostInUI(username, userHandle, postContent,url);
    });
}

async function loadPosts()
{
    
    const postsContainer = document.querySelector('.posts');     
   
    const res = await fetch(`/api/posts?pageNumber=${pageNumber}`);
    const posts = await res.json();
   
    posts.forEach(post => {
        
        const { username, userHandle, post: postContent,url } = post;
        updatePostInUI(username, userHandle, postContent,url);
    });
}


async function createPost(userName, userHandle, postContent) {

    const postData = {
        username: userName,
        userHandle: userHandle,
        post: postContent,
        url:profile_url
    };
    const response = await fetch("/api/posts", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(postData)
    });
    const newPost = await response.json();
    
    const res = await fetch("/api/posts");
    const posts = await res.json();
    const postsContainer = document.querySelector('.posts');     
    postsContainer.innerHTML = '';
    
    posts.forEach(post => {
        const { username, userHandle, post: postContent ,url} = post;
        updatePostInUI(username, userHandle, postContent,url);
    });
    
}
function updatePostInUI(userName, userHandle, postContent,iurl)
{
    let postContainer = document.createElement('div');
    postContainer.classList.add('each-post');

    let postTop = document.createElement('div');
    postTop.id = 'post-top';
    postContainer.appendChild(postTop);

    let iconContent = document.createElement('div');
    iconContent.id = 'icon-content';
    postTop.appendChild(iconContent);

    let userIcon = document.createElement('div');
    userIcon.id = 'user-icon';
    iconContent.appendChild(userIcon);

    let userImg = document.createElement('img');
    userImg.src = iurl;
    userImg.alt = 'profile pic';
    userIcon.appendChild(userImg);

    let content = document.createElement('div');
    content.id = 'content';
    iconContent.appendChild(content);

    let h5_1 = document.createElement('h5');
    h5_1.textContent = userName + ' ';
    let span_1 = document.createElement('span');
    span_1.textContent = userHandle + ' 1s';
    h5_1.appendChild(span_1);
    content.appendChild(h5_1);

    let h5_2 = document.createElement('h5');
    h5_2.textContent = postContent;
    content.appendChild(h5_2);

    let dots = document.createElement('div');
    dots.id = 'dots';
    postTop.appendChild(dots);

    let dotsImg = document.createElement('img');
    dotsImg.src = './assets/icons/three_dots.svg';
    dotsImg.alt = 'dots';
    dots.appendChild(dotsImg);

    let postBottom = document.createElement('div');
    postBottom.classList.add('post-bottom');
    postContainer.appendChild(postBottom);

    let icons = ['comment', 'retweet', 'heart', 'stats'];
    icons.forEach(icon => {
        let iconDiv = document.createElement('div');
        iconDiv.classList.add('post-bottom-icons');
        let iconImg = document.createElement('img');
        iconImg.src = `./assets/icons/${icon}.svg`;
        iconImg.alt = '';
        iconDiv.appendChild(iconImg);
        postBottom.appendChild(iconDiv);
    });

    let otherIcons = document.createElement('div');
    otherIcons.classList.add('post-bottom-icons', 'other');
    let bookmarkImg = document.createElement('img');
    bookmarkImg.src = './assets/icons/bookmark.svg';
    bookmarkImg.alt = '';
    otherIcons.appendChild(bookmarkImg);
    let shareImg = document.createElement('img');
    shareImg.src = './assets/icons/share.svg';
    shareImg.alt = '';
    otherIcons.appendChild(shareImg);
    postBottom.appendChild(otherIcons);

    let postsContainer = document.querySelector('.posts');
    postsContainer.appendChild(postContainer);
}

document.querySelector('.tweet-btn button').addEventListener('click', function() {
    let inputContent = document.querySelector('.tweet-box input').value;
    createPost(nameUser, userName, inputContent);
    document.querySelector('.tweet-box input').value = '';
    togglePostButton();
});

function togglePostButton() {
    let inputField = document.querySelector('.tweet-box input');
    let postButton = document.querySelector('.tweet-btn button');

    if (inputField.value.trim() === '') {
        postButton.disabled = true;
        postButton.style.backgroundColor = '#1c98ea67';
    } else {
        postButton.disabled = false;
        postButton.style.backgroundColor = '#1c98ea';
    }
}

document.querySelector('.tweet-box input').addEventListener('input', function() {
    togglePostButton();
});

togglePostButton();


let heartIcons = document.querySelectorAll('.post-bottom-icons img[src="./assets/icons/heart.svg"]');

heartIcons.forEach(icon => {
    let isFilled = false;
    icon.addEventListener('click', function() {
        if (!isFilled) {
            icon.src = "./assets/icons/heart_full.svg";
            let h5Element = document.createElement('h5');
            h5Element.textContent = '1';
            icon.parentNode.appendChild(h5Element);
        } else {
            icon.src = "./assets/icons/heart.svg";
            let h5Element = icon.parentNode.lastChild;
            icon.parentNode.removeChild(h5Element);
        }
        isFilled = !isFilled;
    });
});

let profilebtn=document.querySelector(".profile-icon");
profilebtn.addEventListener("click",function(){

})

document.addEventListener('DOMContentLoaded', function() {
    let isLeftVisible = false;

    document.querySelector('.profile-icon').addEventListener('click', function() {
        let leftSection = document.querySelector('#left');
        if (!isLeftVisible) {
            leftSection.style.display = 'block';
        } else {
            leftSection.style.display = 'none';
        }
        isLeftVisible = !isLeftVisible;
    });
});

document.querySelector('.floating-tweet-box-icon').addEventListener('click', function() {
    let tweetBox = document.querySelector('#main #right .tweet-box');
    let postsSection = document.querySelector('#main #right .posts');
    let drafts=document.querySelector("#main #drafts");
    let back=document.querySelector("#main #back")
    let posts=document.querySelector("#main #right .posts")
    if (tweetBox.style.display === 'none') {
        tweetBox.style.display = 'block';
        drafts.style.display='block';
        back.style.display='block';
    } else {
        tweetBox.style.display = 'none';
        postsSection.style.display = 'block';
        drafts.style.display='none';
        back.style.display='none';
    }
});


document.addEventListener("DOMContentLoaded", function() {
    const messageElement = document.querySelector(".message");
    const messageElement2= document.querySelector("#message-button");
    messageElement.addEventListener("click", function() {
        window.location.href = `http://localhost:3000/message.html?name=${userName}`;
    });
    messageElement2.addEventListener("click", function() {
        window.location.href = `http://localhost:3000/message.html?name=${userName}`;
    });
});



document.addEventListener("DOMContentLoaded", function() {
    const postsContainer = document.querySelector(".posts");

    postsContainer.addEventListener("scroll", function() {
        const isScrollbarAtBottom = postsContainer.scrollHeight - postsContainer.scrollTop <= postsContainer.clientHeight + 1;

        if (isScrollbarAtBottom) {
            console.log("Scrollbar reached the bottom");
            ++pageNumber;
            loadPosts();
        }
    });
});



