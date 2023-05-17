<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- partial -->

  <div class="content-wrapper">
    <div class="row">
      <div class="col-md-12 grid-margin">
        <div class="col-lg-12 grid-margin stretch-card">
          <div class="card">
            <div class="card-body">
              <h3 class="card-title">All Students</h3>
              <div class="table-responsive pt-3">
                <table class="table table-bordered text-center">
                  <thead>
                  <tr>
                    <th>
                      Image
                    </th>
                    <th>
                      ID
                    </th>
                    <th>
                      Name
                    </th>
                    <th>
                      Attendance
                    </th>
                    <th>
                      Email
                    </th>
                    <th>
                      Contact
                    </th>
                  </tr>
                  </thead>
                  <tbody>
                    <c:forEach var="obj" items="${std}">
                      <tr>
                        <td>
                          <a href="#" data-toggle="modal" data-target="#target${obj.id}">
                            <c:choose>
                              <c:when test="${obj.img==null || (obj.img).equals('')}"><img id="item_img" src="/images/adm.png" alt="profile img" style="width:100px; height:100px">
                              </c:when>
                              <c:when test="${obj.img!=null || !(obj.img).equals('')}"><img id="item_img" src="/uimg/${obj.img}" alt="${obj.img}" style="width:100px; height:100px"/></c:when>
                            </c:choose>
                          </a>
                        </td>
                        <td><a href="/student/detail?id=${obj.id}">${obj.id}</a></td>
                        <td>${obj.name}</td>
                        <td>
                          <div class="progress">
                            <div class="progress-bar bg-success" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                          </div>
                        </td>
                        <td>${obj.email}</td>
                        <td>${obj.contact}</td>
                      </tr>


                  <!-- Modal -->
                  <div id="target${obj.id}" class="modal fade" role="dialog">
                    <div class="modal-dialog">

                      <!-- Modal content-->
                      <div class="modal-content">
                        <div class="modal-header">
                          <h4 class="modal-title">${obj.name}</h4>
                        </div>
                        <div class="modal-body">
                          <img src="/uimg/${obj.img}" alt="${obj.img}" style="width:445px; height:445px" style="align-items: center"/>
                        </div>
                        <div class="modal-footer">
                          <a href="detail?id=${obj.id}" class="btn btn-primary" role="button">상세조회</a>
                          <a href="#" class="btn btn-outline-primary" role="button" data-dismiss="modal">닫기</a>
                        </div>
                      </div>

                    </div>
                  </div>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- content-wrapper ends -->