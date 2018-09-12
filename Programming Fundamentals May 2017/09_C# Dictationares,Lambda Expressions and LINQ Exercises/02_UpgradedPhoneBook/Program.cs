using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Phonebook
{
    class Program
    {
        static void Main(string[] args)
        {

            var phonebook = new SortedDictionary<string, string>();

            while (true)
            {
                var contactInfo = Console.ReadLine().Split().ToArray();

                var instruction = contactInfo[0];

                if (instruction == "END")
                {
                    return;
                }

                switch (instruction)
                {
                    case "A":
                        var name = contactInfo[1];
                        var phone = contactInfo[2];
                        phonebook[name] = phone;
                        break;
                    case "S":
                        var name1 = contactInfo[1];

                        if (phonebook.ContainsKey(name1))
                        {
                            Console.WriteLine("{0} -> {1}", name1, phonebook[name1]);
                        }
                        else
                        {
                            Console.WriteLine("Contact {0} does not exist.", name1);
                        }
                        break;
                    case "ListAll":
                        foreach (var pair in phonebook)
                        {
                            Console.WriteLine("{0} -> {1}", pair.Key, pair.Value);

                        }
                        break;
                }
            }
        }
    }
}
