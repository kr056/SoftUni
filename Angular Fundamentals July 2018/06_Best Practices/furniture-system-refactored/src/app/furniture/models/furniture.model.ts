export class FurnitureModel {
    constructor(
        public id: string,
        public make: string,
        public model: string,
        public image: string,
        public price: number,
        public year: number,
        public description: string,
        public createdBy: string,
    ) { }
}