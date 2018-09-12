using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01_SortTimes
{
    class Program
    {
        static void Main(string[] args)
        {
            var input = Console.ReadLine().Split().ToList();

            var result = new List<string>();

            for (int i = 0; i < input.Count; i++)
            {

                DateTime dt = DateTime.ParseExact(input[i], "HH:mm", CultureInfo.InvariantCulture);
                result.Add(dt.ToString("HH:mm"));
            }

            var sortedResult = result.OrderBy(x => x).ToList();

            Console.WriteLine(string.Join(", ", sortedResult));

        }
    }
}
