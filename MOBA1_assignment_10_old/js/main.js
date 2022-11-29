// window.addEventListener("deviceorientation", handleOrientation, true);

// function handleOrientation(event) {
//   const absolute = event.absolute;
//   const alpha = event.alpha; // explain: https://developer.mozilla.org/en-US/docs/Web/API/Detecting_device_orientation
//   const beta = event.beta;
//   const gamma = event.gamma;
// }

//
// const gyroscope = new Gyroscope({frequency: 60});
// gyroscope.addEventListener('reading', (e) => {
//   console.log(`Angular velocity along the X-axis ${gyroscope.x}`);
//   console.log(`Angular velocity along the Y-axis ${gyroscope.y}`);
//   console.log(`Angular velocity along the Z-axis ${gyroscope.z}`);
// });
// gyroscope.start();



const gyroscope = new Gyroscope();

gyroscope.start();
gyroscope.addEventListener('reading', e => {
  console.log("X-axis: " + gyroscope.x);
  console.log("Y-axis: " + gyroscope.y);
  console.log("Z-axis: " + gyroscope.z);

  // rotate arrow arrow1 according to gyroscope
  document.getElementById("arrow1").style.transform = "rotate(" + gyroscope.x + "deg)";

});


