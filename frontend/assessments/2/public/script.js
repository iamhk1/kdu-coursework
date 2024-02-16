const socket = io("http://localhost:3000");
const element=document.querySelector("#company-name")
const percent=document.querySelector("#percent")
const buy=document.querySelector("#buy button")
const sell=document.querySelector("#sell button")
const qty=document.querySelector("#quantity-id")
const price=document.querySelector("#cur_price");
console.log(element)

async function start()
{
    const response = await fetch("http://localhost:3000/price/stock");
    const stock=await response.json();
    // console.log(stock.name,stock.price);
    element.textContent=`${stock.name}`;
    price.textContent=`${stock.price}`
    // console.log(stock,"hello");
}

socket.on("message",({changePrice:change})=>{
   
   let cur_price=price.textContent;
   console.log(cur_price,"curprice");
   let diff=Math.abs(cur_price-change);
   console.log(diff);
   let percentChange=(diff)/cur_price*100;
   console.log(percentChange,"p change")
    percentChange=Math.round(percentChange*100)/100;

   price.textContent=change;
   percent.textContent=`${percentChange*Math.floor(Math.random()*3)}%`;
})


buy.addEventListener("click",()=>{
   // console.log("i am here")
    let quantity=qty.value;
    let div=document.createElement("div");
    div.classList.add("newEntry");
    let newEntryLeft=document.createElement("div");
    newEntryLeft.classList.add("newEntry-left");
    let newEntryRight=document.createElement("div");
    newEntryRight.classList.add("newEntry-right");
    lh2=document.createElement("h2");
    lh2.textContent=`${quantity} Stocks`;
    lh4=document.createElement("h4")
    lh4.textContent="Fri , 16th Feb"
    rh2=document.createElement("h2")
    rh2.textContent="BUY"
    newEntryRight.appendChild(rh2)
    newEntryLeft.appendChild(lh2)
    newEntryLeft.appendChild(lh4)
    div.appendChild(newEntryLeft);
    div.appendChild(newEntryRight)
    document.querySelector("#all-history").appendChild(div)
})
sell.addEventListener("click",function(){
    let quantity=qty.value;
    let div=document.createElement("div");
    div.classList.add("newEntry");
    let newEntryLeft=document.createElement("div");
    newEntryLeft.classList.add("newEntry-left");
    let newEntryRight=document.createElement("div");
    newEntryRight.classList.add("newEntry-right");
    lh2=document.createElement("h2");
    lh2.textContent=`${quantity} Stocks`;
    lh4=document.createElement("h4")
    lh4.textContent="Fri , 16th Feb"
    rh2=document.createElement("h2")
    rh2.textContent="SELL"
    newEntryRight.appendChild(rh2)
    newEntryLeft.appendChild(lh2)
    newEntryLeft.appendChild(lh4)
    div.appendChild(newEntryLeft);
    div.appendChild(newEntryRight)
    document.querySelector("#all-history").appendChild(div)
})