﻿using System;
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _09_BookLibrary
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
            var currentLine = 0;

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
                currentLine = i;
            }

            var bug = 5;
            var givenDate = DateTime.ParseExact(input.Last(), "dd.MM.yyyy",
                    CultureInfo.InvariantCulture);

            var filteredBooks = library.Books.Where(a => a.ReleaseDate > givenDate).OrderBy(a => a.ReleaseDate).ThenBy(a => a.Title).ToArray();

            foreach (var book in filteredBooks)
            {
                File.AppendAllText("output.txt", $"{book.Title} -> {book.ReleaseDate:dd.MM.yyyy}" + Environment.NewLine);
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

        class TitleInfo
        {
            public string Title { get; set; }
            public DateTime ReleaseDate { get; set; }
        }
    }
}
