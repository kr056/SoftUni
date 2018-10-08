import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { MoviesService } from '../service/movies.service';
import { Movie } from '../models/movie.model';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {

  movie: Movie;

  constructor(private moviesService: MoviesService
    , private route: ActivatedRoute) {
    this.movie = new Movie('', '', '', [], '');
  }

  ngOnInit() {
    this.route.params.subscribe((params) => {
      let id = params['id'];

      console.log(id);

      this.moviesService.getMovie(id)
        .subscribe(movie => {
          this.movie = {
            title: movie['title'],
            poster_path: movie['poster_path'],
            release_date: movie['release_date'],
            genres: movie['genres'],
            homepage: movie['homepage'],
          };
          
          console.log(this.movie);
        })
    })
  }

}
