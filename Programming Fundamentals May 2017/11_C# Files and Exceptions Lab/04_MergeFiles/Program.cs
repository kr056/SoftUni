using System;
using System.Collections.Generic;
using System.Linq;
using System.IO;
using System.Text;
using System.Threading.Tasks;

namespace _04_MergeFiles
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input1 = File.ReadAllLines("input1.txt");

            string[] input2 = File.ReadAllLines("input2.txt");

            var result = input1.Concat(input2).OrderBy(x => x).ToArray();

            File.WriteAllLines("output.txt", result);
        }
    }
}
