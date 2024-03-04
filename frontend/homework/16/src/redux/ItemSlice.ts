import{PayloadAction, createSlice} from "@reduxjs/toolkit"

interface ItemState{
    items:string[],
    checked:boolean[]
}
function itemState()
{
    const storedLists = localStorage.getItem('lists');
    return storedLists !== null && storedLists !== "" ? JSON.parse(storedLists) : [];
}
const initialState:ItemState={
    
   
    items:itemState(),
    checked:[]
}
const ItemSlice=createSlice({
    name:"item",
    initialState,
    reducers:{
        populateItem:(state,action:PayloadAction<string>)=>{
            state.items=[action.payload];
        },
        addItem:(state,action:PayloadAction<string>)=>{
            state.items=[...state.items,action.payload]
            state.checked=[...state.checked,false];
        },
        deleteItem:(state,action:PayloadAction<number>)=>{
            state.items.splice(action.payload, 1);   
        },
        toggleCheck:(state,action:PayloadAction<number>)=>{
            const index = action.payload;
            state.checked[index] = !state.checked[index];
        },
        removeChecked: (state) => {
            state.items = state.items.filter((_item, index) => !state.checked[index]);
            state.checked = state.checked.filter((checked) => !checked);
        }
    }
})
export const{populateItem,addItem,deleteItem,toggleCheck,removeChecked}=ItemSlice.actions
export const ItemReducer=ItemSlice.reducer