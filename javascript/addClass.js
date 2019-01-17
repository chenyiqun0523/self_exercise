var addClass = function(el, newClass) {
    if (typeof el === "string") {
        el = document.getElementById(el);
    }
    //check if el and newClass undefined
    //check if el is not an HTML element <div> / <p>
    if (!el || !el.nodeType == 1 || !newClass) {
        return;
    }

    //have there is classList.add function, use it
    if (el.classList && typeof el.classList.add === "function") {
        el.classList.add(newClass);
        return;
    }

    //no there is not yet a class property
    if (!el.className) {
        el.className = newClass;
        return;
    }
    if ((new RegExp("\\b"+newClass+"\\b")).test(el.className)) {
        return;
    }

    //if no classList.add funciton, just add to className string
    el.className += " " + newClass;
}