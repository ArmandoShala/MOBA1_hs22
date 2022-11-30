toggleClass = () => {
    var element = document.getElementById("exampleImage");
    if(document.getElementById("togBtn").checked === true){
        element.classList.remove("small");
        element.classList.add("big");

    } else {
        element.classList.remove("big");
        element.classList.add("small");
    }
}
