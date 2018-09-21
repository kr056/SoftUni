function posts() {
    class Post {
        constructor(title, content) {
            this.title = title;
            this.content = content;
        }

        toString() {
            return `Post: ${this.title}\nContent: ${this.content}`;
        }
    }

    class SocialMediaPost extends Post {
        constructor(title, content, likes, dislikes) {
            super(title, content);
            this.likes = likes;
            this.dislikes = dislikes;
            this.comments = [];
        }

        addComment(comment) {
            this.comments.push(comment);
        }

        toString() {
            let baseStr = super.toString();
            baseStr += `\nRating: ${this.likes - this.dislikes}`;

            if (this.comments.length > 0) {
                baseStr += '\nComments:';
                for (let comment of this.comments) {
                    baseStr += `\n * ${comment}`;
                }
            }
            
            return baseStr;
        }
    }

    class BlogPost extends Post {
        constructor(title, content, views) {
            super(title, content);
            this.views = views;
        }

        view() {
            this.views++;
            return this;
        }

        toString() {
            let baseStr = super.toString();
            baseStr += `\nViews: ${this.views}`;
            return baseStr;
        }
    }

    return {
        Post, SocialMediaPost, BlogPost
    };
}

let classes = posts();

let test = new classes.SocialMediaPost("TestTitle", "TestContent", 5, 10);
test.addComment("1");
test.addComment("2");
test.addComment("3");
console.log(test.toString());