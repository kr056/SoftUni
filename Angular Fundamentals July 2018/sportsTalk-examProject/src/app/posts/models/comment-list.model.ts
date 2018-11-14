export class CommentListModel {
    constructor(
        public id: string,
        public commentContent: string,
        public commentAuthorName: string,
        public commentAuthorUid: string
    ) {
    }
}