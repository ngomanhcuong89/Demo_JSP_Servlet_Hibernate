<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../common/templates/backend/header.jsp" %>
<%@include file="../../common/templates/backend/navbar.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="row">
    <article class="col">
        <div class="card">
          <div class="card-header">
            List of Category
          </div>
          <div class="card-body">
              <table class="table">
                  <tr>
                      <th> ID </th>
                      <th> Name </th>
                      <th>  </th>
                  </tr>
                  <c:forEach items="${ListCategory}" var="items">
                      <tr>
                          <td>${items.categoryId}</td>
                          <td>${items.categoryName}</td>
                          <td>
                              <a href="editcategory?id=${items.categoryId}">Edit</a> | <a href="deletecategory?id=${items.categoryId}">Delete</a>
                          </td>
                      </tr>
                  </c:forEach>                
              </table>
          </div>
        </div>
        <div>
            Click <a href="/webbanhang2/addcategory">HERE</a> to Create New Category
        </div>        
    </article>
</section>
<%@include file="../../common/templates/backend/footer.jsp" %>