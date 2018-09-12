using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_CountNumbers
{
    class Program
    {
        static void Main(string[] args)
        {

            var nums = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            var occur = new int[1002];

            foreach (var num in nums)
            {

                occur[num]++;

            }

            for (int i = 0; i < occur.Length; i++)
            {
                if (occur[i] > 0)
                {

                    Console.WriteLine("{0} -> {1}", i, occur[i]);
                }
            }

        }
    }
}
