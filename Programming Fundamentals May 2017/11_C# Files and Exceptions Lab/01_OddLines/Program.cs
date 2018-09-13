using System;
using System.Collections.Generic;
using System.Linq;
using System.IO;
using System.Text;
using System.Threading.Tasks;

namespace _01_OddLines
{
    class Program
    {
        static void Main(string[] args)
        {

            string[] lines = File.ReadAllLines("input.txt");

            var result = new List<string>();

            for (int i = 0; i < lines.Length; i++)
            {
                if (i % 2 == 1)
                {
                    result.Add(lines[i]);
                }
            }

            File.AppendAllLines("output.txt", result);

        }
    }
}
