using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _04_CubicMessages
{
    class Program
    {
        static void Main(string[] args)
        {
            while (true)
            {
                var input = Console.ReadLine();

                if (input == "Over!")
                {
                    break;
                }

                var length = int.Parse(Console.ReadLine());
                var pattern = $@"^(?<digitsBefore>\d+)(?<message>[a-zA-Z]{{{length}}})(?<digitsAfter>\d*)[^a-zA-Z]*?$";

                var match = Regex.Match(input, pattern);

                var message = match.Groups["message"].Value;
                var digitsBefore = match.Groups["digitsBefore"].Value.ToCharArray();
                var digitsAfter = match.Groups["digitsAfter"].Value.ToCharArray();

                var indexes = new List<int>();

                for (int i = 0; i < digitsBefore.Length; i++)
                {
                    if (char.IsDigit(digitsBefore[i]))
                    {
                        var num = digitsBefore[i].ToString();
                        indexes.Add(int.Parse(num));
                    }
                }

                for (int i = 0; i < digitsAfter.Length; i++)
                {
                    if (char.IsDigit(digitsAfter[i]))
                    {
                        var num = digitsAfter[i].ToString();
                        indexes.Add(int.Parse(num));
                    }
                }

                var verificationCode = new StringBuilder();

                foreach (var index in indexes)
                {
                    if (index >= 0 && index < message.Length)
                    {
                        verificationCode.Append(message[index]);
                    }
                    else
                    {
                        verificationCode.Append(" ");
                    }
                }

                if (match.Success)
                {
                    Console.WriteLine("{0} == {1}", message, verificationCode.ToString());

                }
            }
        }
    }
}
