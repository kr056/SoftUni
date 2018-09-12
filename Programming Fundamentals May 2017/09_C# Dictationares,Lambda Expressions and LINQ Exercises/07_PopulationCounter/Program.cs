using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_PopulationCounter
{
    class Program
    {
        static void Main(string[] args)
        {

            var countrysInfo = new Dictionary<string, Dictionary<string, decimal>>();

            var line = Console.ReadLine();

            while (line != "report")
            {

                var tokens = line.Split('|');

                var city = tokens[0];
                var country = tokens[1];
                var population = decimal.Parse(tokens[2]);

                if (!countrysInfo.ContainsKey(country))
                {
                    countrysInfo[country] = new Dictionary<string, decimal>();
                }
                if (!countrysInfo[country].ContainsKey(city))
                {
                    countrysInfo[country][city] = population;
                }

                line = Console.ReadLine();
            }

            foreach (var country in countrysInfo.OrderByDescending(x => x.Value.Values.Sum()))
            {


                Console.Write(country.Key);
                Console.WriteLine($" (total population: {country.Value.Values.Sum()})");

                foreach (var info in country.Value.OrderByDescending(x => x.Value))
                {
                    Console.WriteLine($"=>{info.Key}: {info.Value}");
                }
            }
        }
    }
}
