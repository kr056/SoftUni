using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06_FixEmails
{
    class Program
    {
        static void Main(string[] args)
        {
            var userInfo = new Dictionary<string, string>();

            var input = File.ReadAllLines("input.txt");

            var name = String.Empty;
            var email = String.Empty;
            var i = 0;

            while (true)
            {
                name = input[i];
                if (name == "stop")
                {
                    break;
                }
                email = input[i + 1];

                if (email.EndsWith("us") || email.EndsWith("uk"))
                {

                }
                else
                {
                    userInfo[name] = email;

                }

                i = i + 2;
            }

            foreach (var pair in userInfo)
            {
                var key = pair.Key;
                var value = pair.Value;
                var print = key + " -> " + value;

                File.AppendAllText("output.txt", print + Environment.NewLine);
            }
        }
    }
}
