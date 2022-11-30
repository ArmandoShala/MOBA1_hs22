getOrientation = () => window.innerWidth > window.innerHeight ? 'landscape' : 'portrait';

setOrientationText = (orientation) => document.getElementById('currOrientation').innerText = orientation;
['load', 'resize'].forEach(evt => window.addEventListener(evt, () => setOrientationText(getOrientation())));
