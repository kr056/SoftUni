﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _06_ReplaceATag
{
    class Program
    {
        static void Main(string[] args)
        {

            string text = Console.ReadLine();

            while (text != "end")
            {
                string pattern = @"<a.*?href.*?=(.*)>(.*?)<\/a>";
                string replacement = @"[URL href=$1]$2[/URL]";
                string replaced = Regex.Replace(text, pattern, replacement);
                Console.WriteLine(replaced);

                text = Console.ReadLine();
            }

        }
    }
}
