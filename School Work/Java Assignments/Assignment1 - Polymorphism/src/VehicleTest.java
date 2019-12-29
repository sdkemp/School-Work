public class VehicleTest
{


    public static void main(String [] args)
    {
        //vehicle array
        Vehicle vehicletest[] = new Vehicle[2];

        //creating objects for array
        Car carTest = new Car(23);
        Bicycle bicycleTest = new Bicycle();

        //putting objects in array
        vehicletest[0] = carTest;
        vehicletest[1] = bicycleTest;
        //for loop for printing footprint
        for(int x = 0;x<2;x++)
        {
            //formatting string to have 2 decimals
            String result = String.format("%.2f", vehicletest[x].GetCarbonFootprint());
            System.out.println(result);


        }


    }


}
