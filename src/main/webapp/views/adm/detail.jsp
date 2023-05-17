<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let adm_detail = {
        init:()=>{
            $('#adm_update_btn').click(() =>{
                adm_detail.send();
            });
            $('#adm_delete_btn').click(()=>{
                let b = confirm("wanna delete?");
                if(b){
                    location.href = '/adm/deleteimpl?id=${adm.id}';
                }
            });
        },
        send:()=>{
            $('#adm_detail_form').attr({
                action:'/adm/updateimpl',
                method:'post',
            });
            $('#adm_detail_form').submit();
        }
    };
    $(function(){
        adm_detail.init();
    });
</script>

<!-- partial -->

<div class="content-wrapper">
    <div class="row">

        <div class="col-12 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Admin Detail</h4>
                    <p class="card-description">
                        Admin Detail
                    </p>

                    <form id = "adm_detail_form" class="forms-sample">
                        <div class="form-group">
                            <label for="id">ID</label>
                            <input type="text" class="form-control" name = "id" id="id" value="${adm.id}" readonly>
                        </div>
                        <div class="form-group">
                            <label for="pwd">PWD</label>
                            <input type="password" class="form-control" name = "pwd" id="pwd">
                        </div>
                        <div class="form-group">
                            <label for="lev">LEVEL</label>
                            <select class="form-control" id="lev" name = "lev" >
                                <option <c:if test="${adm.lev=='1'}">selected</c:if>>1</option>
                                <option <c:if test="${adm.lev=='2'}">selected</c:if>>2</option>
                                <option <c:if test="${adm.lev=='3'}">selected</c:if>>3</option>
                            </select>
                        </div>

                        <button id = "adm_update_btn" type="button" class="btn btn-primary mr-2">Update</button>
                        <button id = "adm_delete_btn" type="button" class="btn btn-light">Delete</button>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
<!-- content-wrapper ends -->
