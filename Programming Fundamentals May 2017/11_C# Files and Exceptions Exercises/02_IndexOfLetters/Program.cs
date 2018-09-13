using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_IndexOfLetters
{
    class Program
    {
        static void Main(string[] args)
        {

            var input = File.ReadAllText("input1.txt");

            var work = input.ToCharArray();

            for (int i = 0; i < work.Length; i++)
            {
                var letter = work[i];
                string text = " -> ";
                var num = work[i] - 'a';

                var concat = letter + text + num;
                File.AppendAllText("output1.txt", concat.ToString() + Environment.NewLine);
            }
        }
    }
}
