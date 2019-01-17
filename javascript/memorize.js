function fib(num) {
    if (num === 0) {
        return 0;
    }
    if (num === 1) {
        return 1;
    }

    return fib(num - 1) + fib(num - 2);
}

function memorize(func) {
    var results = {};
    return function(a) {
        if (results[a]) {
            return results[a];
        } else {
            var result = func(a);
            results[a] = result;
            return result;
        }
    }
}

memorizeFib = memorize(fib);

console.log(memorizeFib(0));
console.log(memorizeFib(1));
console.log(memorizeFib(2));
console.log(memorizeFib(3));
console.log(memorizeFib(4));
console.log(memorizeFib(5));
console.log(memorizeFib(4));
console.log(memorizeFib(5));
console.log(memorizeFib(6));