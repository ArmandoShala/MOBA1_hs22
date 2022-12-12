window.addEventListener('deviceorientation', function (event) {
    document.getElementById('arrow1').style.webkitTransform
  = document.getElementById('arrow1').style.transform =
        'rotateX(' + event.beta + 'deg) ' +
        'rotateY(' + event.gamma + 'deg) ' +
        'rotateZ(' + event.alpha + 'deg)';
});
