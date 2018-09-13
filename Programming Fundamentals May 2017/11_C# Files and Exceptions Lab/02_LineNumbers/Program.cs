using System;
using System.Collections.Generic;
using System.Linq;
using System.IO;
using System.Text;
using System.Threading.Tasks;

namespace _02_LineNumbers
{
    class Program
    {
        static void Main(string[] args)
        {

            string[] lines = File.ReadAllLines("input.txt");

            string[] result = new string[lines.Length];

            for (int i = 1; i <= lines.Length - 1; i++)
            {
                result[i] = $"{i}.{lines[i]}";
            }

            File.AppendAllLines("output.txt", result);
        }
    }
}
