using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp3
{
    class Program
    {
        static void Main(string[] args)
        {

            int[] arr = Console.ReadLine().
                Split(' ').Select(int.Parse).ToArray();

            int sum = 0;
            int min = int.MaxValue;
            int max = int.MinValue;
            double average = 0;
            double size = arr.Length;

            for (int i = 0; i < arr.Length; i++)
            {
                sum += arr[i];
                if (arr[i] < min)
                {
                    min = arr[i];
                }
                if (arr[i] > max)
                {
                    max = arr[i];
                }

            }

            average = (sum / size);

            Console.WriteLine($"Min = {min}");
            Console.WriteLine($"Max = {max}");
            Console.WriteLine($"Sum = {sum}");
            Console.WriteLine($"Average = {average}");

        }
    }
}
