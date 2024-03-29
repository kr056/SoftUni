import { Article } from '../models/article.model';
import { data } from './seed';

export class ArticleData {
    getData(): Article[] {
        let articles: Article[] = [];

        for (let i = 0; i < data.length; i++) {
            let article = data[i];

            articles[i] = new Article(article.title, article.description, article.author, article.imageUrl);
        }

        return articles;
    }
}