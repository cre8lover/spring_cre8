<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

  <head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
      .searchBox {
        margin: 20px 0;
      }

      .listBox {
        max-width: 500px;
      }

      .listInner {
        background-color: #dedede;
        margin: 10px 5px;
        padding: 4px;
      }

      .country {
        font-weight: bold;
      }

    </style>
  </head>

  <body>
    <div class="searchBox">
      <label>수도: <input type="text" id="search" onkeyup="filter()" placeholder="수도를 검색하세요." /></label>

    </div>

    <div class="listBox">
      <div class="listInner">
        <span class="country">Australia</span>
        <span class="city">Canberra</span>
      </div>
      <div class="listInner">
        <span class="country">Argentina</span>
        <span class="city">Buenos Aires</span>
      </div>
      <div class="listInner">
        <span class="country">Austria</span>
        <span class="city">Vienna</span>
      </div>
      <div class="listInner">
        <span class="country">Bahamas</span>
        <span class="city">Nassau</span>
      </div>
      <div class="listInner">
        <span class="country">Belgium</span>
        <span class="city">Brussels</span>
      </div>
      <div class="listInner">
        <span class="country">Canada</span>
        <span class="city">Ottawa</span>
      </div>
      <div class="listInner">
        <span class="country">Chile</span>
        <span class="city">Santiago</span>
      </div>
      <div class="listInner">
        <span class="country">China</span>
        <span class="city">Beijing</span>
      </div>
      <div class="listInner">
        <span class="country">Cuba</span>
        <span class="city">Havana</span>
      </div>
      <div class="listInner">
        <span class="country">Czechia</span>
        <span class="city">Prague</span>
      </div>
      <div class="listInner">
        <span class="country">Denmark</span>
        <span class="city">Copenhagen</span>
      </div>
      <div class="listInner">
        <span class="country">Ecuador</span>
        <span class="city">Quito</span>
      </div>
      <div class="listInner">
        <span class="country">Egypt</span>
        <span class="city">Cairo</span>
      </div>
      <div class="listInner">
        <span class="country">Finland</span>
        <span class="city">Helsinki</span>
      </div>
      <div class="listInner">
        <span class="country">France</span>
        <span class="city">Paris</span>
      </div>
      <div class="listInner">
        <span class="country">Germany</span>
        <span class="city">Berlin</span>
      </div>
      <div class="listInner">
        <span class="country">Greece</span>
        <span class="city">Athens</span>
      </div>
      <div class="listInner">
        <span class="country">Hungary</span>
        <span class="city">Budapest</span>
      </div>
      <div class="listInner">
        <span class="country">India</span>
        <span class="city"> New Delhi</span>
      </div>
    </div>

    <script>
      function filter() {
        let search = document.getElementById("search").value.toLowerCase();
        let listInner = document.getElementsByClassName("listInner");

        for (let i = 0; i < listInner.length; i++) {
          city = listInner[i].getElementsByClassName("city");
          country = listInner[i].getElementsByClassName("country");
          if (city[0].innerHTML.toLowerCase().indexOf(search) != -1 ||
            country[0].innerHTML.toLowerCase().indexOf(search) != -1
          ) {
            listInner[i].style.display = "flex"
          } else {
            listInner[i].style.display = "none"
          }
        }
      }

    </script>
  </body>

</html>