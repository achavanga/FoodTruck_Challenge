package za.co.camel.model;

/**
 * File Name    : Location.java
 * Project Name : SparkTest
 *
 * @since  Apr 4, 2017, 9:50:28 PM
 * @author Abel Chavanga <achavanga@fnb.co.za>  
 *
 */
public class Location
{
    private String type;

    private String[] coordinates;

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String[] getCoordinates ()
    {
        return coordinates;
    }

    public void setCoordinates (String[] coordinates)
    {
        this.coordinates = coordinates;
    }

    @Override
    public String toString()
    {
        return "Location [type = "+type+", coordinates = "+coordinates+"]";
    }
}
			
			
