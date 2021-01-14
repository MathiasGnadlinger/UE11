package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mathias Gnadlinger
 * @version 11, 14.01.2021
 */
public class CarDatabase
{
    public HashMap<String, Vehicle> db = new HashMap<>();

    public CarDatabase()
    {
        for (int i = 0; i < 1000; i++)
        {
            MagicGenerator magicGenerator = new MagicGenerator();

            String carManufacture = magicGenerator.getRandomManufacturer();
            String carLicencePlate = magicGenerator.getRandomLicencePlate();
            String carColor = magicGenerator.getRandomColor();
            String RandomName = magicGenerator.getRandomName();
            String carModel = magicGenerator.getRandomModel(carManufacture);

            Vehicle vehicle = new Vehicle(carColor,RandomName,carManufacture,carModel,carLicencePlate);
            db.put(carLicencePlate, vehicle);
            System.out.printf("created vehicle with license plate: %s \n",carLicencePlate);
        }
    }


    public ArrayList<Vehicle> search(String LicencePlate)
    {
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        for (Map.Entry entry:db.entrySet())
        {
            if (entry.getKey().toString().contains(LicencePlate))
                vehicles.add(db.get(entry.getKey()));
        }
        return vehicles;
    }

    public Vehicle exact_search(String LicencePlate)
    {
        if (db.get(LicencePlate) != null)
            return db.get(LicencePlate);
         else
             return null;
    }
}