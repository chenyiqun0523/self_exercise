Function.prototype.toString = (function() {
    var orgToString = Function.prototype.toString;
    return function(){
        return 'start:' + orgToString.apply(this,arguments) + ':end';
    }
})();


console.log(1 + function x() {alert(1);});