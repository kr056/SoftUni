using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TheaThePhotographer
{
    class Program
    {
        static void Main(string[] args)
        {

            int totalPictures = int.Parse(Console.ReadLine());
            int filterTimeInSeconds = int.Parse(Console.ReadLine());
            int filterFactor = int.Parse(Console.ReadLine());
            int uploadTimeInSeconds = int.Parse(Console.ReadLine());

            long filteredPictures = (long)Math.Ceiling(totalPictures * (filterFactor / 100d));
            long filterTime = (long)totalPictures * filterTimeInSeconds;
            long uploadTime = filteredPictures * uploadTimeInSeconds;

            long totalTime = (filterTime + uploadTime);

            var totalTimeSpan = TimeSpan.FromSeconds(totalTime);

            Console.WriteLine(totalTimeSpan.ToString(@"d\:hh\:mm\:ss"));

        }
    }
}
