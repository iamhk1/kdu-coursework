import { PayloadAction, createSlice } from "@reduxjs/toolkit"

interface SearchItemState{
    searchItems:string[],
   
}
const initialState:SearchItemState={
    searchItems:[]
}
const SearchItemSlice=createSlice({
    name:"searchItem",
    initialState,
    reducers:{
        displayItems: (state, action: PayloadAction<{ searchString: string; items: string[] }>) => {
            const searchString = action.payload.searchString;
            const allItems = action.payload.items;
            state.searchItems = allItems.filter(item => item.includes(searchString));
        }
    }
})

export const{displayItems}=SearchItemSlice.actions
export const SearchItemReducer=SearchItemSlice.reducer