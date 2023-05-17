let makeKakaoMap = {

    map:null,//전역변수로 선언하고 함수 안에서 호출 시 makeKakaoMap.map으로 호출한다.
    position: null,
    markers:[],

    init:()=>{
        makeKakaoMap.drawMap();
        makeKakaoMap.getLatLng();
    },
    drawMap:()=>{
        var mapContainer = document.getElementById('map'), // 지도를 표시할 div
            mapOption = {
                center: new kakao.maps.LatLng(37.5446638, 127.05649931), // 지도의 중심좌표
                level: 3 // 지도의 확대 레벨
            };
        makeKakaoMap.map = new kakao.maps.Map(mapContainer, mapOption);

        var mapTypeControl = new kakao.maps.MapTypeControl();
        makeKakaoMap.map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
        var zoomControl = new kakao.maps.ZoomControl();
        makeKakaoMap.map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

        var marker = new kakao.maps.Marker({
            // 지도 중심좌표에 마커를 생성합니다
            position: makeKakaoMap.map.getCenter()
        });
        // 지도에 마커를 표시합니다
        marker.setMap(makeKakaoMap.map);
        makeKakaoMap.markers.push(marker);
    },
    getLatLng:()=>{
        kakao.maps.event.addListener(makeKakaoMap.map, 'click', function(mouseEvent) {
            // 클릭한 위도, 경도 정보를 가져옵니다
            var latlng = mouseEvent.latLng;

            // var message = 'lat : ' + latlng.getLat();
            // message += ', lng : ' + latlng.getLng();
            // var resultDiv = document.getElementById('result');
            // resultDiv.innerHTML = message;

            var lat = $('#lat');
            var lng = $('#lng');
            lat.val(latlng.getLat());
            lng.val(latlng.getLng());

            makeKakaoMap.position = latlng;
            makeKakaoMap.makeMarker();

        });
    },
    makeMarker:()=>{
        // 이전에 생성된 마커를 제거합니다
        for (let i = 0; i < makeKakaoMap.markers.length; i++) {
            makeKakaoMap.markers[i].setMap(null);
        }
        makeKakaoMap.markers = []; // 마커 배열 초기화

        // 마커가 표시될 위치는 클릭으로 생성
        var marker = new kakao.maps.Marker({
            position: makeKakaoMap.position
        });
        // 마커가 지도 위에 표시되도록 설정합니다
        marker.setMap(null);
        marker.setMap(makeKakaoMap.map);
        makeKakaoMap.markers.push(marker);

    }

}