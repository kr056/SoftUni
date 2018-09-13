using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _01_ExtractEmails
{
    class Program
    {
        static void Main(string[] args)
        {

            var pattern = @"(?<=\s)[a-z0-9]+([-.]\w*)*@[a-z]+([-.]\w*)*(\.[a-z]+)";
            var text = Console.ReadLine();

            var matchedEmails = Regex.Matches(text, pattern);

            foreach (Match item in matchedEmails)
            {
                Console.WriteLine(item.Value);
            }

        }
    }
}
