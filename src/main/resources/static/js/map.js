var mapa;
var miMarcador01 = new google.maps.LatLng(43.3661,  -5.8425);
var miMarcador02 = new google.maps.LatLng(43.3639,  -5.8420);
var miMarcador03 = new google.maps.LatLng(43.3620,  -5.8412);
    
function initialize() {
  var mapaOpciones = {
    zoom: 15,
    center: miMarcador01
  };
  mapa = new google.maps.Map(document.getElementById('mapa-canvas'), mapaOpciones);

var marcador01 = new google.maps.Marker({
      position: miMarcador01,
      map: mapa,
      title: 'Marcador 01'
  });

var marcador02 = new google.maps.Marker({
      position: miMarcador02,
      map: mapa,
      title: 'Marcador 02'
  });
    
var marcador03 = new google.maps.Marker({
      position: miMarcador03,
      map: mapa,
      title: 'Marcador 03'
  });

}

google.maps.event.addDomListener(window, 'load', initialize);