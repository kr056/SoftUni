using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _05_WriteToFile
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = File.ReadAllText("input.txt");

            var chars = input.Where(c => ".,?!:".IndexOf(c) == -1).ToArray();

            File.WriteAllText("output.txt", string.Join("", chars));

        }
    }
}
