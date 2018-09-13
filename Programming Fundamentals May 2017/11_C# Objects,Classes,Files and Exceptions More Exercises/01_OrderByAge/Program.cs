using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01_OrderByAge
{
    class Program
    {
        static void Main(string[] args)
        {

            string input = Console.ReadLine();

            List<Person> persons = new List<Person>();

            while (input != "End")
            {

                string[] tokens = input.Split().ToArray();

                string name = tokens[0];
                string id = tokens[1];
                int age = int.Parse(tokens[2]);

                Person person = new Person
                {
                    Name = name,
                    ID = id,
                    Age = age
                };

                persons.Add(person);
                input = Console.ReadLine();

            }

            var personsSorted = persons.OrderBy(a => a.Age);

            foreach (var info in personsSorted)
            {
                Console.WriteLine($"{info.Name} with ID: {info.ID} is {info.Age} years old.");
            }

        }
    }

    class Person
    {
        public string Name { get; set; }
        public string ID { get; set; }
        public int Age { get; set; }
    }
}
