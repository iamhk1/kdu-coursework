interface IRecepies{
    name:string,
    ingredients:string[],
    instructions:string[],
    prepTimeMinutes:number,
    cookTimeMinutes:number,
    servings:number,
    difficulty:string,
    cuisine:string,
    caloriesPerServing:number,
    tages:string[],
    userId:number,
    image:string,
    rating:number,
    reviewCount:number,
    mealType:string[]
}
interface IAllRecepie{
    recipes:IRecepies[];
    total:number,
    skip:number,
    limit:number
}
interface IRequiredProperties{
    image:string,
    name:string,
    rating:number,
    cusine:string,
    ingredients:string[],
    difficulty:string,
    time:number,
    calorie:number
}
let searchReceipe:IRequiredProperties;
let iAllRecepie:IAllRecepie;
let iRecepie:IRecepies[]=[];
let iRequiredRecepies:IRequiredProperties[]=[];

async function fetchRecipesFromAPI()
{
    const res=await fetch("https://dummyjson.com/recipes")
    iAllRecepie=await res.json();
    iRecepie=iAllRecepie.recipes;
    // console.log(iRecepie)
    iRecepie.forEach(recipe=>{
        let newRecipe={
            image:recipe.image,
            name:recipe.name,
            rating:recipe.rating,
            cusine:recipe.cuisine,
            ingredients:recipe.ingredients,
            difficulty:recipe.difficulty,
            time:recipe.cookTimeMinutes+recipe.prepTimeMinutes,
            calorie:recipe.caloriesPerServing
        }
        iRequiredRecepies.push(newRecipe)
    })    
}
function printAllRecipe(){
    console.log(iRequiredRecepies)
}

async function searchRecipe(query:string){
    const res=await fetch(`https://dummyjson.com/recipes/search?q=${query}`)
    iAllRecepie=await res.json();
    iRecepie=iAllRecepie.recipes;
    searchReceipe={
        image:iRecepie[0].image,
        name:iRecepie[0].name,
        rating:iRecepie[0].rating,
        cusine:iRecepie[0].cuisine,
        ingredients:iRecepie[0].ingredients,
        difficulty:iRecepie[0].difficulty,
        time:iRecepie[0].cookTimeMinutes+iRecepie[0].prepTimeMinutes,
        calorie:iRecepie[0].caloriesPerServing
    }
    console.log("-----------------------------------------")
    console.log(searchReceipe)

}
function main()
{
fetchRecipesFromAPI().then(()=>{
   printAllRecipe()
   searchRecipe("pizza")
})
.catch((err)=>{
    console.log(err)
})
}

main();
