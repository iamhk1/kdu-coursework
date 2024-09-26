const socket = io("http://localhost:3000");
const messageInput = document.getElementById("msgInput");
const sendButton = document.getElementById("sendMessage");
const messageOutput = document.getElementById("messages");
const roomName = document.getElementById("room");
/**
 * Function that appends a new message.
 * @param {String} from - Username.
 * @param {String} message - Message.
 * 
 */
function addMessage(from, message) {
  const messageClass = "message";
  const messageDiv = document.createElement("div");
  messageDiv.classList.add(messageClass);

  const symbolSpan = document.createElement("span");
  if (from === "User") symbolSpan.innerText = "U";
  else symbolSpan.innerText = "Y";
  symbolSpan.classList.add(messageClass + "__symbol");

  const messageP = document.createElement("p");
  messageP.innerText = from + ": " + message;
  messageP.classList.add(messageClass + "__text");

  messageDiv.appendChild(symbolSpan);
  messageDiv.appendChild(messageP);

  messageOutput.appendChild(messageDiv);
  messageOutput.scrollTop = messageOutput.scrollHeight;
}
/**
 * Function that fetches value from the form and helps create a new message
 */
sendButton.addEventListener("click", () => {
  const message = messageInput.value;
  if (!message) return;
  messageInput.value = "";
  messageInput.focus();
  addMessage("You", message);
  socket.emit("message", message);
});

socket.on("new-message", (message) => {
  addMessage("User", message);
});




submitRoom.addEventListener("click", () => {
  const room = roomName.value;
  socket.emit("room", room);
});
