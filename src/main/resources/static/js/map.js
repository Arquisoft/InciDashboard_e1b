var mapa;
	        
function initialize() {
	var oviedo = new google.maps.LatLng(43.3500,  -5.8500);
	var mapaOpciones = {
	   zoom: 15,
	   center: oviedo,
	 };
	 mapa = new google.maps.Map(document.getElementById('mapa-canvas'), mapaOpciones);
}
	
function addMarcador(localizacion,name) {
	var marcador = new google.maps.Marker({
	  position: localizacion,
	  map: mapa
	  title: name
	});
}
	   
google.maps.event.addDomListener(window, 'load', initialize);