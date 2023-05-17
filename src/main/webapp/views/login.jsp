<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let adm_login = {
        init:()=>{
            $('#adm_login_btn').click(() =>{
                adm_login.send();
            });
            $('#adm_can_btn').click(()=>{
                location.href = '/';
            })
        },
        send:()=>{
            $('#adm_login_form').attr({
                action:'/adm/loginimpl',
                method:'post'
            });
            $('#adm_login_form').submit();
        }
    };
    $(function(){
        adm_login.init();
    });
</script>

<!-- partial -->

<div class="content-wrapper">
    <div class="row">

        <div class="col-12 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Login Admin</h4>
                    <p class="card-description">
                        Login Admin
                    </p>

                    <form id = "adm_login_form" class="forms-sample">
                        <div class="form-group">
                            <label for="id">ID</label>
                            <input type="text" class="form-control" name = "id" id="id" placeholder="input id">
                        </div>
                        <div class="form-group">
                            <label for="pwd">PWD</label>
                            <input type="password" class="form-control" name = "pwd" id="pwd" placeholder="input pwd">
                        </div>

                        <button id = "adm_login_btn" type="button" class="btn btn-primary mr-2">Login</button>
                        <button id = "adm_can_btn" type="button" class="btn btn-light">Cancel</button>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
<!-- content-wrapper ends -->
