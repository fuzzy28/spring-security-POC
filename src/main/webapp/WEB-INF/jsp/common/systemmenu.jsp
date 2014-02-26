<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



<div class="container-left">
               <div class="accordion" id="leftMenu">
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#">
                                  <i class="icon-home"></i> Dashboard
                            </a>
                        </div>
                    </div>
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseTwo">
                                <i class="icon-th"></i> Layout
                            </a>
                        </div>
                        <div id="collapseTwo" class="accordion-body collapse" style="height: 0px; ">
                            <div class="accordion-inner">
                                <ul>
                                    <li>This is one</li>
                                    <li>This is two</li>
                                    <li>This is Three</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseThree">
                                <i class="icon-th-list"></i> UI Components
                            </a>
                        </div>
                        <div id="collapseThree" class="accordion-body collapse" style="height: 0px; ">
                            <div class="accordion-inner">
                                <ul>
                                    <li>This is one</li>
                                    <li>This is two</li>
                                    <li>This is Three</li>
                                </ul>                 
                            </div>
                         </div>
                    </div>
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseFour">
                                <i class="icon-list-alt"></i> Forms
                            </a>
                        </div>
                        <div id="collapseFour" class="accordion-body collapse" style="height: 0px; ">
                            <div class="accordion-inner">
                                <ul>
                                    <li>This is one</li>
                                    <li>This is two</li>
                                    <li>This is Three</li>
                                </ul>                 
                            </div>
                         </div>
                    </div>
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseFive">
                                <i class="icon-cog"></i> Plugins
                            </a>
                        </div>
                        <div id="collapseFive" class="accordion-body collapse" style="height: 0px; ">
                            <div class="accordion-inner">
                                <ul>
                                    <li>This is one</li>
                                    <li>This is two</li>
                                    <li>This is Three</li>
                                </ul>                 
                            </div>
                         </div>
                    </div>
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#leftMenu" href="#collapseSix">
                                <i class="icon-file"></i> Templates
                            </a>
                        </div>
                        <div id="collapseSix" class="accordion-body collapse" style="height: 0px; ">
                            <div class="accordion-inner">
                                <ul>
                                    <li>This is one</li>
                                    <li>This is two</li>
                                    <li>This is Three</li>
                                </ul>                 
                            </div>
                         </div>
                    </div>
                </div>
</div>




























<div class="container-left">
	<ul class="nav nav-stacked" id="accordion1">
		<!-- Loop Main -->
		<c:forEach items="${menuList}" var="menu">
			<!--Link is together with list item tag  -->
			<sec:authorize ifAnyGranted="${menu.access}">
			<li id="${menu.id}">
			<c:url value="${menu.url}" var="menuUrl"/>
			<a href= "${menuUrl}">${menu.name}</a>
				<c:choose>
					<c:when test="${menu.hasChildren}">
						<ul>
							<!-- Loop SubMenu -->
							<c:forEach items="${menu.menuItems}" var="submenu">
								<!--Link is together with list item tag  -->
								<sec:authorize ifAnyGranted="${submenu.access}">
								<li id="${submenu.id}">
								<c:url value="${submenu.url}" var="submenuUrl"/>
								<a href= "${submenuUrl}">${submenu.name}</a>
								<c:choose>
										<c:when test="${submenu.hasChildren}">
											<ul>
												<!-- Loop SubMenu 2 -->
												<c:forEach items="${submenu.menuItems}" var="submenu_2">
													<sec:authorize ifAnyGranted="${submenu_2.access}">
													<li id="${submenu_2.id}">
													<c:url value="${submenu_2.url}" var="submenu_2Url"/>
													<a href= "${submenu_2Url}">${submenu_2.name}</a>
														<c:choose>
															<c:when test="${submenu_2.hasChildren}">
																<ul>
																	<!--Loop Sub Menu 3  -->
																	<c:forEach items="${submenu_2.menuItems}" var="submenu_3">
																		<sec:authorize ifAnyGranted="${submenu_3.access}">
																		<li id="${submenu_3.id}">
																		<c:url value="${submenu_3.url}" var="submenu_3Url"/>
																		<a href= "${submenu_3Url}">${submenu_3.name}</a>
																		</li>
																		</sec:authorize>
																	</c:forEach>
																</ul>
															</c:when>
														</c:choose>
													</li>
													</sec:authorize>
												</c:forEach>
											</ul>

										</c:when>
									</c:choose>
									</li>
									</sec:authorize>
							</c:forEach>
						</ul>
					</c:when>
				</c:choose>
			</li>
			</sec:authorize>
		</c:forEach>
	</ul>
</div>