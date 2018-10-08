export class Movie{
    constructor(
        public title: string,
        public poster_path: string,
        public release_date: string,
        public genres: string[],
        public homepage: string,
    ) { }
}