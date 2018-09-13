using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _05_KeyReplacer
{
    class Program
    {
        static void Main(string[] args)
        {

            var splitPattern = @"[\<\|\\]";

            var key = Console.ReadLine();

            var arr = Regex.Split(key, splitPattern);

            var start = arr[0];
            var end = arr[2];

            var textPattern = $@"{start}(?<vip>.*?){end}";

            var text = Console.ReadLine();

            var matches = Regex.Matches(text, textPattern);

            var result = new StringBuilder();

            foreach (Match item in matches)
            {
                result.Append(item.Groups["vip"].Value);
            }

            if (result.Length > 0)
            {
                Console.WriteLine(result);
            }
            else
            {
                Console.WriteLine("Empty result");
            }

        }
    }
}
