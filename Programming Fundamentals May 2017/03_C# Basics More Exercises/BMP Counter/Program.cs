using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BMPCounter
{
    class Program
    {
        static void Main(string[] args)
        {

            int beatsPerMinute = int.Parse(Console.ReadLine());
            int beatsCount = int.Parse(Console.ReadLine());

            double secondsForOneBeat = beatsPerMinute / 60.0;
            secondsForOneBeat = beatsCount / (secondsForOneBeat);

            int minutes = (int)secondsForOneBeat / 60;
            int seconds = (int)secondsForOneBeat % 60;

            Console.WriteLine($"{Math.Round((beatsCount / 4.0), 1)} bars - {minutes}m {seconds}s");

        }
    }
}
