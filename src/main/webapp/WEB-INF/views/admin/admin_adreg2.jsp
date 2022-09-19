<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<head>
  <link href='https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css' rel='stylesheet' type='text/css'>
  <link href='//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.2.0/css/datepicker.min.css' rel='stylesheet' type='text/css'>
  <link href='//cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/1.8/css/bootstrap-switch.css' rel='stylesheet' type='text/css'>
  <link href='https://davidstutz.github.io/bootstrap-multiselect/css/bootstrap-multiselect.css' rel='stylesheet' type='text/css'>
  <script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js' type='text/javascript'></script>
  <script src='//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.0/js/bootstrap.min.js' type='text/javascript'></script>
  <script src='//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.2.0/js/bootstrap-datepicker.min.js' type='text/javascript'></script>
  <script src='//cdnjs.cloudflare.com/ajax/libs/bootstrap-switch/1.8/js/bootstrap-switch.min.js' type='text/javascript'></script>
  <script src='https://davidstutz.github.io/bootstrap-multiselect/js/bootstrap-multiselect.js' type='text/javascript'></script>
</head>
<body>
  <div class='container'>
    <div class='panel panel-primary dialog-panel'>
      <div class='panel-heading'>
        <h4>광고상품수정</h4>
      </div>
	  <c:set value="${market}" var="modify" />
      <div class='panel-body'>
        <form method="post" class='form-horizontal' enctype="multipart/form-data" id="insert" role='form' action="<%= request.getContextPath() %>/master/adupdate">
          <div class='form-group'>
            <label class='control-label col-md-2 col-md-offset-2' for='id_accomodation'>카테고리</label>
            <div class='col-md-2'>
           <input type="hidden" name="seqno" value="${modify.marSeqno }">
              <select class='form-control' name ="marcate" id='id_accomodation'>
                <option value="포털마케팅" ${modify.marCategory == '포털마케팅' ? 'selected': '' }>포털마케팅</option>
                <option value="SNS마케팅" ${modify.marCategory == 'SNS마케팅' ? 'selected': '' }>SNS마케팅</option>
                <option value="바이럴마케팅" ${modify.marCategory == '바이럴마케팅' ? 'selected': '' }>바이럴마케팅</option>
                <option value="유튜브마케팅" ${modify.marCategory == '유튜브마케팅' ? 'selected': '' }>유튜브마케팅</option>
                <option value="체험단마케팅" ${modify.marCategory == '체험단마케팅' ? 'selected': '' }>체험단마케팅</option>
             </select>
            </div>
          </div>
          <div class='form-group'>
            <label class='control-label col-md-2 col-md-offset-2' for='id_title'>상품명</label>
            <div class='col-md-8'>
              <div class='col-md-6 indent-small'>
                <div class='form-group internal'>
                  <input class='form-control' id='id_first_name' name="name" value="${modify.marProduct }" placeholder='상품명' type='text'>
                </div>
              </div>
            </div>
          </div>
          <div class='form-group'>
            <label class='control-label col-md-2 col-md-offset-2' >상품가격</label>
            <div class='col-md-8'>
              <div class='col-md-6 indent-small'>
                <div class='form-group internal'>
                  <input class='form-control' id='id_children' name = "price" value="${modify.marPrice }" placeholder='최종판매가격' type='number'>
                </div>
              </div>
            </div>
          </div>
          <div class='form-group'>
            <label class='control-label col-md-2 col-md-offset-2'>업체명</label>
            <div class='col-md-6'>
              <div class='form-group'>
                <div class='col-md-11'>
                  <input class='form-control' name="company" value="${modify.marCompany }" type='text'>
                </div>
            </div>
          </div>
          <div class='form-group'>
            <label class='control-label col-md-2 col-md-offset-2'>대표이름</label>
            <div class='col-md-6'>
              <div class='form-group'>
                <div class='col-md-11'>
                  <input class='form-control' name="ceo" value="${modify.marCeo }" type='text'>
                </div>
              </div>        
            </div>
          </div>
          <div class='form-group'>
            <label class='control-label col-md-2 col-md-offset-2'>업체번호</label>
            <div class='col-md-6'>
              <div class='form-group'>
                <div class='col-md-11'>
                  <input class='form-control' name="phone" value="${modify.marPhone }" type='text'>
                </div>
              </div>        
            </div>
          </div>
            <label class='control-label col-md-2 col-md-offset-2'>사업자 번호</label>
            <div class='col-md-6'>
              <div class='form-group'>
                <div class='col-md-11'>
                  <input class='form-control' name="regnum" value="${modify.marRegnum }" type='text'>
                </div>
              </div>        
            </div>
          </div>
          <div class='form-group'>
            <label class='control-label col-md-2 col-md-offset-2' >판매시작일</label>
            <div class='col-md-8'>
              <div class='col-md-3'>
                <div class='form-group internal input-group'>
                  <input class='form-control datepicker' type="date" value="${modify.marOpendate }" name = "start"id='id_checkin'>
                  <span class='input-group-addon'>
                    <i class='glyphicon glyphicon-calendar'></i>
                  </span>
                </div>
              </div>
              <label class='control-label col-md-2' >판매종료일</label>
              <div class='col-md-3'>
                <div class='form-group internal input-group'>
                  <input class='form-control datepicker' type="date" value="${modify.marClosedate }" name = "finish" id='id_checkout'>
                  <span class='input-group-addon'>
                    <i class='glyphicon glyphicon-calendar'></i>
                  </span>
                </div>
              </div>
            </div>
          </div>
         
         

          <div class='form-group'>
            <label class='control-label col-md-2 col-md-offset-2' for='id_comments'>사진첨부</label>
            <div class='col-md-6'>
             		<div class="filebox">
						<c:if test="${modify.attSet.attName == null }">
						    <input class="upload-name" value="첨부파일" placeholder="첨부파일">
						    <label for="file">파일 찾기</label> 
						    <input type="file" name="filename" id="file">
						</c:if>    
					</div>
					
					<div id = "fileSector">
		              	<c:if test="${modify.attSet.attName != null }">
						    <input class="upload-name" value="${modify.attSet.attName}" placeholder="첨부파일">
						    <img src="/upload/thumbnail/${modify.attSet.attThumb.fileName}">
							<input type="button"value="삭제" onclick="fileDel('${modify.attSet.attSeqno}','${modify.attSet.getSavefilename()}','${modify.attSet.attPath}',
							'${modify.attSet.attThumb.fileName }')">
						</c:if>
					</div>
            </div>
          <div class='form-group'>
            <label class='control-label col-md-2 col-md-offset-2' for='id_comments'>제품 상세</label>
            <div class='col-md-6'>
              <textarea class='form-control' id='id_comments' name = "comment" placeholder='Additional comments' rows='3'>${modify.marDetail }</textarea>
            </div>
          </div>
          <div class='form-group'>
            <div class='col-md-offset-4 col-md-3'>
              <input class='btn-lg btn-primary' id="reg" type='submit' value="상품등록">
            </div>
            <div class='col-md-3'>
              <button class='btn-lg btn-danger' style='float:right' onclick="window.close()">취소</button>
            </div>
          </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</body>
<style>
.indent-small {
  margin-left: 5px;
}
.form-group.internal {
  margin-bottom: 0;
}
.dialog-panel {
  margin: 10px;
}
.datepicker-dropdown {
  z-index: 200 !important;
}
.panel-body {
  background: #e5e5e5;
  /* Old browsers */
  background: -moz-radial-gradient(center, ellipse cover, #e5e5e5 0%, #ffffff 100%);
  /* FF3.6+ */
  background: -webkit-gradient(radial, center center, 0px, center center, 100%, color-stop(0%, #e5e5e5), color-stop(100%, #ffffff));
  /* Chrome,Safari4+ */
  background: -webkit-radial-gradient(center, ellipse cover, #e5e5e5 0%, #ffffff 100%);
  /* Chrome10+,Safari5.1+ */
  background: -o-radial-gradient(center, ellipse cover, #e5e5e5 0%, #ffffff 100%);
  /* Opera 12+ */
  background: -ms-radial-gradient(center, ellipse cover, #e5e5e5 0%, #ffffff 100%);
  /* IE10+ */
  background: radial-gradient(ellipse at center, #e5e5e5 0%, #ffffff 100%);
  /* W3C */
  filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#e5e5e5', endColorstr='#ffffff', GradientType=1);
  /* IE6-9 fallback on horizontal gradient */
  font: 600 15px "Open Sans", Arial, sans-serif;
}
label.control-label {
  font-weight: 600;
  color: #777;
}

.filebox .upload-name {
    display: inline-block;
    height: 38px;
    padding: 0 10px;
    vertical-align: middle;
    border: 1px solid #dddddd;
    width: 75%;
    color: #999999;
    margin-left: 5px;
    border-radius: 4px;
}

.filebox label {
    display: inline-block;
    padding: 10px 20px;
    color: #fff;
    vertical-align: middle;
    background-color: #999999;
    cursor: pointer;
    height: 38px;
    border-radius: 4px;
    margin-bottom: 1px;
}

.filebox input[type="file"] {
    position: absolute;
    width: 0;
    height: 0;
    padding: 0;
    overflow: hidden;
    border: 0;
}

</style>

<script>

    $("#reg").click( function() {

    	var ans = confirm("광고상품이 수정되었습니다.");
            if (ans){
         $('#insert').submit();
            }
      });


</script>
<script>
function fileDel(attSeqNo,saveFileName,filePath,thumb_file){
	
	var ans = confirm("정말로 삭제하시겠습니까?");
	
	if (ans){
		var x = new XMLHttpRequest();
		x.onreadystatechange = function(){
			if(x.readyState === 4 && x.status === 200){
				
				var tag = document.getElementById("fileSector");
				
				
				if (x.responseText.trim() === "0"){
					alert("파일 삭제에 실패 하였습니다.");
				} else {
					alert("파일 삭제에 완료 하였습니다.");
					tag.innerHTML = "<input class='upload-name' value='첨부파일' placeholder='첨부파일'><label for='file'>파일찾기</label><input type='file' id='file' name='filename'>";
				}
				
			}else{
			console.log('에러코드는:' + x.status);
				
			}
		
		};
	}
	
	//방식,매핑정보,동기방식
	x.open("POST", "<%= request.getContextPath() %>/cre/fileDel", true);
	x.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	x.send("attseqno="+attSeqNo+"&savefilename="+saveFileName+"&filepath="+filePath+"&thumb_filename="+thumb_file);

}
</script>
