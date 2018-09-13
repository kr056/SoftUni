using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01_SinoTheWalker
{
    class Program
    {
        static void Main(string[] args)
        {

            var timeSinoStarts = Console.ReadLine().Split(':').ToArray();

            ulong stepsCount = ulong.Parse(Console.ReadLine());
            ulong timeInSecondsForStep = ulong.Parse(Console.ReadLine());

            var hours = ulong.Parse(timeSinoStarts[0]);
            var minutes = ulong.Parse(timeSinoStarts[1]);
            var seconds = ulong.Parse(timeSinoStarts[2]);

            var sinoTimeInSeconds = hours * 3600 + minutes * 60 + seconds;

            var takenTimeForStepsInSeconds = stepsCount * timeInSecondsForStep;

            var timeOfArrival = sinoTimeInSeconds + takenTimeForStepsInSeconds;

            var secondsToHours = timeOfArrival / 3600;
            var secondsToMinutes = (timeOfArrival % 3600) / 60;
            var secondsLeft = (timeOfArrival % 3600) % 60;

            if (secondsToHours > 23)
            {
                if (secondsToHours / 24 > 1)
                {
                    secondsToHours = secondsToHours - ((secondsToHours / 24) * 24);
                }
                else
                {
                    secondsToHours -= 24;
                }
            }

            Console.WriteLine($"Time Arrival: {secondsToHours:d2}" +
                $":{secondsToMinutes:d2}:{secondsLeft:d2}");

        }
    }
}
