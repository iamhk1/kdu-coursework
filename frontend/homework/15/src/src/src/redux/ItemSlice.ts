import{PayloadAction, createSlice} from "@reduxjs/toolkit"

interface ItemState{
    items:string[],
    checked:boolean[]
}
const initialState:ItemState={
    items:[],
    checked:[]
}
const ItemSlice=createSlice({
    name:"item",
    initialState,
    reducers:{
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
export const{addItem,deleteItem,toggleCheck,removeChecked}=ItemSlice.actions
export const ItemReducer=ItemSlice.reducer