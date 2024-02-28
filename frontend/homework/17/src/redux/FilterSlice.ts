import{PayloadAction, createSlice} from "@reduxjs/toolkit"
interface FilterInterface
{
    search:string,
    filter:string,
    sort:string
}
const initialState:FilterInterface={
   search:"",
   filter:"",
   sort:""
}
const FilterSlice=createSlice({
    name:"item",
    initialState,
    reducers:{
        updateSearch: (state, action: PayloadAction<string>) => {
           state.search=action.payload;
        },
        updateFilter: (state, action: PayloadAction<string>) => {
            state.filter=action.payload;
         },
         updateSort: (state, action: PayloadAction<string>) => {
            state.sort=action.payload;
         }, 
    }
})

export const{updateSearch,updateFilter,updateSort}=FilterSlice.actions
export const FilterReducer=FilterSlice.reducer