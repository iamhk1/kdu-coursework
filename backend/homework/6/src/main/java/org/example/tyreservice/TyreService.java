package org.example.tyreservice;

import org.example.beans.Tyre;

public class TyreService {
    public static  Tyre generateTyre(String brand,double price)
    {
       return new Tyre(brand,price);
    }
}
