export class CommentCreateModel {
    constructor(
        public commentContent: string,
        public commentAuthorName: string,
        public commentAuthorUid: string
    ) {
    }
}