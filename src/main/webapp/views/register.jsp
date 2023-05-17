<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let adm_register = {
        init:()=>{
            $('#adm_register_btn').click(() =>{
                adm_register.send();
            });
            $('#adm_can_btn').click(()=>{
                location.href = '/';
            })
            $('#recommend_id').click(() =>{
                adm_register.giveid();
            })
        },
        send:()=>{
            $('#adm_register_form').attr({
                action:'/adm/addimpl',
                method:'post',
            });
            $('#adm_register_form').submit();
        },
        giveid: (result)=>{
            $.ajax({
                url:'/giveid',
                success:(result)=>{
                    if(result) {
                        $('#id').val(result);
                    }
                }
            });
        }
    };
    $(function(){
        adm_register.init();
    });
</script>

<!-- partial -->

<div class="content-wrapper">
    <div class="row">

        <div class="col-12 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Register Admin</h4>
                    <p class="card-description">
                        Register Admin
                    </p>

                    <form id = "adm_register_form" class="forms-sample">
                        <div class="form-group">
                            <label for="id">ID</label>
                            <input type="text" class="form-control" name = "id" id="id" placeholder="input id">
                            <button type = "button" id = "recommend_id">Recommend ID</button>
                        </div>
                        <div class="form-group">
                            <label for="pwd">PWD</label>
                            <input type="password" class="form-control" name = "pwd" id="pwd" placeholder="input pwd">
                        </div>
                        <div class="form-group">
                            <label for="lev">LEVEL</label>
                            <select class="form-control" id="lev" name = "lev" >
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                        </div>

                        <button id = "adm_register_btn" type="button" class="btn btn-primary mr-2">Register</button>
                        <button id = "adm_can_btn" type="button" class="btn btn-light">Cancel</button>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
<!-- content-wrapper ends -->
