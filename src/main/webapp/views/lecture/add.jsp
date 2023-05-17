<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let lec_register = {
        init:()=>{
            $('#lec_register_btn').click(() =>{
                lec_register.send();
            });
            $('#lec_can_btn').click(()=>{
                location.href = '/lecture/all';
            })
        },
        send:()=>{
            $('#lec_register_form').attr({
                action:'/lecture/addimpl',
                method:'post',
                enctype:'multipart/form-data'
            });
            $('#lec_register_form').submit();
        }
    };
    $(function(){
        lec_register.init();
    });
</script>

<!-- partial -->

<div class="content-wrapper">
    <div class="row">

        <div class="col-12 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Add Lecture</h4>
                    <p class="card-description">
                        Add Lecture
                    </p>

                    <form id = "lec_register_form" class="forms-sample">
                        <div class="form-group">
                            <label for="title">Title</label>
                            <input type="text" class="form-control" name = "title" id="title" placeholder="input title">
                        </div>
                        <div class="form-group">
                            <label for="teacher">Teacher</label>
                            <input type="text" class="form-control" name = "teacher" id="teacher" placeholder="input teacher">
                        </div>
                        <div class="form-group">
                            <label for="topic">Topic</label>
                            <select class="form-control" id="topic" name = "topic" >
                                <option>Programming</option>
                                <option>CS</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="target">Target</label>
                            <input type="text" class="form-control" name = "target" id="target" placeholder="input target">
                        </div>
                        <div class="form-group">
                            <label for="time">Time</label>
                            <input type="text" class="form-control" name = "time" id="time" placeholder="input time">
                        </div>
                        <div class="form-group">
                            <label for="price">Price</label>
                            <input type="text" class="form-control" name = "price" id="price" placeholder="input price">
                        </div>

                        <div class="form-group">
                            <label>IMG upload</label><br/>
                            <input type="file" id = "imgfile" name="imgfile" class="btn btn-primary">
<%--                            <div class="input-group col-xs-12">--%>
<%--                                <input type="text" class="form-control file-upload-info" disabled placeholder="Upload Image">--%>
<%--                                <span class="input-group-append">--%>
<%--                                    <button class="file-upload-browse btn btn-primary" type="button">Upload</button>--%>
<%--                                </span>--%>
<%--                            </div>--%>
                        </div>

                        <button id = "lec_register_btn" type="button" class="btn btn-primary mr-2">Register</button>
                        <button id = "lec_can_btn" type="button" class="btn btn-light">Cancel</button>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
<!-- content-wrapper ends -->
