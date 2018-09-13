using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08_MentorGroup
{
    class Program
    {
        static void Main(string[] args)
        {

            var nameDates = new Dictionary<string, string>();

            var nameComments = new Dictionary<string, string>();

            var input = Console.ReadLine();
            while(input!="end of dates")
            {
                var info = input.Split(' ', ',').ToArray();

                var name = info[0];
                var dates = info.Skip(1).ToArray();

                var i = 0;
                if (!nameDates.ContainsKey(name))
                {
                    nameDates.Add(name, dates[i]);
                    i++;
                }
            }
            var pe4ka = 21;

        }
    }
}
