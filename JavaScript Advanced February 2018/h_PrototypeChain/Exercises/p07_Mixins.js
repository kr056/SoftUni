function mixins() {
    function computerQualityMixin(classToExtend) {
        function extend() {
            this.getQualty = function () {
                return (this.processorSpeed + this.ram + this.hardDiskSpace) / 3;
            }

            this.isFast = function () {
                return this.processorSpeed > (this.ram / 4);
            }

            this.isRoomy = function () {
                return this.hardDiskSpace > Math.floor(this.ram * this.processorSpeed);
            }
            return this;
        }

        extend.call(classToExtend.prototype);

    }

    function styleMixin(classToExtend) {
        function extend() {
            this.isFullSet = function () {
                return this.manufacturer === this._keyboard.manufacturer && this.manufacturer === this._monitor.manufacturer;
            }

            this.isClassy = function () {
                return this._battery.expectedLife >= 3 && (this.color === 'Silver' || this.color === 'Black') && this.weight <= 3;
            }

            return this;
        }

        extend.call(classToExtend.prototype);
    }

    return { computerQualityMixin, styleMixin };
}