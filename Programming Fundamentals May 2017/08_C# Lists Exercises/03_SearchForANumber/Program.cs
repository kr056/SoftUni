using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_SearchForANumber
{
    class Program
    {
        static void Main(string[] args)
        {

            var nums = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            var arr = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            var result = new List<int>();
            var counter = 0;

            for (int i = 0; i < arr[0]; i++)
            {
                result.Add(nums[i]);
            }

            for (int i = 0; i < arr[1]; i++)
            {

                result.RemoveAt(i);

                i--;
                counter++;
                if (counter == arr[1])
                {
                    break;
                }

            }

            if (result.Contains(arr[2]))
            {
                Console.WriteLine("YES!");
            }
            else
            {
                Console.WriteLine("NO!");
            }
        }
    }
}
