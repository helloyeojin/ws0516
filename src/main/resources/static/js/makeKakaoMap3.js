let makeKakaoMap3 = {

    init: async () => {
        var mapContainer = document.getElementById('map');
        var mapOption = {
            center: new kakao.maps.LatLng(37.5446638, 127.05649931),
            level: 5
        };
        var map = new kakao.maps.Map(mapContainer, mapOption);

        try {
            const positions = await makeKakaoMap3.getdata(); // 비동기적으로 데이터를 가져옴
            for (var i = 0; i < positions.length; i++) {
                var markerPosition = new kakao.maps.LatLng(positions[i].latlng.lat, positions[i].latlng.lng);
                var marker = new kakao.maps.Marker({
                    map: map,
                    position: markerPosition
                });
                var infowindow = new kakao.maps.InfoWindow({
                    content: positions[i].content
                });
                kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
                kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
            }
        } catch (error) {
            console.log("Error:", error);
        }

        // 인포윈도우를 표시하는 클로저를 만드는 함수입니다
        function makeOverListener(map, marker, infowindow) {
            return function() {
                infowindow.open(map, marker);
            };
        }
        // 인포윈도우를 닫는 클로저를 만드는 함수입니다
        function makeOutListener(infowindow) {
            return function() {
                infowindow.close();
            };
        }

    },
    getdata: () => {
        return new Promise((resolve, reject) => {
            $.ajax({
                url: '/givemarker',
                success: (result) => {
                    resolve(result); // 비동기 작업이 성공한 경우 데이터 반환
                },
                error: (error) => {
                    reject(error); // 비동기 작업이 실패한 경우 에러 반환
                }
            });
        });
    },

};