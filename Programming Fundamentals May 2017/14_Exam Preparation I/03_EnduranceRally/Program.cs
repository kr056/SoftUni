using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_EnduranceRally
{
    class Program
    {
        static void Main(string[] args)
        {

            var driversNames = Console.ReadLine().Split();

            var zones = Console.ReadLine().Split().Select(double.Parse).ToArray();

            var checkpoints = Console.ReadLine().Split().Select(int.Parse).ToArray();

            foreach (var driver in driversNames)
            {

                double startFuel = (double)driver.First();
                for (int j = 0; j < zones.Length; j++)
                {

                    var currentIndex = j;
                    var currentZone = zones[j];

                    var isCheckPoint = checkpoints.Contains(currentIndex)
                        ? startFuel += currentZone
                        : startFuel -= currentZone;

                    if (startFuel <= 0)
                    {
                        Console.WriteLine($"{driver} - reached {currentIndex}");
                        break;
                    }
                }

                if (startFuel > 0)
                {
                    Console.WriteLine($"{driver} - fuel left {startFuel:f2}");
                }
            }

        }
    }
}
