using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_AdvertismentMessage
{
    class Program
    {
        static void Main(string[] args)
        {
            var input = File.ReadAllText("input.txt");

            var n = int.Parse(input);

            string[] phrases = new string[]
            { "Excellent product.", "Such a great product.", "I always use that product."
            , "Best product of its category.", "Exceptional product."
            , "I can’t live without this product." };

            string[] events = new string[]
            { "Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!"
            , "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied."
            , "I feel great!" };

            string[] authors = new string[]
            { "Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};

            string[] cities = new string[]
                {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

            Random round = new Random();

            for (int i = 0; i < n; i++)
            {

                int rndPhrases = round.Next(0, phrases.Length);
                int rndEvents = round.Next(0, events.Length);
                int rndAuthours = round.Next(0, authors.Length);
                int rndCities = round.Next(0, cities.Length);

                var print1 = phrases[rndPhrases]
                    + " " + phrases[rndEvents]
                    + " " + phrases[rndAuthours]
                    + " - " + phrases[rndCities];

                File.AppendAllText("output.txt", print1 + Environment.NewLine);

            }
        }
    }
}
