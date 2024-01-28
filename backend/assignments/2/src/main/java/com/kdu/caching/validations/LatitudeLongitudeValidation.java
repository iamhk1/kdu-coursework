package com.kdu.caching.validations;

import com.kdu.caching.exception.customexception.IllegalCoordinateException;
import lombok.extern.slf4j.Slf4j;

/**
 *We perform the validation of our co-ordinates
 */
@Slf4j
public class LatitudeLongitudeValidation {
    private LatitudeLongitudeValidation()
    {

    }
    public static void checkValidation(String latitude,String longitude)
    {

        if(checkIfNotValid(latitude)||checkIfNotValid(longitude))
        {
            log.error("Coordinates entered do not exist");
            throw new IllegalCoordinateException("Coordinates Entered Do not Exist");
        }

    }
    public static boolean checkIfNotValid(String geographicalCoordinate)
    {
        int countDot=0;
        int countMinus=0;
        for(int i=0;i<geographicalCoordinate.length();i++)
        {
            char ch=geographicalCoordinate.charAt(i);
            if((ch>='0'&&ch<='9')||ch=='.'||ch=='-') {
                if(ch=='.')
                    ++countDot;
                else if(ch=='-')
                    ++countMinus;
            }
            else
                return true;
        }

         return countDot>1&&countMinus>1;
    }
}
