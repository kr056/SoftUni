export class CreateFurnitureModel {
    constructor(
        public make: string,
        public model: string,
        public image: string,
        public price: number,
        public year: number,
        public description: string,
        public material?: string,
    ) { }
}