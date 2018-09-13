using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace _08_PersonalException
{
    public class MyFirstException : Exception
    {
        const string message = "My first exception is awesome!!!";
        public MyFirstException()
        {
        }
        public MyFirstException(string message)
            : base(message)
        {
        }
        public MyFirstException(string message, Exception inner)
            : base(message, inner)
        {
        }
        protected MyFirstException(SerializationInfo info, StreamingContext context)
            : base(info, context)
        {
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                while (true)
                {
                    var num = int.Parse(Console.ReadLine());

                    if (num < 0)
                    {
                        throw new MyFirstException();

                    }

                    Console.WriteLine(num);
                }
            }
            catch (MyFirstException ex)
            {
                Console.WriteLine("My first exception is awesome!!!");
            }

        }
    }
}
