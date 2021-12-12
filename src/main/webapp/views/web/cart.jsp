<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="main">
  <div class="container">
    <!-- BEGIN SIDEBAR & CONTENT -->
    <div class="row margin-bottom-40">
      <!-- BEGIN CONTENT -->
      <div class="col-md-12 col-sm-12">
        <h1>Shopping cart</h1>
        <div class="goods-page">
          <div class="goods-data clearfix">
            <div class="table-wrapper-responsive">
              <table summary="Shopping cart">
                <tr>
                  <th class="goods-page-image">Image</th>
                  <th class="goods-page-description">Name</th>
                  <th class="goods-page-quantity">Quantity</th>
                  <th class="goods-page-price">Unit price</th>
                  <th class="goods-page-total" colspan="2">Total</th>
                </tr>
                 <c:if test="${sessionScope.cart == null}">
                  <tr>
                      <td colspan="5">Please add some products into Cart!!!</td>
                  </tr>
                  </c:if>
                  <c:forEach items="${sessionScope.cart}" var="map">
                <tr>
                  <td class="goods-page-image">
                    <a href="/productdetail?pid=${ map.value.product.pId }"><img src="${ map.value.product.pImage}" alt="${ map.value.product.pName }"></a>
                  </td>
                  <td class="goods-page-description"> 
                    <h3><a href="/productdetail?pid=${ map.value.product.pId }">${ map.value.product.pName }</a></h3>
                  </td>
                  <td class="goods-page-quantity">
                    <div class="product-quantity">
                        <input type="number" 
                        value= "${ map.value.quantity }" 
                        onblur= "updateCartItem(this, ${ map.value.product.pId })"
                        class = "form-control" id="product-quantity">
                      </div> 
                  </td>
                  <td class="goods-page-price">
                    <strong><span>$</span>${ map.value.price }</strong>
                  </td>
                  <td class="goods-page-total">
                    <strong><span>$</span>${ map.value.price*map.value.quantity }</strong>
                  </td>
                  <%-- <td class="del-goods-col">
                    <button class="del-goods" onclick= "deleteCartItem(${ map.value.product.pId })">&nbsp;</button>
                  </td> --%>
                </tr>
                </c:forEach>
              </table>
            </div>

            <%-- <div class="shopping-total">
              <c:if test="${sessionScope.cart == null}">
                <ul>
                  <li>
                    <em>Number of products</em>
                    <strong class="price"><span id = "cart_quantity">${ cart_stats.total_quantity }</span></strong>
                  </li>
                  <li class="shopping-total-price">
                    <em>Total</em>
                    <strong class="price"><span id = "cart_amount">$${ cart_stats.total_amount }</span></strong>
                  </li>
                </ul>             
             </c:if>
            </div> --%>

          </div>
          <a href="/product"><button class="btn btn-default" type="submit">Continue shopping <i class="fa fa-shopping-cart"></i></button></a>
          <c:choose>
          <c:when test="${sessionScope.acc != null}">
            <c:if test="${sessionScope.cart != null}">
              <a href="/user-checkout" class="text-light"><button class="btn btn-primary" type="button">Checkout <i class="fa fa-check"></i></button></a> 
             </c:if>
          </c:when>
          <c:otherwise>
          <div> 
          <a href="/user-login?next=/cart">Login to finish payment</a>
          </div>
          </c:otherwise>
          </c:choose>
        </div>
      </div>
      <!-- END CONTENT -->
    </div>
    <!-- END SIDEBAR & CONTENT -->

    <%-- <!-- BEGIN SIMILAR PRODUCTS -->
    <div class="row margin-bottom-40">
      <div class="col-md-12 col-sm-12">
        <h2>Most popular products</h2>
        <div class="owl-carousel owl-carousel4">
          
          {% for p in bestseller_products %}
          <div>
            <div class="product-item">
              <div class="pi-img-wrapper">
                <img src="{{p.image}}" class="img-responsive" alt="Berry Lace Dress">
                <div>
                  <a href="{{ p.image }}" class="btn btn-default fancybox-button">Zoom</a>
                  <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                </div>
              </div>
              <h3><a href="/item-detail?product-id={{ p.id }}">{{p.name}}</a></h3>
              <div class="pi-price">${{p.price}}</div>
              <a href="javascript:;" class="btn btn-default add2cart {% if p.amount|int==0 %}disabled{% endif %}" onclick="addToCart({{p.id}}, '{{p.name}}', {{p.price}}, '{{p.image}}', '{{p.chip}}', {{p.ram}})">Add to cart</a>
            </div>
          </div>
          {% endfor %}
        
        </div>
      </div>
    </div>
    <!-- END SIMILAR PRODUCTS --> --%>
  </div>
</div>