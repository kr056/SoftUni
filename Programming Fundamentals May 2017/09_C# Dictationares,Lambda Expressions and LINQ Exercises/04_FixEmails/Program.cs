using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04_FixEmails
{
    class Program
    {
        static void Main(string[] args)
        {

            var userInfo = new Dictionary<string, string>();

            var name = String.Empty;
            var email = String.Empty;

            while (true)
            {
                name = Console.ReadLine();
                if (name == "stop")
                {
                    break;
                }
                email = Console.ReadLine();
                if (email.EndsWith("us") || email.EndsWith("uk"))
                {

                }
                else
                {
                    userInfo[name] = email;
                }

            }

            foreach (var pair in userInfo)
            {
                Console.WriteLine("{0} -> {1}", pair.Key, pair.Value);
            }
        }
    }
}
