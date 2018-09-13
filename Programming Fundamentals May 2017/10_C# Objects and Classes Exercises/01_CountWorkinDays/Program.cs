using System;
using System.Collections.Generic;
using System.Linq;
using System.Globalization;
using System.Text;
using System.Threading.Tasks;

namespace _01_CountWorkinDays
{
    class Program
    {
        static void Main(string[] args)
        {

            var holidays = new[]
            {
                "01 01",
                "03 03",
                "01 05",
                "06 05",
                "24 05",
                "06 09",
                "22 09",
                "01 11",
                "24 12",
                "25 12",
                "26 12",
            }
            .Select(a => DateTime.ParseExact(a, "dd MM", CultureInfo.InvariantCulture)).ToArray();

            var startDate =
                DateTime.ParseExact(Console.ReadLine(), "dd-MM-yyyy", CultureInfo.InvariantCulture);
            var endDate =
                DateTime.ParseExact(Console.ReadLine(), "dd-MM-yyyy", CultureInfo.InvariantCulture);

            var workingDaysCount = 0;

            for (DateTime currentDate = startDate; currentDate <= endDate; currentDate = currentDate.AddDays(1))
            {
                var isSatOrSun =
                    currentDate.DayOfWeek == DayOfWeek.Saturday || currentDate.DayOfWeek == DayOfWeek.Sunday;

                var isHoliday = holidays
                    .Any(d => d.Day == currentDate.Day && d.Month == currentDate.Month);

                var isWorkingDay = !(isSatOrSun || isHoliday);

                if (isWorkingDay)
                {
                    workingDaysCount++;
                }
            }

            Console.WriteLine(workingDaysCount);

        }
    }
}
