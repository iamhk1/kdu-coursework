import { configureStore } from "@reduxjs/toolkit";
import { SearchItemReducer } from "./SearchItemSlice";
import { ItemReducer } from "./ItemSlice";
export const store=configureStore({
    reducer:{
        item:ItemReducer,
        searchItem:SearchItemReducer
    }
})

export type RootState=ReturnType<typeof store.getState>