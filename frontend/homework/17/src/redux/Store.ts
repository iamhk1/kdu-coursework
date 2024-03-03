import { configureStore } from "@reduxjs/toolkit";
import { ProductReducer } from "./ProductSlice";
import { FilterReducer } from "./FilterSlice";
export const store=configureStore({
    reducer:{
        product:ProductReducer,
        filter:FilterReducer
    }
})

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
