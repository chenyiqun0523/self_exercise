function add(a, b, c, d, e) {
  return a + b + c + d + e;
}

function callLater(func) {
  var args = Array.prototype.slice.call(arguments, 1);
  //console.log("args " + args);
  return function() {
    //console.log(func);
    var args2 = Array.prototype.slice.call(arguments);
    //console.log("args2 " + args2);
    return func.apply(this, args.concat(args2));
  };
}

console.log(callLater(add, 1)(2, 3, 4, 5));
console.log(callLater(add, 1, 2)(3, 4, 5));
console.log(callLater(callLater(add, 1, 2), 3)(4, 5));

function callLater2(func) {
    var args = Array.prototype.slice.call(arguments,1);
    return func.bind(this, args);
}