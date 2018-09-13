using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _04_Weather
{
    class Program
    {
        static void Main(string[] args)
        {
            var pattern =
                new Regex(@"(?<city>[A-Z]{2})(?<temp>\d+.\d+)(?<weather>[a-zA-Z]+)\|");

            var cities = new Dictionary<string, WeatherInfo>();

            var input = Console.ReadLine();
            while (input != "end")
            {
                var match = pattern.Match(input);

                if (!match.Success)
                {
                    input = Console.ReadLine();
                    continue;
                }

                var city = match.Groups["city"].Value;
                var avgtemp = double.Parse(match.Groups["temp"].Value);
                var weather = match.Groups["weather"].Value;

                var weatherInfo = new WeatherInfo
                {
                    AverageTemperature = avgtemp,
                    Weather = weather
                };

                cities[city] = weatherInfo;

                input = Console.ReadLine();
            }

            var sortedCities = cities.
                OrderBy(a => a.Value.AverageTemperature)
                .ToDictionary(a => a.Key, a => a.Value);

            foreach (var cityInfo in sortedCities)
            {
                var city = cityInfo.Key;
                var weatherInfo = cityInfo.Value;
                Console.WriteLine($"{city} => {weatherInfo.AverageTemperature:f2} => {weatherInfo.Weather}");
            }

        }
    }
    class WeatherInfo
    {
        public double AverageTemperature { get; set; }
        public string Weather { get; set; }
    }
}
