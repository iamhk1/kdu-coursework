warehouse=[]
shoe=[
    {
        type:"Sneaker",
        price:2000,
        color:"Blue",
        size:"UK7"
    },
    {
        type:"Formal",
        price:3000,
        color:"Black",
        size:"UK8"
    }
]
shirts=[
    {
        type:"Polo",
        price:2500,
        color:"Red",
        size:"M"
    },
    {
        
        type:"V-Neck",
        price:3200,
        color:"Black",
        size:"S"
    },
    {
        type:"Shirts",
        price:2500,
        color:"Blue",
        size:"M"

    }
]

function addToWarehouse(){
    shoe.forEach(eachShoe=> {
        warehouse.push(eachShoe)
    });
    shirts.forEach(shirt=>{
        warehouse.push(shirt)
    })
}
function calculateTotal()
{
    let total=0
    warehouse.forEach(item=>{
        total+=item.price;
    })
    return total;
}
function sortWareHouse()
{
    warehouse.sort((a,b)=>a.price-b.price);
}
function findBlueItems()
{
    console.log(warehouse.filter(item=>{
        if(item.color=='Blue')
        return item;
    }))
}

addToWarehouse();
console.log("Warehouse")
console.log(warehouse);
console.log('Total=',calculateTotal());
sortWareHouse();
console.log("Sorted WareHouse")
console.log(warehouse)
console.log("Blue Items")
findBlueItems()