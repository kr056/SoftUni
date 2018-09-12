using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03_LastKNumbersSums
{
    class Program
    {
        static void Main(string[] args)
        {

            int n = int.Parse(Console.ReadLine());
            int k = int.Parse(Console.ReadLine());

            long[] arr = new long[n];
            arr[0] = 1;

            for (int i = 1; i < n; i++)
            {
                if (k > i)
                {
                    arr[i] = arr.Sum();
                }
                else
                {
                    arr[i] = arr.Where(x => x != 0).Reverse().Take(k).ToArray().Sum();
                }
            }

            Console.WriteLine(string.Join(", ", arr));
        }
    }
}
