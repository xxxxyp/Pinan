webpackJsonp([0],{146:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=n(704),o=n(729),i=n(494),r=Object(i.a)(s.a,o.a,o.b,!1,null,null,null);t.default=r.exports},494:function(e,t,n){"use strict";function s(e,t,n,s,o,i,r,a){e=e||{};var u=typeof e.default;"object"!==u&&"function"!==u||(e=e.default);var c="function"==typeof e?e.options:e;t&&(c.render=t,c.staticRenderFns=n,c._compiled=!0),s&&(c.functional=!0),i&&(c._scopeId=i);var l;if(r?(l=function(e){e=e||this.$vnode&&this.$vnode.ssrContext||this.parent&&this.parent.$vnode&&this.parent.$vnode.ssrContext,e||"undefined"==typeof __VUE_SSR_CONTEXT__||(e=__VUE_SSR_CONTEXT__),o&&o.call(this,e),e&&e._registeredComponents&&e._registeredComponents.add(r)},c._ssrRegister=l):o&&(l=a?function(){o.call(this,this.$root.$options.shadowRoot)}:o),l)if(c.functional){c._injectStyles=l;var h=c.render;c.render=function(e,t){return l.call(t),h(e,t)}}else{var d=c.beforeCreate;c.beforeCreate=d?[].concat(d,l):[l]}return{exports:e,options:c}}t.a=s},704:function(e,t,n){"use strict";var s=n(147),o=n.n(s),i=n(72),r=n.n(i),a=n(718),u=n(720),c=n(724),l=n(726),h=n(728),d=n(91),m=n.n(d);t.a={components:{cascadeMenu:a.a,tagsPageOpened:u.a,breadcrumbNav:c.a,themeDropdownMenu:l.a},data:function(){return{toShowMenu:!1,isRootMenu:!0,isSubMenu:!0,isGrandMenu:!0,isForthMenu:!0,subMenuShow:!1,grandMenuShow:!1,forthMenuShow:!1,subMenuList:[],grandMenuList:[],forthMenuList:[],removeClass:!0,isFullScreen:!1,messageCount:3,showFullScreenBtn:window.navigator.userAgent.indexOf("MSIE")<0,showLockSwitch:!1,showChangeTheme:!1,showShortCutBox:!1,searchContent:"menu",shortCutMenuList:[],shortCutMenu:"",menuPathMap:{},currentPaths:[]}},computed:{menuList:function(){return this.$store.getters.navMenu},pageTagsList:function(){return this.$store.getters.pageOpenedList},tagsList:function(){return this.$store.getters.tagsList},avatorPath:function(){return localStorage.avatorImgPath},userName:function(){return this.$store.getters.login_user_name},userId:function(){return this.$store.getters.login_user_id},shortCutMenus:function(){for(var e=[],t=this.$store.getters.activeRoutes,n=this.$router.options.routes.concat(t),s=0;s<n.length;s++)if(n[s].children)for(var o=0;o<n[s].children.length;o++){var i=n[s].children[o];e.push(i.name),this.menuPathMap[i.name]=i.path}return e},excludeRouter:function(){return this.$store.getters.excludePages},showLoading:function(){return this.$store.getters.showLoading}},methods:{showMenu:function(){this.toShowMenu=!0},hideMenu:function(){this.toShowMenu=!1,this.subMenuShow=!1,this.grandMenuShow=!1,this.forthMenuShow=!1,this.removeClass=!0!==this.removeClass},showSubMenu:function(e){if(this.subMenuShow=e.status,!this.subMenuShow)return this;for(var t=0;t<this.menuList.length;t++){for(var n=this.menuList[t]._sub,s=!1,o=0;o<n.length;o++)if(n[o].menuId===e.menuid){this.subMenuList=[n[o]],s=!0;break}if(s)break}},showGrandMenu:function(e){if(this.grandMenuShow=e.status,!this.grandMenuShow)return this;for(var t=this.subMenuList[0]._sub,n=0;n<t.length;n++)if(t[n].menuId===e.menuid){this.grandMenuList=[t[n]];break}},showForthMenu:function(e){if(this.forthMenuShow=e.status,!this.forthMenuShow)return this;for(var t=this.grandMenuList[0]._sub,n=0;n<t.length;n++)if(t[n].menuId===e.menuid){this.forthMenuList=[t[n]];break}},routerPage:function(e){for(var t=this.$store.getters.pageOpenedList,n=t.length,s=0,i=!1;s<n;){if(e===t[s].path){"/home"!==e&&this.$store.commit("MOVE_TO_SECOND",s),i=!0;break}s++}if(!i){var a=[],u=!0,c=!1,l=void 0;try{for(var h,d=o()(this.tagsList);!(u=(h=d.next()).done);u=!0){var m=h.value;if(m.children&&(a=m.children.filter(function(t){return t.children?e===t.children[0].path:e===t.path})),a&&0!==a.length)break}}catch(e){c=!0,l=e}finally{try{!u&&d.return&&d.return()}finally{if(c)throw l}}if(!(a=a[0]))return;a=a.children?a.children[0]:a,this.$store.commit("INCREATE_TAG",a),this.$store.commit("REMOVE_EXCLUDE_PAGE",a.path),localStorage.pageOpenedList=r()(this.$store.getters.pageOpenedList)}this.$router.push(e),this.toShowMenu=!1},handleFullScreen:function(){var e=document.body;this.isFullScreen?document.exitFullscreen?document.exitFullscreen():document.mozCancelFullScreen?document.mozCancelFullScreen():document.webkitCancelFullScreen?document.webkitCancelFullScreen():document.msExitFullscreen&&document.msExitFullscreen():e.requestFullscreen?e.requestFullscreen():e.mozRequestFullScreen?e.mozRequestFullScreen():e.webkitRequestFullScreen?e.webkitRequestFullScreen():e.msRequestFullscreen&&e.msRequestFullscreen()},lockScreen:function(){var e=this,t=document.getElementById("lock_screen_back");t.style.transition="all 3s",t.style.zIndex=1e4,t.style.boxShadow="0 0 0 "+this.lockScreenSize+"px #667aa6 inset",this.showUnlock=!0,this.$store.commit("LOCK_SCREEN"),m.a.set("last_page_name",this.$route.name),setTimeout(function(){t.style.transition="all 0s",e.$router.push("/locking")},800)},showMessage:function(){h.a.openPage(this,"/message","消息中心")},handleLogout:function(){var e=this;this.$uiModal.confirm({title:"用户注销",content:"确定要注销当前登录吗？",onOk:function(){e.$store.dispatch("logout"),window.location.reload(),e.$store.commit("CLEAR_OPEND_TAG",e.$router),m.a.remove("user")}})},shortCutKey:function(e){function t(){s.$refs.shortCutInput.$children[0].$refs.reference.children[0].children[1].focus()}var n=e.keyCode||e.which||e.charCode;(e.ctrlKey||e.metaKey)&&77===n&&(this.shortCutMenu="",this.showShortCutBox=!0,window.setTimeout(function(){t()},0)),27===n&&this.closeShortCut();var s=this},handleSearch:function(e){if("menu"===this.searchContent){for(var t=[],n=this.shortCutMenus,s=0;s<n.length;s++)-1!==n[s].indexOf(e)&&t.push(n[s]);this.shortCutMenuList=t}},closeShortCut:function(){this.showShortCutBox=!1,this.$el.focus()},shortCutRouterPage:function(e){this.routerPage(this.menuPathMap[e]),e&&this.closeShortCut()}},beforeCreate:function(){this.$store.dispatch("getMenu")},created:function(){this.$store.commit("SET_OPEND_LIST",this.$router),this.$store.commit("CLEAR_OPEND_TAG",this.$router)},mounted:function(){function e(e){e.isFullScreen=!e.isFullScreen}var t=this;this.currentPaths=h.a.setCurrentPath(this,this.$route.name),this.isFullScreen=document.fullscreenElement||document.mozFullScreenElement||document.webkitFullscreenElement||document.fullScreen||document.mozFullScreen||document.webkitIsFullScreen,this.isFullScreen="boolean"!=typeof this.isFullScreen;var n=this;document.addEventListener("fullscreenchange",function(){e(n)}),document.addEventListener("mozfullscreenchange",function(){e(n)}),document.addEventListener("webkitfullscreenchange",function(){e(n)},!1),document.addEventListener("msfullscreenchange",function(){e(n)});var s=document.getElementById("lock_screen_back"),o=document.body.clientWidth,i=document.body.clientHeight,r=Math.sqrt(o*o+i*i),a=parseInt(r);this.lockScreenSize=a,window.addEventListener("resize",function(){var e=document.body.clientWidth,n=document.body.clientHeight,o=Math.sqrt(e*e+n*n),i=parseInt(o);t.lockScreenSize=i,s.style.transition="all 0s",s.style.width=s.style.height=i+"px"}),s.style.width=s.style.height=a+"px",this.$el.focus()},watch:{$route:function(e){this.currentPaths=h.a.setCurrentPath(this,e.name)}}}},705:function(e,t,n){"use strict";t.a={name:"cascadeMenu",data:function(){return{menuId:""}},methods:{enterEvent:function(e){this.menuId=e.menuId,this.isRootMenu&&(this.$emit("on-show-submenu",{menuid:this.menuId,status:!0}),this.$emit("on-show-grandmenu",{status:!1})),this.isSubMenu&&(void 0!==e._sub?this.$emit("on-show-grandmenu",{menuid:this.menuId,status:!0}):this.$emit("on-show-grandmenu",{menuid:this.menuId,status:!1}),this.$emit("on-show-forthmenu",{status:!1})),this.isGrandMenu&&(void 0!==e._sub?this.$emit("on-show-forthmenu",{menuid:this.menuId,status:!0}):this.$emit("on-show-forthmenu",{menuid:this.menuId,status:!1}))},outEvent:function(e){void 0===e._sub&&(this.menuId="")},handleClick:function(e){var t=e.currentTarget.classList;if(3===t.length||t.value&&-1!==t.value.indexOf("menu-arrow"))return!1;this.$emit("on-select","/"+this.menuId)}},computed:{menuClasses:function(){return{height:document.body.clientHeight-60+"px",overflow:"auto",width:"240px"}},toShow:function(){return this.menuId="",this.isRootMenu||this.subMenuShow||this.grandMenuShow||this.forthMenuShow}},props:{menuList:{type:Array,default:[]},isRootMenu:{type:Boolean,default:!1},isSubMenu:{type:Boolean,default:!1},isGrandMenu:{type:Boolean,default:!1},isForthMenu:{type:Boolean,default:!1},subMenuShow:{type:Boolean,default:!1},forthMenuShow:{type:Boolean,default:!1},grandMenuShow:{type:Boolean,default:!1},removeClass:{type:Boolean}},watch:{removeClass:function(){this.menuId=""}}}},706:function(e,t,n){"use strict";var s=n(72),o=n.n(s);t.a={name:"tagsPageOpened",data:function(){return{currentPagePath:this.$route.path,currPageX:0,currPageY:0,showRightMenu:!1,clickTagPath:""}},props:{pageTagsList:Array},computed:{title:function(){return this.$store.state.currentTitle},rightMenuClass:function(){return{"border-radius":"4px","box-shadow":"0 1px 6px rgba(0,0,0,.2)","white-space":"nowrap",width:"100px",height:"50px","background-color":"#fff","background-clip":"padding-box",position:"absolute","z-index":99,top:this.currPageY-60+"px",left:this.currPageX+"px"}}},methods:{closePage:function(e){if(this.$store.commit("REMOVE_TAG",e),localStorage.pageOpenedList=o()(this.$store.getters.pageOpenedList),this.currentPagePath===e){var t="",n=this.$store.getters.pageOpenedList;t=n.length>1?n[1].path:n[0].path,this.$router.push(t)}this.addExcludePage(e,"self")},linkTo:function(e){this.$router.push(e)},closeTagMenu:function(e){this.currPageX=e.pageX,this.currPageY=e.pageY;var t=this.$store.getters.pageOpenedList;if(t.length>1){this.showRightMenu=!0;var n=e.currentTarget.innerText.trim(),s=t.filter(function(e){return e.name===n});this.clickTagPath=s[0].path}},closeOtherTags:function(){this.addExcludePage(this.clickTagPath,"other"),this.$store.commit("REMOVE_OTHER_TAG",this.clickTagPath),localStorage.pageOpenedList=o()(this.$store.getters.pageOpenedList),this.$router.push(this.clickTagPath)},closeAllTags:function(){this.addExcludePage(this.clickTagPath,"all"),this.$store.commit("REMOVE_ALL_TAG"),localStorage.pageOpenedList=o()(this.$store.getters.pageOpenedList),this.$router.push("/home")},addExcludePage:function(e,t){var n=this.$store.getters.pageExportNames,s=n.get(e)+"-page",o={name:s,flag:t};this.$store.commit("ADD_EXCLUDE_PAGE",o)}},watch:{$route:function(e){this.currentPagePath=e.path}},created:function(){var e=this;document.addEventListener("click",function(){e.showRightMenu=!1},!0),document.addEventListener("contextmenu",function(){e.showRightMenu=!1},!0)}}},707:function(e,t,n){"use strict";t.a={name:"breadcrumbNav",props:{currentPath:Array}}},708:function(e,t,n){"use strict";var s=n(72),o=n.n(s),i=n(91),r=n.n(i);t.a={name:"themeDropdownMenu",data:function(){return{themeList:[{name:"black_b",menu:"#495060",element:"#2d8cf0"},{name:"black_g",menu:"#495060",element:"#64d572"},{name:"black_y",menu:"#495060",element:"#ffd572"},{name:"black_r",menu:"#495060",element:"#f25e43"},{name:"light_b",menu:"#495060",element:"#2d8cf0"},{name:"light_g",menu:"#495060",element:"#64d572"},{name:"light_y",menu:"#495060",element:"#ffd572"},{name:"light_r",menu:"#495060",element:"#f25e43"}]}},methods:{setTheme:function(e){var t=e.substr(0,1),n=e.substr(-1,1);"b"===t?(this.$store.commit("STORAGE_THEME","dark"),t="dark"):(this.$store.commit("STORAGE_THEME","light"),t="light");var s="",i=document.querySelector('link[name="theme"]'),a=r.a.get("user");if(localStorage.theme){var u=JSON.parse(localStorage.theme),c=0;u.some(function(e,t){return e.userName===a&&(c=t,!0)})?(u[c].mainTheme=n,u[c].menuTheme=t):u.push({userName:a,mainTheme:n,menuTheme:t}),localStorage.theme=o()(u)}else localStorage.theme=o()([{userName:a,mainTheme:n,menuTheme:t}]);s="b"!==n?"/dist/"+n+".css":"",i.setAttribute("href",s)}}}},718:function(e,t,n){"use strict";var s=n(705),o=n(719),i=n(494),r=Object(i.a)(s.a,o.a,o.b,!1,null,null,null);t.a=r.exports},719:function(e,t,n){"use strict";n.d(t,"a",function(){return s}),n.d(t,"b",function(){return o});var s=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticStyle:{display:"inline-block",float:"left"}},[n("div",{directives:[{name:"show",rawName:"v-show",value:e.toShow,expression:"toShow"}],style:e.menuClasses},[n("div",{staticClass:"cascade-menu"},e._l(e.menuList,function(t,s){return n("div",{key:s},[n("h2",{staticClass:"menu-title"},[e._v(e._s(t.description))]),e._v(" "),n("ul",e._l(t._sub,function(t,s){return n("li",{key:s,class:["menu-line",{actived:e.menuId==t.menuId},{"menu-arrow":void 0!=t._sub}],on:{mouseenter:function(n){e.enterEvent(t)},mouseout:function(n){e.outEvent(t)},click:function(t){return t.stopPropagation(),e.handleClick(t)}}},[e._v("\n            "+e._s(t.description)+"\n          ")])}))])}))])])},o=[]},720:function(e,t,n){"use strict";function s(e){n(721)}var o=n(706),i=n(723),r=n(494),a=s,u=Object(r.a)(o.a,i.a,i.b,!1,a,null,null);t.a=u.exports},721:function(e,t,n){var s=n(722);"string"==typeof s&&(s=[[e.i,s,""]]),s.locals&&(e.exports=s.locals);var o=n(201).default;o("55f86444",s,!0,{})},722:function(e,t,n){t=e.exports=n(200)(!0),t.push([e.i,".close-tab{padding:2px 0 2px 15px;border-bottom:1px solid;border-bottom-color:#9ea7b4;cursor:pointer}.close-tab:hover{background-color:#d5f0e3}.font-style{font-size:10px}","",{version:3,sources:["E:/Work/msa/trunk/src/client/ui-client/src/Frame/tagsPageopened.vue"],names:[],mappings:"AACA,WACE,uBAA0B,AAC1B,wBAAyB,AACzB,4BAA6B,AAC7B,cAAgB,CACjB,AACD,iBACE,wBAA0B,CAC3B,AACD,YACE,cAAgB,CACjB",file:"tagsPageopened.vue",sourcesContent:["\n.close-tab {\n  padding: 2px 0px 2px 15px;\n  border-bottom: 1px solid;\n  border-bottom-color: #9ea7b4;\n  cursor: pointer;\n}\n.close-tab:hover {\n  background-color: #d5f0e3;\n}\n.font-style {\n  font-size: 10px;\n}\n"],sourceRoot:""}])},723:function(e,t,n){"use strict";n.d(t,"a",function(){return s}),n.d(t,"b",function(){return o});var s=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticStyle:{position:"absolute","margin-top":"3px"}},[n("transition-group",{attrs:{name:"taglist-moving-animation"}},e._l(e.pageTagsList,function(t){return n("ui-tag",{key:t.path,attrs:{type:"dot",closable:"/home"!==t.path,color:t.children?t.children[0].path===e.currentPagePath?"blue":"default":t.path===e.currentPagePath?"blue":"default"},on:{"on-close":function(n){e.closePage(t.path)}},nativeOn:{contextmenu:function(t){return t.preventDefault(),e.closeTagMenu(t)},click:function(n){e.linkTo(t.path)}}},[e._v(e._s(t.title)+"\n    ")])})),e._v(" "),n("div",{directives:[{name:"show",rawName:"v-show",value:e.showRightMenu,expression:"showRightMenu"}],style:e.rightMenuClass},[n("div",{staticClass:"close-tab",on:{click:e.closeOtherTags}},[n("span",{staticClass:"font-style"},[e._v("关闭其他标签")])]),e._v(" "),n("div",{staticClass:"close-tab",staticStyle:{"border-bottom":"0px"},on:{click:e.closeAllTags}},[n("span",{staticClass:"font-style"},[e._v("关闭所有标签")])])])],1)},o=[]},724:function(e,t,n){"use strict";var s=n(707),o=n(725),i=n(494),r=Object(i.a)(s.a,o.a,o.b,!1,null,null,null);t.a=r.exports},725:function(e,t,n){"use strict";n.d(t,"a",function(){return s}),n.d(t,"b",function(){return o});var s=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("ui-breadcrumb",e._l(e.currentPath,function(t,s){return n("ui-breadcrumbItem",{key:s,attrs:{href:t.path}},[e._v(e._s(t.title))])}))},o=[]},726:function(e,t,n){"use strict";var s=n(708),o=n(727),i=n(494),r=Object(i.a)(s.a,o.a,o.b,!1,null,null,null);t.a=r.exports},727:function(e,t,n){"use strict";n.d(t,"a",function(){return s}),n.d(t,"b",function(){return o});var s=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("ui-dropdown",{attrs:{trigger:"click"},on:{"on-click":e.setTheme}},[n("a",{attrs:{href:"javascript:void(0)"}},[n("ui-icon",{style:{marginTop:"-2px",verticalAlign:"middle"},attrs:{color:"#495060",size:18,type:"paintbucket"}}),e._v(" "),n("ui-icon",{attrs:{type:"arrow-down-b"}})],1),e._v(" "),n("ui-dropdown-menu",{attrs:{slot:"list"},slot:"list"},e._l(e.themeList,function(t,s){return n("ui-dropdown-item",{key:s,attrs:{name:t.name}},[n("ui-row",{attrs:{type:"flex",justify:"center",align:"middle"}},[n("span",{staticStyle:{"margin-right":"10px"}},[n("ui-icon",{attrs:{size:20,type:"b"!==t.name.substr(0,1)?"happy-outline":"happy",color:t.menu}})],1),e._v(" "),n("span",[n("ui-icon",{attrs:{size:22,type:"record",color:t.element}})],1)])],1)}))],1)},o=[]},728:function(e,t,n){"use strict";var s=n(203),o=n.n(s),i={};i.inOf=function(e,t){var n=!0;return e.map(function(e){t.indexOf(e)<0&&(n=!1)}),n},i.oneOf=function(e,t){return t.indexOf(e)>=0},i.showThisRoute=function(e,t){return"object"===(void 0===e?"undefined":o()(e))&&e.isArray()?i.oneOf(t,e):e===t},i.getPathObjByName=function(e,t){return e.$store.state.routers.filter(function(e){if(e.children.length<=1)return e.name===t;for(var n=0,s=e.children,o=s.length;n<o;){if(s[n].name===t)return!0;n++}return!1})[0]},i.setCurrentPath=function(e,t){var n=[{title:"首页",path:"/home",name:"首页"}];if("首页"!==t){var s=e.$store.getters.breadPaths,o=s.get(t);o&&o.forEach(function(e){n.push({title:e,name:e})})}return e.$store.commit("SET_CURRENT_PAGE",n),n},i.openPage=function(e,t,n,s,o){var i=e.$store.getters.tempRoutes;!!i[0]&&i[0].children.some(function(e){return e.path===t})||e.$store.commit("ADD_TEMP_ROUTE",{routePath:t,name:n,title:n,filePath:s}),e.$router.push({path:t,query:o});var r=!1;e.$store.getters.pageOpenedList.forEach(function(n,s){n.path===t&&(r=!0,e.$store.commit("MOVE_TO_SECOND",s))}),r||(e.$store.commit("INCREATE_TAG",{path:t,name:n,title:n}),e.$store.commit("REMOVE_EXCLUDE_PAGE",t))},t.a=i},729:function(e,t,n){"use strict";n.d(t,"a",function(){return s}),n.d(t,"b",function(){return o});var s=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"main-layout",attrs:{id:"main",tabIndex:"1"},on:{keydown:e.shortCutKey}},[n("div",{staticClass:"main-layout-header-bar"},[n("div",{staticClass:"main-layout-header"},[n("div",{staticClass:"navicon-con",on:{mouseenter:e.showMenu,mouseleave:e.hideMenu}},[n("ui-button",{staticStyle:{"margin-top":"6px"},attrs:{type:"text"}},[n("ui-icon",{style:{transform:"rotateZ("+(this.toShowMenu?"0":"90")+"deg)"},attrs:{type:"navicon",size:"32"}}),e._v(" "),n("span",{staticClass:"menu-title"},[e._v("菜单")])],1)],1),e._v(" "),e._m(0),e._v(" "),n("div",{staticClass:"header-middle-con"},[n("div",{staticClass:"main-breadcrumb"},[n("breadcrumb-nav",{attrs:{currentPath:e.currentPaths}})],1)]),e._v(" "),n("div",{staticClass:"header-avator-con"},[e.showFullScreenBtn?n("div",{staticClass:"full-screen-btn-con",on:{click:e.handleFullScreen}},[n("ui-tooltip",{attrs:{content:e.isFullScreen?"退出全屏":"全屏",placement:"bottom"}},[n("ui-icon",{attrs:{type:e.isFullScreen?"arrow-shrink":"arrow-expand",size:23}})],1)],1):e._e(),e._v(" "),n("div",{directives:[{name:"show",rawName:"v-show",value:e.showLockSwitch,expression:"showLockSwitch"}],staticClass:"lock-screen-btn-con",on:{click:e.lockScreen}},[n("ui-tooltip",{attrs:{content:"锁屏",placement:"bottom"}},[n("ui-icon",{attrs:{type:"locked",size:20}})],1)],1),e._v(" "),n("div",{staticClass:"message-con",on:{click:e.showMessage}},[n("ui-tooltip",{attrs:{content:e.messageCount>0?"有"+e.messageCount+"条未读消息":"无未读消息",placement:"bottom"}},[n("ui-badge",{attrs:{count:e.messageCount,dot:""}},[n("ui-icon",{attrs:{type:"ios-bell",size:22}})],1)],1)],1),e._v(" "),n("div",{directives:[{name:"show",rawName:"v-show",value:e.showChangeTheme,expression:"showChangeTheme"}],staticClass:"switch-theme-con"},[n("ui-row",{staticClass:"switch-theme",attrs:{type:"flex",justify:"center",align:"middle"}},[n("theme-dropdown-menu")],1)],1),e._v(" "),n("div",{staticClass:"logout-con",on:{click:e.handleLogout}},[n("ui-tooltip",{attrs:{content:"注销",placement:"bottom"}},[n("ui-icon",{attrs:{type:"log-out",size:18}})],1)],1),e._v(" "),n("div",{staticClass:"avatar-con"},[n("span",{staticStyle:{font:"12px/1.5 Tahoma,Helvetica,Arial,'宋体',sans-serif","margin-left":"10px","margin-right":"2px"}},[e._v(e._s(e.userName+"["+e.userId+"]"))]),e._v(" "),n("ui-avatar",{staticStyle:{background:"#619fe7"},attrs:{src:e.avatorPath}})],1)])]),e._v(" "),n("div",{staticClass:"tags-con"},[n("tags-page-opened",{attrs:{pageTagsList:e.pageTagsList}})],1)]),e._v(" "),n("div",{directives:[{name:"show",rawName:"v-show",value:e.toShowMenu,expression:"toShowMenu"}],staticClass:"main-layout-menu",on:{mouseenter:e.showMenu,mouseleave:e.hideMenu}},[n("cascade-menu",{attrs:{isRootMenu:e.isRootMenu,removeClass:e.removeClass,menuList:e.menuList},on:{"on-show-submenu":e.showSubMenu,"on-show-grandmenu":e.showGrandMenu,"on-select":e.routerPage}}),e._v(" "),n("cascade-menu",{attrs:{isSubMenu:e.isSubMenu,subMenuShow:e.subMenuShow,menuList:e.subMenuList},on:{"on-show-grandmenu":e.showGrandMenu,"on-show-forthmenu":e.showForthMenu,"on-select":e.routerPage}}),e._v(" "),n("cascade-menu",{attrs:{isGrandMenu:e.isGrandMenu,grandMenuShow:e.grandMenuShow,menuList:e.grandMenuList},on:{"on-show-forthmenu":e.showForthMenu,"on-select":e.routerPage}}),e._v(" "),n("cascade-menu",{attrs:{isForthMenu:e.isForthMenu,forthMenuShow:e.forthMenuShow,menuList:e.forthMenuList},on:{"on-select":e.routerPage}})],1),e._v(" "),n("div",{staticClass:"single-page"},[n("ui-spin",{directives:[{name:"show",rawName:"v-show",value:e.showLoading,expression:"showLoading"}],staticStyle:{"background-color":"rgba(255, 255, 255, 0.2)"},attrs:{fix:""}},[n("ui-icon",{staticClass:"frame-spin-icon-load",attrs:{type:"load-c",size:"26"}}),e._v(" "),n("div",[e._v("请求正在处理中，请稍后...")])],1),e._v(" "),n("div",{staticClass:"frame-layout-router"},[n("keep-alive",{attrs:{exclude:e.excludeRouter}},[n("router-view")],1)],1)],1),e._v(" "),n("div",{directives:[{name:"show",rawName:"v-show",value:e.showShortCutBox,expression:"showShortCutBox"}],staticClass:"short-cut-box"},[n("ui-icon",{staticStyle:{position:"absolute",right:"13px",cursor:"pointer"},attrs:{type:"close",size:"11",color:"#FFFF"},nativeOn:{click:function(t){return e.closeShortCut(t)}}}),e._v(" "),e._m(1),e._v(" "),n("div",{staticClass:"short-cut-box-prepend"},[n("ui-select",{staticStyle:{width:"70px",display:"inline-block"},attrs:{value:e.searchContent}},[n("ui-option",{attrs:{value:"menu"}},[e._v("菜单")])],1)],1),e._v(" "),n("div",{staticStyle:{display:"inline-block",width:"307px"}},[n("ui-auto-complete",{ref:"shortCutInput",attrs:{placeholder:"快捷键[Ctrl+M]",clearable:!0,data:e.shortCutMenuList},on:{"on-search":e.handleSearch,"on-select":e.shortCutRouterPage},model:{value:e.shortCutMenu,callback:function(t){e.shortCutMenu=t},expression:"shortCutMenu"}})],1)],1)])},o=[function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{staticClass:"logo-con"},[s("img",{attrs:{src:n(730),alt:"金证股份"}})])},function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticStyle:{color:"#FFFF",padding:"2px"}},[n("span",[e._v("请输入关键字：")])])}]},730:function(e,t){e.exports="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAKwAAAAiCAYAAADCizJwAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyhpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMDY3IDc5LjE1Nzc0NywgMjAxNS8wMy8zMC0yMzo0MDo0MiAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIDIwMTUgKE1hY2ludG9zaCkiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6QUYxNzNFQkFGRjREMTFFN0EwNTI4RDAwNkU4RjZBNzUiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6QUYxNzNFQkJGRjREMTFFN0EwNTI4RDAwNkU4RjZBNzUiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDo4QkJBRTE3NUZGNEIxMUU3QTA1MjhEMDA2RThGNkE3NSIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDo4QkJBRTE3NkZGNEIxMUU3QTA1MjhEMDA2RThGNkE3NSIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PvEABb0AAAuGSURBVHja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"}});
//# sourceMappingURL=0.026c1cf40535051a9e5f.js.map