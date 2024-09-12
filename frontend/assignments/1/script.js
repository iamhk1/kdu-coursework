function createPost(userName, userHandle, postContent) {
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
    userImg.src = './assets/images/profile pic.png';
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
    createPost('Nitesh Gupta', '@nit_hck.', inputContent);
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
    let profileIcon = document.querySelector('#main #right .profile-icon');
    let drafts=document.querySelector("#main #drafts");
    let back=document.querySelector("#main #back")
    if (tweetBox.style.display === 'none') {
        tweetBox.style.display = 'block';
        profileIcon.style.display = 'none';
        drafts.style.display='block';
        back.style.display='block';
    } else {
        tweetBox.style.display = 'none';
        postsSection.style.display = 'block';
        profileIcon.style.display = 'block';
        drafts.style.display='none';
        back.style.display='none';
    }
});
