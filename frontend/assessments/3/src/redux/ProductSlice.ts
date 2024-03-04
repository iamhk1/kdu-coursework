import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import {Room,Received} from "../Types/Rooms"
import { getProducts } from "./thunk/GetProducts";

interface ItemState {
  received:Received
  items: Room[];
  state: string;
  errorMessage: string;
  activeButton:string
}
const initialState: ItemState = {
  received:{
    roomTypes: []
  },
  items: [],
  state: "",
  errorMessage: "",
  activeButton:"Single Room"
};
const ProductSlice = createSlice({
  name: "item",
  initialState,
  reducers: {
    toggleButton:(state,action:PayloadAction<string>)=>{
      state.activeButton=action.payload;
  }
  },
  extraReducers(builder) {
    builder
      .addCase(getProducts.pending, (state) => {
        state.state = "pending";
      })
      .addCase(getProducts.fulfilled, (state, action) => {
        console.log(action.payload.roomTypes);
        state.received=action.payload;
        state.items=state.received.roomTypes;
        
        state.state = "fulfilled";
      })
      .addCase(getProducts.rejected, (state, action) => {
        state.errorMessage = action.error.message!;
        console.log("rejected in slice")
        state.state = "rejected";
      });
  },
});
export const ProductReducer = ProductSlice.reducer;
