﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace livedemo
{
    class Program
    {
        static void Main(string[] args)
        {

            int n = int.Parse(Console.ReadLine());
            int times = int.Parse(Console.ReadLine());

            if (times > 10)
            {
                Console.WriteLine($"{n} X {times} = {n * times}");

            }
            else
            {

                for (int i = times; i <= 10; i++)
                {
                    Console.WriteLine($"{n} X {i} = {n * i}");

                }
            }

        }
    }
}
