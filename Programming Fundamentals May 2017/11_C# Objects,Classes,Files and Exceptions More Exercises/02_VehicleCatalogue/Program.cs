using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_VehicleCatalogue
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Vehichle> catalogue = new List<Vehichle>();
            List<double> cars = new List<double>();
            List<double> trucks = new List<double>();

            var input = Console.ReadLine();
            while (input != "End")
            {
                string[] tokens = input.Split();

                string type = tokens[0].ToLower();
                if (type == "car")
                {
                    type = "Car";
                }
                else
                {
                    type = "Truck";
                }

                string model = tokens[1];
                string color = tokens[2];
                int horsepower = int.Parse(tokens[3]);

                Vehichle vehichle = new Vehichle
                {
                    Type = type,
                    Model = model,
                    Color = color,
                    Horsepower = horsepower
                };

                if (type == "car" || type == "Car")
                {
                    cars.Add(horsepower);
                }
                else
                {
                    trucks.Add(horsepower);
                }

                catalogue.Add(vehichle);

                input = Console.ReadLine();
            }

            input = Console.ReadLine();

            while (input != "Close the Catalogue")
            {
                foreach (var item in catalogue)
                {
                    if (input == item.Model)
                    {
                        Console.WriteLine($"Type: {item.Type}");
                        Console.WriteLine($"Model: {item.Model}");
                        Console.WriteLine($"Color: {item.Color}");
                        Console.WriteLine($"Horsepower: {item.Horsepower}");
                    }
                }
                input = Console.ReadLine();
            }

            double carsAverageHorsepower = 0;
            double trucksAverageHorsepower = 0;

            if (cars.Count > 0)
            {
                carsAverageHorsepower = cars.Average();

            }

            if (trucks.Count > 1)
            {
                trucksAverageHorsepower = trucks.Average();

            }

            Console.WriteLine("Cars have average horsepower of: {0:f2}.", carsAverageHorsepower);
            Console.WriteLine("Trucks have average horsepower of: {0:f2}.", trucksAverageHorsepower);

        }
    }
    class Vehichle
    {
        public string Type { get; set; }
        public string Model { get; set; }
        public string Color { get; set; }
        public int Horsepower { get; set; }

    }
}
