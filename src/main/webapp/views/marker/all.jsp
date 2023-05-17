<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- partial -->

<div class="content-wrapper">
    <div class="row">

        <div class="col-lg-12 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Marker List</h4>

                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>IMG</th>
                                <th>ID</th>
                                <th>Title</th>
                                <th>Lat</th>
                                <th>Lng</th>
                                <th>Star</th>
                                <th>Detail</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="obj" items="${marker}">
                                <tr>
                                    <td class="py-1"><img src="/uimg/${obj.img}"></td>
                                    <td><a href="/marker/detail?id=${obj.id}">${obj.id}</a></td>
                                    <td>${obj.title}</td>
                                    <td>${obj.lat}</td>
                                    <td>${obj.lng}</td>
                                    <td>${obj.star}</td>
                                    <td>${obj.detail}</td>

                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
                <!-- content-wrapper ends -->
