const socketMap = new Map();


function addMessage(user_id, friend_id, message) {
   
    if (socketMap.has(user_id)) {
        const messages = socketMap.get(user_id);
        messages.push({ id: friend_id, message, sent_by: "me" });
        socketMap.set(user_id, messages);
    } else {
        socketMap.set(user_id, [{ id: friend_id, message, sent_by: "me" }]);
    }

    
    if (friend_id !== user_id) {
        if (socketMap.has(friend_id)) {
            const messages = socketMap.get(friend_id);
            messages.push({ id: user_id, message, sent_by: "other" });
            socketMap.set(friend_id, messages);
        } else {
            socketMap.set(friend_id, [{ id: user_id, message, sent_by: "other" }]);
        }
    }
}


module.exports={
    addMessage,
    socketMap
}
