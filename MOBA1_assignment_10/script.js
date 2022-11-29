toggleClass = () => {
    var element = document.getElementById("imgWrapper");
    if (element.classList.contains("big")) {
        element.classList.remove("big");
        element.classList.add("small");
    } else {
        element.classList.remove("small");
        element.classList.add("big");
    }
    document.getElementById("currClass").innerHTML = element.className;
}
