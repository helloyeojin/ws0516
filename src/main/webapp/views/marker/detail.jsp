<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let marker_detail = {
        init:()=>{
            $('#marker_update_btn').click(() =>{
                marker_detail.send();
            });
            $('#marker_delete_btn').click(()=>{
                let b = confirm("delete?");
                if(b){
                    location.href = '/marker/deleteimpl?id=${marker.id}';
                }
            })
        },
        send:()=>{
            $('#marker_detail_form').attr({
                action:'/marker/updateimpl',
                method:'post',
                enctype:'multipart/form-data'
            });
            $('#marker_detail_form').submit();
        }
    };
    $(function(){
        marker_detail.init();
    });
</script>

<!-- partial -->

<div class="content-wrapper">
    <div class="row">

        <div class="col-12 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Detail Marker</h4>
                    <p class="card-description">
                        Detail Marker
                    </p>

                    <form id = "marker_detail_form" class="forms-sample">
                        <input type="hidden" id="id" name="id" value="${marker.id}">
                        <input type="hidden" id="img" name="img" value="${marker.img}">
                        <div class="form-group">
                            <label for="title">Title</label>
                            <input type="text" class="form-control" name = "title" id="title" value="${marker.title}">
                        </div>
                        <div class="form-group">
                            <label for="detail">Detail</label>
                            <input type="text" class="form-control" name = "detail" id="detail"  value="${marker.detail}">
                        </div>
                        <div class="form-group">
                            <label for="star">Star</label>
                            <select class="form-control" id="star" name = "star" >
                                <option <c:if test="${marker.star=='5'}">selected</c:if>>5</option>
                                <option <c:if test="${marker.star=='4'}">selected</c:if>>4</option>
                                <option <c:if test="${marker.star=='3'}">selected</c:if>>3</option>
                                <option <c:if test="${marker.star=='2'}">selected</c:if>>2</option>
                                <option <c:if test="${marker.star=='1'}">selected</c:if>>1</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="lat">lat</label>
                            <input type="text" class="form-control" name = "lat" id="lat"  value="${marker.lat}">
                        </div>
                        <div class="form-group">
                            <label for="lng">lng</label>
                            <input type="text" class="form-control" name = "lng" id="lng"  value="${marker.lng}">
                        </div>

                        <div class="form-group">
                            <label>IMG upload</label><br/>
                            <input type="file" id = "imgfile" name="imgfile" class="btn btn-primary">
                        </div>

                        <button id = "marker_update_btn" type="button" class="btn btn-primary mr-2">Update</button>
                        <button id = "marker_delete_btn" type="button" class="btn btn-light">Delete</button>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
<!-- content-wrapper ends -->
