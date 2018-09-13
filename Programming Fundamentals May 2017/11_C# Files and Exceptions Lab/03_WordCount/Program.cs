using System;
using System.Collections.Generic;
using System.Linq;
using System.IO;
using System.Text;
using System.Threading.Tasks;

namespace _03_WordCount
{
    class Program
    {
        static void Main(string[] args)
        {

            string[] words = File.ReadAllText("words.txt").ToLower().Split(new char[] { ' ', '\n', '\r', }, StringSplitOptions.RemoveEmptyEntries);

            string[] text = File.ReadAllText("input.txt").ToLower()
             .Split(new char[] { '\n', '\r', ' ', '.', ',', '!', '?', '-' },
             StringSplitOptions.RemoveEmptyEntries);

            var result = new Dictionary<string, int>();

            foreach (var word in words)
            {
                result[word] = 0;
            }

            foreach (var input in text)
            {
                if (result.ContainsKey(input))
                {
                    result[input]++;
                }
            }

            foreach (var output in result.OrderByDescending(x => x.Value))
            {
                File.AppendAllText("output.txt", $"{output.Key} - {output.Value}\n");
            }


        }
    }
}
