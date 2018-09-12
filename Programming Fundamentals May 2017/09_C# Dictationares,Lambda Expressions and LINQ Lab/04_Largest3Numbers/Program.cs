using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_Largest3Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            var nums = Console.ReadLine().Split().Select(int.Parse).ToList();

            nums = nums.OrderByDescending(num => num).ToList();

            Console.WriteLine(String.Join(", ", nums.Take(3)));

        }
    }
}
