export class PostCreateModel {
    constructor(
        public postTitle: string,
        public postImage: string,
        public postContent: string,
        public postCategory: string,
        public postDate: number,
        public postAuthor: string,
        public postAuthorUid: string,
    ) {
    }
}