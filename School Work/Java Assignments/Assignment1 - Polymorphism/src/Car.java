public class Car extends Vehicle
{
    int gallon;
    //constructor
    public Car(int gallon)
    {

        this.gallon = gallon;
    }

    //carbon footprint calc
    public double GetCarbonFootprint()
    {
        return (this.gallon*20);
    }




}
