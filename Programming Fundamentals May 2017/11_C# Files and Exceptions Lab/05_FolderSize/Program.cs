using System;
using System.Collections.Generic;
using System.Linq;
using System.IO;
using System.Text;
using System.Threading.Tasks;

namespace _05_FolderSize
{
    class Program
    {
        static void Main(string[] args)
        {

            string[] files = Directory.GetFiles("Files");
            double sum = 0;

            for (int i = 0; i < files.Length; i++)
            {
                sum += files[i].Length;
            }

            double result = (sum / 1024) / 1024;

            File.WriteAllText("output.txt", result.ToString());
        }
    }
}
