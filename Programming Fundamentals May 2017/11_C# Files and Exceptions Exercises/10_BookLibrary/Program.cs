using System;
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10_BookLibrary
{
    class Program
    {
        static void Main(string[] args)
        {

            var library = new Library
            {
                Name = "Prosveta",
                Books = new List<Book>()
            };

            var input = File.ReadAllLines("input.txt");

            var booksCount = int.Parse(input[0]);

            for (int i = 1; i <= booksCount; i++)
            {
                var tokens = input.Skip(i).First().Split();

                var title = tokens[0];
                var author = tokens[1];
                var publisher = tokens[2];
                var releaseDate = DateTime.ParseExact(tokens[3], "dd.MM.yyyy",
                    CultureInfo.InvariantCulture);

                var isbn = tokens[4];
                var price = decimal.Parse(tokens[5]);

                var book = new Book
                {
                    Title = title,

                    Author = author,

                    Publisher = publisher,

                    ReleaseDate = releaseDate,

                    Isbn = isbn,

                    Price = price
                };

                library.Books.Add(book);

            }

            var authors = library.Books.Select(a => a.Author).Distinct().ToArray();

            var authorSales = new List<AuthorInfo>();

            foreach (var author in authors)
            {
                var sales = library.Books.Where(a => a.Author == author)
                    .Sum(a => a.Price);

                var authorInfo = new AuthorInfo
                {
                    Author = author,
                    Sales = sales
                };

                authorSales.Add(authorInfo);

            }
            authorSales = authorSales.OrderByDescending(a => a.Sales).ThenBy(a => a.Author).ToList();

            foreach (var authorSale in authorSales)
            {
                var author = authorSale.Author;
                var sales = authorSale.Sales;
                File.AppendAllText("output.txt", $"{author} -> {sales:f2}" + Environment.NewLine);
            }
        }
    }
    class Library
    {
        public string Name { get; set; }

        public List<Book> Books { get; set; }
    }
    class Book
    {
        public string Title { get; set; }

        public string Author { get; set; }

        public string Publisher { get; set; }

        public DateTime ReleaseDate { get; set; }

        public string Isbn { get; set; }

        public decimal Price { get; set; }
    }
    class AuthorInfo
    {
        public string Author { get; set; }
        public decimal Sales { get; set; }
    }
}
