import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { Product } from "../Types/Types";
import { getProducts } from "./thunks/GetProducts";
interface ItemState {
  items: Product[];
  searchedItems: Product[];
  state: string;
  errorMessage: string;
}
const initialState: ItemState = {
  items: [],
  searchedItems: [],
  state: "",
  errorMessage: "",
};
const ProductSlice = createSlice({
  name: "item",
  initialState,
  reducers: {
    displayItems: (state, action: PayloadAction<string>) => {
      const searchString = action.payload;
      state.searchedItems = state.items.filter((item) =>
        item.title.toLowerCase().includes(searchString)
      );
    },
    filterItems: (state, action: PayloadAction<string>) => {
      if(action.payload==="")
      {
        state.searchedItems=state.items;
        
      } 
      else{ 
      state.searchedItems = state.items.filter(
        (product) =>
          product.category.toLowerCase() === action.payload.toLowerCase()
      );
    }
},
    sortedItems: (state, action: PayloadAction<string>) => {
      if (action.payload=== "1") {
        state.searchedItems=[...state.searchedItems].sort(
          (a, b) => a.price - b.price
        );
      } else if (action.payload === "2") {
        state.searchedItems = [...state.searchedItems].sort(
          (a, b) => b.price - a.price
        );
      }
    },
  },
  extraReducers(builder) {
    builder
      .addCase(getProducts.pending, (state) => {
        state.state = "pending";
      })
      .addCase(getProducts.fulfilled, (state, action) => {
        state.items = action.payload;
        state.searchedItems = action.payload;
        state.state = "fulfilled";
      })
      .addCase(getProducts.rejected, (state, action) => {
        state.errorMessage = action.error.message!;
        console.log("rejected in slice")
        state.state = "rejected";
      });
  },
});
export const { displayItems,filterItems,sortedItems } = ProductSlice.actions;
export const ProductReducer = ProductSlice.reducer;
