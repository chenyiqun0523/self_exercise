String.prototype.repeat = function(times) {
    let reminder = times % 2;
    times -= reminder;

    if (!times) {
        if (reminder) {
            return this;
        } else {
            return "";
        }
    }

    let result = reminder ? this : "";
    let half = this.repeat(times/2);
    result += (half + half);
    return result;
}

var myString = "Come";
console.log(myString.repeat(10));