
function addElement()
{
    let button=document.querySelector("#add")
    button.addEventListener("click",function(){
    const task=document.getElementById("task").value;
    let ul=document.querySelector("ul");
    let liAll=ul.querySelectorAll("li")
    liAll.forEach(ele=>{
        if(ele.textContent===task+'delete')
        {
            return ;
        }
        console.log(ele.textContent);
    })
    if(task.length>0)
    {
    const button=document.createElement("button")
    button.textContent="delete";
    button.classList.add("delete");
    let ul=document.getElementById("ul-list");
    let li = document.createElement("li");
    li.textContent=task;
    ul.appendChild(li);
    li.appendChild(button);
    button.addEventListener("click", function() {
        this.parentNode.remove();
    });
    }

})
}
addElement();
