<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../common/templates/backend/header.jsp" %>
<%@include file="../../common/templates/backend/navbar.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="row">
    <article class="col">
        <div class="card">
          <div class="card-header">
            List of Product
          </div>
          <div class="card-body">
              <table class="table">
                  <tr>
                      <th> Category </th>
                      <th> ID </th>
                      <th> Name </th>
                      <th> Image </th>
                      <th> Quantity </th>
                      <th> Price </th>
                      <th> Status </th>
                      <th> ManufacturedDate </th>
                      <th> Description </th>
                      <th> </th>
                  </tr>
                  
                  <jsp:useBean id="category" class="com.web.dao.CategoryDAO" scope="session"/>
                  <c:forEach items="${ListProduct}" var="items">
                      <tr>
                          <td>${category.getCategoryById(items.categories.categoryId).categoryName}</td>
                          <td>${items.productId}</td>
                          <td>${items.productName}</td>
                          <td><img src="uploads/${items.image}" alt="${items.image}" width="50px" height="50px"></td>
                          <td>${items.quantity}</td>
                          <td>${items.price}</td>
                          <td>${items.status}</td>
                          <td>${items.manufacturedDate}</td>
                          <td>${items.description}</td>
                          <td>
                              <a href="editproduct?id=${items.productId}">Edit</a> | <a href="deleteproduct?id=${items.productId}">Delete</a>
                          </td>
                      </tr>
                  </c:forEach>
                      
              </table>
          </div>
        </div>
        <div>
            Click <a href="/webbanhang2/addproduct">HERE</a> to Create New Product
        </div>
    </article>
</section>
<%@include file="../../common/templates/backend/footer.jsp" %>