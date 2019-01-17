Date.prototype.nextDay = function() {
    var currentDay = this.getDate();
    return new Date(this.setDate(currentDay + 1));
}