<!DOCTYPE html>
<!--Default Block is from here...  -->
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<jsp:include page="../fragments/headTag.jsp"/>

<style type="text/css">
	#floating-box{
		width:90px;
		height:200px;
		border:1px solid red;
		background-color:#BBBBBB;
		float:left;
		margin-left: 40px;
		margin-right:10px;
		position:absolute;
		z-index:1;
	}
</style>

<script type="text/javascript">
$j=jQuery.noConflict();

$j(document).ready(function($) {

//this is the floating content
var $floatingbox = $('#floating-box');

if($('#body').length > 0){

  var bodyY = parseInt($('#body').offset().top) - 20;
  var originalX = $floatingbox.css('margin-left');

  $(window).scroll(function () { 

   var scrollY = $(window).scrollTop();
   var isfixed = $floatingbox.css('position') == 'fixed';

   if($floatingbox.length > 0){
	  alert("srollY : " + scrollY + ", bodyY : " 
              + bodyY + ", isfixed : " + isfixed);
      $floatingbox.html("srollY : " + scrollY + ", bodyY : " 
                                + bodyY + ", isfixed : " + isfixed);

      if ( scrollY > bodyY && !isfixed ) {
		$floatingbox.stop().css({
		  position: 'fixed',
		  left: '50%',
		  top: 20,
		  marginLeft: -500
		});
	} else if ( scrollY < bodyY && isfixed ) {
	 	  $floatingbox.css({
		  position: 'relative',
		  left: 0,
		  top: 0,
		  marginLeft: originalX
	});
     }		
   }
   });
 }
});
</script>
<body role="document">
<div class="container" style="padding: 50px"></div>
<!--to here  -->

<!-- <table border="0" cellpadding="2" cellspacing="2" align="center"> -->
<!--     <tr> -->
<%--         <td height="30" colspan="2"><tiles:insertAttribute name="header" /> --%>
<!--         </td> -->
<!--     </tr> -->
<!--     <tr> -->
<%--         <td height="200"><tiles:insertAttribute name="menu" /></td> --%>
<%--         <td width="450"><tiles:insertAttribute name="body" /></td> --%>
<!--     </tr> -->
<!--     <tr> -->
<%--         <td height="30" colspan="2"><tiles:insertAttribute name="footer" /> --%>
<!--         </td> -->
<!--     </tr> -->
<!-- </table> -->
<tiles:insertAttribute name="menu" />
<div class="header">
	<tiles:insertAttribute name="navbar" />
</div>

<div class="container theme-showcase" >
	<div class="jumbotron">
			<tiles:insertAttribute name="body" />
	        <p><a href="#" class="btn btn-primary btn-lg" role="button">Learn more &raquo;</a></p>
	        
	</div>
</div>


<div class="footer" style="clear:both;text-align:center;">
	<tiles:insertAttribute name="footer" />
</div>

</body>
</html>