using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConvertSpeedUnits
{
    class Program
    {
        static void Main(string[] args)
        {

            int meters = int.Parse(Console.ReadLine());
            float hours = float.Parse(Console.ReadLine());
            float minutes = float.Parse(Console.ReadLine());
            float seconds = float.Parse(Console.ReadLine());

            float timeInHours = hours + (minutes / 60) + (seconds / 3600);

            float kilometersPerHour = (meters / 1000) / timeInHours;

            float metersPerSecond = kilometersPerHour / 3.6f;

            float milesPerHour = (meters / 1609f) / timeInHours;

            Console.WriteLine(metersPerSecond);
            Console.WriteLine(kilometersPerHour);
            Console.WriteLine(milesPerHour);

        }
    }
}
