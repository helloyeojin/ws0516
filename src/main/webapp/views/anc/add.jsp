<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let anc_register = {
        init:()=>{
            $('#anc_register_btn').click(() =>{
                anc_register.send();
            });
            $('#anc_can_btn').click(()=>{
                location.href = '/anc/all';
            })
        },
        send:()=>{
            $('#anc_register_form').attr({
                action:'/anc/addimpl',
                method:'post',
                enctype:'multipart/form-data'
            });
            $('#anc_register_form').submit();
        }
    };
    $(function(){
        anc_register.init();
    });
</script>

<!-- partial -->

<div class="content-wrapper">
    <div class="row">

        <div class="col-12 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Add Announcement</h4>
                    <p class="card-description">
                        Add Announcement
                    </p>

                    <form id = "anc_register_form" class="forms-sample">
                        <div class="form-group">
                            <label for="writer">Writer</label>
                            <input type="text" class="form-control" name = "writer" id="writer" value = "${loginadm.id}"} readonly>
                        </div>
                        <div class="form-group">
                            <label for="title">Title</label>
                            <input type="text" class="form-control" name = "title" id="title" placeholder="input title">
                        </div>

                        <div class="form-group">
                            <label for="contents">Contents</label>
                            <textarea class="form-control" id="contents" name="contents" rows="6"></textarea>
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

                        <button id = "anc_register_btn" type="button" class="btn btn-primary mr-2">Update</button>
                        <button id = "anc_can_btn" type="button" class="btn btn-light">Delete</button>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
<!-- content-wrapper ends -->
