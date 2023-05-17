<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let std_add = {
        init:()=>{
            $('#std_add_btn').click(() =>{
                std_add.send();
            });
            $('#std_can_btn').click(()=>{
                location.href = '/student/all';
            })
        },
        send:()=>{
            $('#std_add_form').attr({
                action:'/student/addimpl',
                method:'post',
            });
            $('#std_add_form').submit();
        }
    };
    $(function(){
        std_add.init();
    });
</script>

<!-- partial -->

<div class="content-wrapper align-items-center">
    <div class="row justify-content-center">

        <div class="col-6 grid-margin">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Add Student</h4>
                    <p class="card-description">
                        Fill in the form below to add new student
                    </p>

                    <form id = "std_add_form" class="forms-sample">
                        <div class="form-group">
                            <label for="id">ID</label>
                            <input type="text" class="form-control" name = "id" id="id" placeholder="Input ID">
                        </div>
                        <div class="form-group">
                            <label for="pwd">PWD</label>
                            <input type="password" class="form-control" name = "pwd" id="pwd" placeholder="Input Password">
                        </div>
                        <div class="form-group">
                            <label for="name">NAME</label>
                            <input type="text" class="form-control" id="name" name = "name" placeholder="Input Name">
                        </div>
                        <div class="form-group">
                            <label for="email">EMAIL</label>
                            <input type="text" class="form-control" id="email" name = "email" placeholder="Input Email">
                        </div>
                        <div class="form-group">
                            <label for="contact">CONTACT</label>
                            <input type="text" class="form-control" id="contact" name = "contact" placeholder="Input Mobile Phone Number">
                        </div>

                        <button id = "std_add_btn" type="button" class="btn btn-primary mr-2">Add</button>
                        <button id = "std_can_btn" type="button" class="btn btn-light">Cancel</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- content-wrapper ends -->
