<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- partial -->

<div class="content-wrapper">
    <div class="row">

        <div class="col-lg-12 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Lecture List</h4>
<%--                    <p class="card-description">--%>
<%--                        Add class <code>.table-striped</code>--%>
<%--                    </p>--%>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>IMG</th>
                                <th>ID</th>
                                <th>Title</th>
                                <th>Teacher</th>
                                <th>Topic</th>
                                <th>Target</th>
                                <th>Rdate</th>
                                <th>Time</th>
                                <th>Price</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="obj" items="${lecture}">
                                <tr>
                                    <td class="py-1"><img src="/uimg/${obj.img}"></td>
                                    <td><a href="/lecture/detail?id=${obj.id}">${obj.id}</a></td>
                                    <td>${obj.title}</td>
                                    <td>${obj.teacher}</td>
                                    <td>${obj.topic}</td>
                                    <td>${obj.target}</td>
                                    <td>${obj.rdate}</td>
                                    <td>${obj.time}</td>
                                    <td>${obj.price}</td>
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
