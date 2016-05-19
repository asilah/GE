<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Gestion Abscence | </title>

    <!-- Bootstrap core CSS -->

    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">

    <link href="<%=request.getContextPath()%>/resources/fonts/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/animate.min.css" rel="stylesheet">

    <!-- Custom styling plus plugins -->
    <link href="<%=request.getContextPath()%>/resources/css/custom.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/icheck/flat/green.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/datatables/tools/css/dataTables.tableTools.css" rel="stylesheet">

    <script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>

    <!--[if lt IE 9]>
        <script src="../assets/js/ie8-responsive-file-warning.js"></script>
        <![endif]-->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

</head>


<body class="nav-md">
<% session.setAttribute("page","gestionAbsence");%>
    <div class="container body">


        <div class="main_container">

            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">

                    <div class="navbar nav_title" style="border: 0;">
                        <a href="<c:url value="/index"/>"><i class="fa fa-paw"></i> <span>Home</span></a>
                    </div>
                    <div class="clearfix"></div>

                    <!-- menu prile quick info -->
                    <div class="profile">
                        <div class="profile_pic">
                            <img src="images/img.jpg" alt="..." class="img-circle profile_img">
                        </div>
                        <div class="profile_info">
                            <span>Welcome,</span>
                            <h2>${Admin.nom } </h2>
                        </div>
                    </div>
                    <!-- /menu prile quick info -->

                    <br />

                    <!-- sidebar menu -->
                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

                        <div class="menu_section">
                            <h3>General</h3>
                            <ul class="nav side-menu">
                                <li><a><i class="fa fa-home"></i> Ajouter <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="<c:url value="/ajoutEmp"/>">Employe</a></li>
										<li><a href="<c:url value="/ajoutDept"/>">Departement</a></li>
										<li><a href="<c:url value="/ajoutAdmin"/>">Admin</a></li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-table"></i> List <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="<c:url value="/listEmp"/>">List des Employes</a></li>
                                        <li><a href="<c:url value="/listDept"/>">List des departement</a></li>
                                        
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-desktop"></i> gestion d'absence <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="<c:url value="/gestionAbsence"/>">gestion d'absence</a></li>
                                        
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-edit"></i> Modification <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="<c:url value="/updateAdmin"/>">Admin</a>
                                        </li>
                                        <li><a href="<c:url value="/updateEntr"/>">Entreprise</a>
                                        </li>
                                        <li><a href="<c:url value="/updateEmp"/>">Departement</a>
                                        </li>
                                        <li><a href="<c:url value="/updateDept"/>">Employe</a>
                                        </li>
                                    </ul>
                                </li>
                              
                                <li><a><i class="fa fa-table"></i> generation des pdfs <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu" style="display: none">
                                        <li><a href="<c:url value="/pdfs"/>">generer pdf</a>
                                        </li>
                                        
                                    </ul>
                                </li>
                                
                            </ul>
                        </div>
                        </div>
                    <!-- /sidebar menu -->

                    <!-- /menu footer buttons -->
                    <div class="sidebar-footer hidden-small">
                        <a data-toggle="tooltip" data-placement="top" title="Settings">
                            <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                            <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="Lock">
                            <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="Logout">
                            <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                        </a>
                    </div>
                    <!-- /menu footer buttons -->
                </div>
            </div>

            <!-- top navigation -->
            <div class="top_nav">

                <div class="nav_menu">
                    <nav class="" role="navigation">
                        <div class="nav toggle">
                            <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                        </div>

                        <ul class="nav navbar-nav navbar-right">
                            <li class="">
                                <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                    <img src="images/img.jpg" alt="">${Admin.nom } 
                                    <span class=" fa fa-angle-down"></span>
                                </a>
                                <ul class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
                                    <li><a href="<c:url value="/updateAdmin"/>">  Profile</a>
                                    </li>
                                    <li>
                                        <a href="javascript:;">
                                            
                                            <span>Settings</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="javascript:;">Help</a>
                                    </li>
                                    <li><a href="<c:url value="/logout"/>"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                                    </li>
                                </ul>
                            </li>

                            <li role="presentation" class="dropdown">
                                <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                                    <i class="fa fa-envelope-o"></i>
                                    <span class="badge bg-green">6</span>
                                </a>
                                <ul id="menu1" class="dropdown-menu list-unstyled msg_list animated fadeInDown" role="menu">
                                    <li>
                                        <a>
                                            <span class="image">
                                        <img src="images/img.jpg" alt="Profile Image" />
                                    </span>
                                            <span>
                                        <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                            <span class="message">
                                        Film festivals used to be do-or-die moments for movie makers. They were where... 
                                    </span>
                                        </a>
                                    </li>
                                    <li>
                                        <a>
                                            <span class="image">
                                        <img src="images/img.jpg" alt="Profile Image" />
                                    </span>
                                            <span>
                                        <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                            <span class="message">
                                        Film festivals used to be do-or-die moments for movie makers. They were where... 
                                    </span>
                                        </a>
                                    </li>
                                    <li>
                                        <a>
                                            <span class="image">
                                        <img src="images/img.jpg" alt="Profile Image" />
                                    </span>
                                            <span>
                                        <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                            <span class="message">
                                        
                                    </span>
                                        </a>
                                    </li>
                                    <li>
                                        <a>
                                            <span class="image">
                                        <img src="images/img.jpg" alt="Profile Image" />
                                    </span>
                                            <span>
                                        <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                            </span>
                                            <span class="message">
                                       
                                    </span>
                                        </a>
                                    </li>
                                    <li>
                                        <div class="text-center">
                                            <a>
                                                <strong>See All Alerts</strong>
                                                <i class="fa fa-angle-right"></i>
                                            </a>
                                        </div>
                                    </li>
                                </ul>
                            </li>

                        </ul>
                    </nav>
                </div>

            </div>
            <!-- /top navigation -->

            <!-- page content -->
            <div class="right_col" role="main">
                <div class="">
                    <div class="page-title">
                        <div class="title_left">
                            <h3>
                    
                   
                </h3>
                        </div>

                        <div class="title_right">
                            <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Search for...">
                                    <span class="input-group-btn">
                            <button class="btn btn-default" type="button">Go!</button>
                        </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="clearfix"></div>

                    <div class="row">

                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Gestion de presence <small>jour ferier  :</small></h2><input type="checkbox" class="tableflat" name="jf"  id="jf">
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a href="#"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#">Settings 1</a>
                                                </li>
                                                <li><a href="#">Settings 2</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li><a href="#"><i class="fa fa-close"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                 
                                <%int i=0; %>
                                    <table id="example" class="table table-striped responsive-utilities jambo_table">
                                        <thead>
                                            <tr class="headings">
                                                <th>
                                                    <input type="checkbox" class="tableflat">
                                                </th>
                                                <th>Nom/prenom </th>
                                                <th>num CNSS</th>
                                                <th>Responsabilite </th>
                                                <th>Abcense </th>
                                                <th>Retad </th>
                                                <th>heure Sup </th>
                                                <th>heure debut </th>
                                                <th>heure fin </th>
                                                <th>etat </th>
                                                <th>raison </th>
                                                <th class=" no-link last"><span class="nobr">Action</span>
                                                </th>
                                            </tr>
                                        </thead>

                                       <tbody>
                                            <c:forEach items="${listEmp }" var="lemp">
														<%i++; %>
                                            <tr class="odd pointer">
                                                <td class="a-center ">
                                                    <input type="checkbox" class="tableflat">
                                                </td>
                                                <td class=" ">${lemp.nom } ${lemp.prenom } <input type="hidden" value="${lemp.codeEmp }" id="codeEmp<%=i%>"></td>
                                                <td class=" ">${lemp.numCnss } </td>
                                                <td class=" ">${lemp.responsabilite } </td>
                                                <td class=" "> <input type="checkbox" class="tableflat" name="fooby[<%=i %>][]" value="A" id="A<%=i%>"></td>
                                                <td class=" "> <input type="checkbox" class="tableflat" name="fooby[<%=i %>][]" value="R" id="R<%=i%>"></td>
                                                <td class=" "> <input type="checkbox" class="tableflat" name="fooby[<%=i %>][]" value="S" id="S<%=i%>"></td>
                                                <td class=" last"> <select id="HD<%=i%>" class=" form-control col-md-7 col-xs-12">
                                                						<option value="00">00h00min</option>
                                                						<option value="01">01h00min</option>
                                                						<option value="02">02h00min</option>
                                                						<option value="03">03h00min</option>
                                                						<option value="04">04h00min</option>
                                                						<option value="05">05h00min</option>
                                                						<option value="06">06h00min</option>
                                                						<option value="07">07h00min</option>
                                                						<option value="08">08h00min</option>
                                                						<option value="09">09h00min</option>
                                                						<option value="10">10h00min</option>
                                                						<option value="11">11h00min</option>
                                                						<option value="12">12h00min</option>
                                                						<option value="13">13h00min</option>
                                                						<option value="14">14h00min</option>
                                                						<option value="15">15h00min</option>
                                                						<option value="16">16h00min</option>
                                                						<option value="17">17h00min</option>
                                                						<option value="18">18h00min</option>
                                                						<option value="19">19h00min</option>
                                                						<option value="20">20h00min</option>
                                                						<option value="21">21h00min</option>
                                                						<option value="22">22h00min</option>
                                                						<option value="23">23h00min</option>
                                                					</select>
                                                </td>
                                                 <td class=" last"> <select id="HF<%=i%>" class=" form-control col-md-7 col-xs-12">
                                                						<option value="00">00h00min</option>
                                                						<option value="01">01h00min</option>
                                                						<option value="02">02h00min</option>
                                                						<option value="03">03h00min</option>
                                                						<option value="04">04h00min</option>
                                                						<option value="05">05h00min</option>
                                                						<option value="06">06h00min</option>
                                                						<option value="07">07h00min</option>
                                                						<option value="08">08h00min</option>
                                                						<option value="09">09h00min</option>
                                                						<option value="10">10h00min</option>
                                                						<option value="11">11h00min</option>
                                                						<option value="12">12h00min</option>
                                                						<option value="13">13h00min</option>
                                                						<option value="14">14h00min</option>
                                                						<option value="15">15h00min</option>
                                                						<option value="16">16h00min</option>
                                                						<option value="17">17h00min</option>
                                                						<option value="18">18h00min</option>
                                                						<option value="19">19h00min</option>
                                                						<option value="20">20h00min</option>
                                                						<option value="21">21h00min</option>
                                                						<option value="22">22h00min</option>
                                                						<option value="23">23h00min</option>
                                                					</select>
                                                </td>
                                                 <td class=" last"> <select id="etat<%=i%>" class=" form-control col-md-7 col-xs-12">
                                                						<option>ok</option>
                                                						<option>refus</option>
                                                						
                                                					</select>
                                                </td>
                                                 <td class=" last"> <input type="text" id="raison<%=i%>"></td>
                                                 <td><a href="#">View</a></td>
                                            </tr>
                                            </c:forEach>
                               				
                                        </tbody>

                                    </table>
                                    
                                    <f:form modelAttribute="DeptForm" method="post" action="gestionAbsence" >
                          <f:input path="submit" class="btn btn-default" type="submit" id="validation" value="valider"></f:input>          
                                    </f:form>
                                    
									<input type="hidden" id="nb" value="<%=i %>" >
                                </div>
                            </div>
                        </div>

                        <br />
                        <br />
                        <br />

                    </div>
                </div>
                    <!-- footer content -->
                <footer>
                    <div class="">
                        <p class="pull-right"> <a>Projet -jee-2016</a>. |
                            <span class="lead"> <i class="fa fa-paw"></i> </span>
                        </p>
                    </div>
                    <div class="clearfix"></div>
                </footer>
                <!-- /footer content -->
                    
                </div>
                <!-- /page content -->
            </div>

        </div>

        <div id="custom_notifications" class="custom-notifications dsp_none">
            <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
            </ul>
            <div class="clearfix"></div>
            <div id="notif-group" class="tabbed_notifications"></div>
        </div>

        <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>

        <!-- chart js -->
        <script src="<%=request.getContextPath()%>/resources/js/chartjs/chart.min.js"></script>
        <!-- bootstrap progress js -->
        <script src="<%=request.getContextPath()%>/resources/js/progressbar/bootstrap-progressbar.min.js"></script>
        <script src="<%=request.getContextPath()%>/resources/js/nicescroll/jquery.nicescroll.min.js"></script>
        <!-- icheck -->
        <script src="<%=request.getContextPath()%>/resources/js/icheck/icheck.min.js"></script>

        <script src="<%=request.getContextPath()%>/resources/js/custom.js"></script>


        <!-- Datatables -->
        <script src="<%=request.getContextPath()%>/resources/js/datatables/js/jquery.dataTables.js"></script>
        <script src="<%=request.getContextPath()%>/resources/js/datatables/tools/js/dataTables.tableTools.js"></script>
        <script>
$(document).ready(function(){
	$("input:checkbox").on('click', function() {
		  // in the handler, 'this' refers to the box clicked on
		  var $box = $(this);
		  if ($box.is(":checked")) {
		    // the name of the box is retrieved using the .attr() method
		    // as it is assumed and expected to be immutable
		    var group = "input:checkbox[name='" + $box.attr("name") + "']";
		    // the checked state of the group/box on the other hand will change
		    // and the current value is retrieved using .prop() method
		    $(group).prop("checked", false);
		    $box.prop("checked", true);
		  } else {
		    $box.prop("checked", false);
		  }
		});
    $("#validation").click(function(){
    	
    	var nb = parseInt($("#nb").val())+1;
    	var codeEmp,ars,hd,hf,etat,raison;
    	var req="";
    	var jf="f"
    	if ($("#jf").is(":checked")) {
    		jf="t";
    	}
    	for (var i = 1; i < nb; i++) {
    		
    		if ($("#A"+i).is(":checked")) {
    			
        		var ars = $("#A"+i).val();
        		var codeEmp = $("#codeEmp"+i).val();
        		var raison = $("#raison"+i).val();
        		var etat = $("#etat"+i).val();
        		var hd = $("#HD"+i).val();
	          	var hf = $("#HF"+i).val();
	          	req = req+codeEmp+"-"+ars+"-"+hd+"-"+hf+"-"+raison+"-"+etat+"/";
        		
            	
            	
            	
        	}
    		else if ($("#R"+i).is(":checked")) {
        		var ars = $("#R"+i).val();
        		var codeEmp = $("#codeEmp"+i).val();
        		var raison = $("#raison"+i).val();
        		var etat = $("#etat"+i).val();
        		var hd = $("#HD"+i).val();
	          	var hf = $("#HF"+i).val();
	          	req = req+codeEmp+"-"+ars+"-"+hd+"-"+hf+"-"+raison+"-"+etat+"/";
        		
        		
            	
        	}
        	else if ($("#S"+i).is(":checked")) {
        		var ars = $("#S"+i).val();
	    		var codeEmp = $("#codeEmp"+i).val();
        		var raison = $("#raison"+i).val();
        		var etat = $("#etat"+i).val();
        		var hd = $("#HD"+i).val();
	          	var hf = $("#HF"+i).val();
	          	req = req+codeEmp+"-"+ars+"-"+hd+"-"+hf+"-"+raison+"-"+etat+"/";
        		
        	}
		}
    	
    	
//         $.get("/updateDepartement?req="+req,
        
//         function(data,status){
//             alert("Data: " + data + "\nStatus: " + status);
//         });
    	$.ajax({
			url : "validationAbsence?req="+req+"&jf="+jf,
			type : "get"
		});
    });
});
</script>
        <script>
            $(document).ready(function () {
                $('input.tableflat').iCheck({
                    checkboxClass: 'icheckbox_flat-green',
                    radioClass: 'iradio_flat-green'
                });
            });

            var asInitVals = new Array();
            $(document).ready(function () {
                var oTable = $('#example').dataTable({
                    "oLanguage": {
                        "sSearch": "Search all columns:"
                    },
                    "aoColumnDefs": [
                        {
                            'bSortable': false,
                            'aTargets': [0]
                        } //disables sorting for column one
            ],
                    'iDisplayLength': 12,
                    "sPaginationType": "full_numbers",
                    "dom": 'T<"clear">lfrtip',
                    "tableTools": {
                        "sSwfPath": "<?php echo base_url('assets2/js/Datatables/tools/swf/copy_csv_xls_pdf.swf'); ?>"
                    }
                });
                $("tfoot input").keyup(function () {
                    /* Filter on the column based on the index of this element's parent <th> */
                    oTable.fnFilter(this.value, $("tfoot th").index($(this).parent()));
                });
                $("tfoot input").each(function (i) {
                    asInitVals[i] = this.value;
                });
                $("tfoot input").focus(function () {
                    if (this.className == "search_init") {
                        this.className = "";
                        this.value = "";
                    }
                });
                $("tfoot input").blur(function (i) {
                    if (this.value == "") {
                        this.className = "search_init";
                        this.value = asInitVals[$("tfoot input").index(this)];
                    }
                });
            });
        </script>
</body>

</html>