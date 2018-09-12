using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05_ShortWordsSorted
{
    class Program
    {
        static void Main(string[] args)
        {

            char[] separators = {'.', ',', ':', ';', '(', ')', '[', ']', '\"', '\'', '\\',
            '/','!','?',' '};

            var words = Console.ReadLine().ToLower().Split(separators).ToList();

            var result = words.Where(w => w != "").Where(w => w.Length < 5)
                .OrderBy(w => w);

            Console.WriteLine(string.Join(", ", result.Distinct()));

        }
    }
}
