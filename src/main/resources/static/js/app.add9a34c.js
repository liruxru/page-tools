(function(t){function e(e){for(var a,o,l=e[0],s=e[1],u=e[2],c=0,h=[];c<l.length;c++)o=l[c],Object.prototype.hasOwnProperty.call(r,o)&&r[o]&&h.push(r[o][0]),r[o]=0;for(a in s)Object.prototype.hasOwnProperty.call(s,a)&&(t[a]=s[a]);d&&d(e);while(h.length)h.shift()();return i.push.apply(i,u||[]),n()}function n(){for(var t,e=0;e<i.length;e++){for(var n=i[e],a=!0,l=1;l<n.length;l++){var s=n[l];0!==r[s]&&(a=!1)}a&&(i.splice(e--,1),t=o(o.s=n[0]))}return t}var a={},r={app:0},i=[];function o(e){if(a[e])return a[e].exports;var n=a[e]={i:e,l:!1,exports:{}};return t[e].call(n.exports,n,n.exports,o),n.l=!0,n.exports}o.m=t,o.c=a,o.d=function(t,e,n){o.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:n})},o.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},o.t=function(t,e){if(1&e&&(t=o(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var n=Object.create(null);if(o.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var a in t)o.d(n,a,function(e){return t[e]}.bind(null,a));return n},o.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return o.d(e,"a",e),e},o.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},o.p="/";var l=window["webpackJsonp"]=window["webpackJsonp"]||[],s=l.push.bind(l);l.push=e,l=l.slice();for(var u=0;u<l.length;u++)e(l[u]);var d=s;i.push([0,"chunk-vendors"]),n()})({0:function(t,e,n){t.exports=n("56d7")},1:function(t,e){},"29c6":function(t,e,n){},"56d7":function(t,e,n){"use strict";n.r(e);n("d9a3"),n("c9db"),n("de3e"),n("618d");var a=n("0261"),r=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"app"}},[n("v-home")],1)},i=[],o=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"homePage"}},[n("el-container",[n("el-header",[n("v-header")],1),n("el-main",[n("router-view")],1)],1)],1)},l=[],s=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"header"},[n("el-menu",{staticClass:"el-menu-demo",attrs:{"default-active":t.activeIndex,mode:"horizontal"},on:{select:t.handleSelect}},[n("el-submenu",{attrs:{index:"1"}},[n("template",{slot:"title"},[t._v("PRE工具")]),n("el-menu-item",{attrs:{index:"1-1"}},[t._v("打点工具")]),n("el-menu-item",{attrs:{index:"1-2"}},[n("router-link",{attrs:{to:"/singlePointWrite/400012"}},[t._v("测试界面")])],1)],2),n("el-submenu",{attrs:{index:"2"}},[n("template",{slot:"title"},[t._v("装车工具")]),n("el-submenu",{attrs:{index:"2-1"}},[n("template",{slot:"title"},[t._v("一号站")]),n("el-menu-item",{attrs:{index:"2-1-1"}},[n("router-link",{attrs:{to:"/screen/400012"}},[t._v("一号站光幕")])],1),n("el-menu-item",{attrs:{index:"2-1-2"}},[n("router-link",{attrs:{to:"/plcData?loadLine=400012"}},[t._v("一号站实时数据")])],1),n("el-menu-item",{attrs:{index:"2-1-3"}},[t._v("一号站火车动画")]),n("el-menu-item",{attrs:{index:"2-1-4"}},[n("router-link",{attrs:{to:"/realTimeRadarData/400012"}},[t._v("一号站实时雷达数据")])],1),n("el-menu-item",{attrs:{index:"2-1-5"}},[t._v("装车过程数据")])],2),n("el-submenu",{attrs:{index:"2-2"}},[n("template",{slot:"title"},[t._v("二号站")]),n("el-menu-item",{attrs:{index:"2-2-1"}},[n("router-link",{attrs:{to:"/screen/400013"}},[t._v("二号站光幕")])],1),n("el-menu-item",{attrs:{index:"2-2-2"}},[n("router-link",{attrs:{to:"/plcData?loadLine=400013"}},[t._v("二号站实时数据")])],1),n("el-menu-item",{attrs:{index:"2-2-3"}},[t._v("二号站火车动画")]),n("el-menu-item",{attrs:{index:"2-2-4"}},[n("router-link",{attrs:{to:"/realTimeRadarData/400013"}},[t._v("二号站实时雷达数据")])],1),n("el-menu-item",{attrs:{index:"2-2-5"}},[t._v("装车过程数据")])],2),n("el-menu-item",{attrs:{index:"2-3"}},[n("router-link",{attrs:{to:"/taskNowLoad"}},[t._v("正在装车的任务")])],1),n("el-menu-item",{attrs:{index:"2-4"}},[n("router-link",{attrs:{to:"/taskSyn"}},[t._v("新旧数据库同步")])],1)],2),n("el-menu-item",{attrs:{index:"3"}},[t._v("导数工具")]),n("el-menu-item",{attrs:{index:"4"}},[t._v("配煤工具")])],1)],1)},u=[],d={data:function(){return{activeIndex:"2-1"}},methods:{handleSelect:function(t,e){console.log(t,e)}}},c=d,h=n("e90a"),m=Object(h["a"])(c,s,u,!1,null,"f13889be",null),p=m.exports,f={name:"Home",props:{msg:String},components:{"v-header":p}},v=f,b=Object(h["a"])(v,o,l,!1,null,"190bcef2",null),g=b.exports,y={name:"App",components:{"v-home":g}},_=y,L=Object(h["a"])(_,r,i,!1,null,null,null),x=L.exports,k=n("5a4b"),w=n("2ca7"),S=n.n(w),N=(n("46c6"),n("1bee")),T="",$={BASE_URL:T},O=(n("1446"),n("2389")),P=n.n(O),E=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"screen"}},[n("el-container",[n("el-header",[n("div",[n("el-radio",{attrs:{label:1,border:""},model:{value:t.activeScreen,callback:function(e){t.activeScreen=e},expression:"activeScreen"}},[t._v("主光幕")]),n("el-radio",{attrs:{label:2,border:""},model:{value:t.activeScreen,callback:function(e){t.activeScreen=e},expression:"activeScreen"}},[t._v("备用光幕")])],1)]),n("el-main",[n("v-position",{attrs:{loadLine:t.loadLine}}),n("table",{staticClass:"table-bordered table-hover table-condensed"},[n("thead",t._l(40,(function(e){return n("th",{key:e},[n("span",e<10?[t._v(t._s("0"+e))]:[t._v(t._s(e))])])})),0),n("tbody",{attrs:{id:"screenTable"}},[n("tr",[n("td")])])])],1)],1)],1)},R=[],C=function(){var t=this,e=t.$createElement;t._self._c;return t._m(0)},I=[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"position"}},[n("h6",[t._v(" 定位结果车速: "),n("span",{attrs:{id:"trainV"}})]),n("table",{staticClass:"table table-condensed"},[n("thead",[n("tr",[n("td",[t._v("车厢号")]),n("td",[t._v("头坐标")]),n("td",[t._v("尾坐标")]),n("td",[t._v("头-尾")])])]),n("tbody",{attrs:{id:"trainPosition"}},[n("tr",[n("td",[t._v("asdas")]),n("td",[t._v("asdas")]),n("td",[t._v("asdas")]),n("td",[t._v("asdas")])])])])])}],j=(n("4045"),{name:"Position",data:function(){return{timer:null}},methods:{refreshPosition:function(){var t="http://localhost:8082/getAllPosition?loadLine="+this.loadLine;this.$http.get(t).then((function(t){var e=t.body,n=document.querySelector("#trainPosition");if(e&&e.length>0){for(var a="",r=0;r<e.length;r++){var i=e[r].carHead-e[r].carTail;a+="<tr>",a+="<td>"+e[r].index+"</td>",a+="<td>"+e[r].carHead+"</td>",a+="<td>"+e[r].carTail+"</td>",a+="<td>"+i+"</td>",a+="</tr>"}n&&(document.querySelector("#trainPosition").innerHTML=a)}else n&&(n.innerHTML="")}),(function(t){console.log(t);var e=document.querySelector("#trainPosition");e&&(e.innerHTML="")}));var e="http://localhost:8082/getTrainV?loadLine="+this.loadLine;this.$http.get(e).then((function(t){var e=t.bodyText,n=e.substring(0,e.indexOf(".")+3),a=document.querySelector("#trainV");a&&(a.innerHTML=n)}),(function(t){console.log(t)}))}},mounted:function(){this.refreshPosition(),this.timer=setInterval(this.refreshPosition,200)},destroyed:function(){this.timer&&clearInterval(this.timer)},props:["loadLine"]}),D=j,M=Object(h["a"])(D,C,I,!1,null,null,null),V=M.exports,q={name:"Screen",data:function(){return{timer:null,loadLine:"",activeScreen:1}},methods:{refreshScreen:function(){var t="http://localhost:8082/screenData?loadLine="+this.loadLine+"&activeScreen="+this.activeScreen;this.$http.post(t).then((function(t){for(var e=t.body,n="",a=0;a<e.length;a+=40){n+="<tr>";for(var r=0;r<40;r++)1==e[a+r]?n+='<td style="background:#000; color:#FFF">'+e[a+r]+"</td>":n+="<td>"+e[a+r]+"</td>";n+="</tr>"}document.querySelector("#screenTable").innerHTML=n}),(function(t){console.log(t)}))}},mounted:function(){this.loadLine=this.$route.params.loadLine,this.refreshScreen(),this.timer=setInterval(this.refreshScreen,200)},components:{"v-position":V},destroyed:function(){this.timer&&clearInterval(this.timer)},watch:{$route:function(){this.$route.params.loadLine&&(this.loadLine=this.$route.params.loadLine)}}},A=q,G=Object(h["a"])(A,E,R,!1,null,"326932b0",null),H=G.exports,B=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"myChart"}})},W=[],z=(n("3a20"),n("252a"),{name:"RealTimeRadarData",data:function(){return{times:2e3,timer:null,loadLine:"400012"}},methods:{refreshRealTimeRadarData:function(){var t=this,e="http://localhost:8082/realTimeRadarData?loadLine="+this.loadLine;this.$http.get(e).then((function(e){var n=e.body;console.log(n);var a=t.$echarts.init(document.getElementById("myChart")),r={title:{text:"西克测厚雷达实时数据"},tooltip:{},legend:{data:["值"]},xAxis:{data:n.keys,splitLine:{show:!1},splitArea:{show:!1}},yAxis:{splitArea:{show:!1}},series:[{name:"点号",type:"bar",data:n.value,large:!0}]};a.setOption(r),console.log("图形初始化成功")}),(function(t){console.log(t)}))}},mounted:function(){this.refreshRealTimeRadarData(),setInterval(this.refreshRealTimeRadarData,200)},destroyed:function(){this.timer&&clearInterval(this.timer)},watch:{$route:function(){this.$route.params.loadLine&&(this.loadLine=this.$route.params.loadLine)}}}),F=z,J=(n("d56a"),Object(h["a"])(F,B,W,!1,null,null,null)),U=J.exports,K=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("el-container",{attrs:{width:"300px"}},[n("div",{attrs:{id:"singlePointWrite"}},[n("h6",[t._v("pre测试界面")]),n("div",[n("el-radio",{attrs:{label:1,border:""},model:{value:t.sendMethod,callback:function(e){t.sendMethod=e},expression:"sendMethod"}},[t._v("连续单个发送")]),n("el-radio",{attrs:{label:2,border:""},model:{value:t.sendMethod,callback:function(e){t.sendMethod=e},expression:"sendMethod"}},[t._v("list集合发送")])],1),n("el-form",{ref:"form",attrs:{"label-width":"180px"}},[n("el-form-item",{attrs:{label:"请输入点号"}},[n("el-input",{attrs:{placeholder:"请输入点号",clearable:""},model:{value:t.pointId,callback:function(e){t.pointId=e},expression:"pointId"}})],1),n("el-form-item",{attrs:{label:"请输入结束点号"}},[n("el-input",{attrs:{placeholder:"请输入结束点号",clearable:""},model:{value:t.pointIdEnd,callback:function(e){t.pointIdEnd=e},expression:"pointIdEnd"}})],1),n("el-form-item",{attrs:{label:"请输入点值"}},[n("el-input",{attrs:{placeholder:"请输入点值",clearable:""},model:{value:t.rawValue,callback:function(e){t.rawValue=e},expression:"rawValue"}})],1),n("el-form-item",{attrs:{label:"请输入刷新频率"}},[n("el-input",{attrs:{placeholder:"请输入刷新频率",clearable:""},model:{value:t.times,callback:function(e){t.times=e},expression:"times"}})],1),n("el-form-item",[n("el-button",{attrs:{type:"primary"},on:{click:function(e){return t.begin()}}},[t._v("开始")]),n("el-button",{attrs:{type:"danger"},on:{click:function(e){return t.stop()}}},[t._v("停止")])],1)],1)],1)])},Q=[],X={name:"SinglePointWrite",data:function(){return{pointId:"",rawValue:0,pointIdEnd:"",times:500,timer:null,sendMethod:1}},methods:{begin:function(){this.timer=setInterval(this.writePoint,this.times)},stop:function(){this.timer&&(clearInterval(this.timer),this.timer=null)},writePoint:function(){var t=this,e="";e=1==this.sendMethod?this.GLOBAL.BASE_URL+"/writePoints":this.GLOBAL.BASE_URL+"/writePointList",console.log(this.$data),this.$http.post(e,this.$data,{emulateJSON:!0}).then((function(e){console.log(e),t.rawValue=1*t.rawValue+1,console.log(t.rawValue)}),(function(t){console.log(t)}))}}},Y=X,Z=Object(h["a"])(Y,K,Q,!1,null,null,null),tt=Z.exports,et=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"tasks"}},[n("h6",[t._v("查看正在装车的列表")]),n("el-dialog",{attrs:{title:"车厢列表",visible:t.dialogVisible,width:"40%"},on:{"update:visible":function(e){t.dialogVisible=e}}},[n("v-carrige-list",{ref:"carriageListPage",attrs:{loadLine:t.queryLoadLine,taskNum:t.queryTaskNum}})],1),n("el-table",{staticStyle:{width:"100%"},attrs:{data:t.tableData,border:""}},[n("el-table-column",{attrs:{fixed:"",prop:"trainNum",label:"车次号",width:"150"}}),n("el-table-column",{attrs:{prop:"loadLineName",label:"装车线",width:"120"}}),n("el-table-column",{attrs:{prop:"trainNumTotal",label:"总节数",width:"120"}}),n("el-table-column",{attrs:{label:"操作",width:"100"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("el-button",{attrs:{slot:"reference",type:"text",size:"small"},on:{click:function(n){return t.queryCarriageList(e.row)}},slot:"reference"},[t._v("查看车厢列表")])]}}])})],1)],1)},nt=[],at=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"carriages"}},[n("el-table",{attrs:{data:t.carriageData,border:"",height:"400px",width:"450px"}},[n("el-table-column",{attrs:{fixed:"",prop:"orderNum",label:"序号",width:"150"}}),n("el-table-column",{attrs:{fixed:"",prop:"trainNum",label:"车厢号码",width:"250"}}),n("el-table-column",{attrs:{label:"操作",width:"200"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("el-button",{attrs:{type:"text",size:"small"},on:{click:function(n){return t.getRadarData(e.row)}}},[t._v("查看偏载图形")])]}}])})],1),n("el-dialog",{attrs:{width:"60%",title:"雷达图",visible:t.innerVisible,"append-to-body":""},on:{"update:visible":function(e){t.innerVisible=e}}},[n("v-radar",{ref:"radarGraph",attrs:{loadLine:t.loadLine,taskNum:t.taskNum,trainNum:t.queryTrainNum}})],1)],1)},rt=[],it=function(){var t=this,e=t.$createElement;t._self._c;return t._m(0)},ot=[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"radarGraph"}},[n("span",{attrs:{id:"chartTip"}}),n("div",{attrs:{id:"myChart"}})])}],lt={name:"RadarGraph",data:function(){return{myChart:null}},methods:{getRadarGraph:function(){var t=this,e="http://localhost:8082/getRadarDataGraph?loadLine="+this.loadLine+"&taskNum="+this.taskNum+"&trainNum="+this.trainNum;this.$http.post(e).then((function(e){var n=e.body;if(console.log(n),!n||0==n.length)return document.getElementById("chartTip").innerHTML="暂无数据",void(t.myChart&&(t.myChart.clear(),t.myChart.dispose(),t.myChart=null));console.log(n);for(var a=new Array,r=new Array,i=0;i<n.length;i++)a.push(n[i].position),r.push(n[i].unbalanceValue);document.getElementById("chartTip").innerHTML="",t.myChart=t.$echarts.init(document.getElementById("myChart"));var o={title:{text:"车厢二维雷达图"},tooltip:{},xAxis:{data:a,boundaryGap:!1},yAxis:{type:"value"},series:[{name:"点号",type:"line",data:r,areaStyle:{}}]};t.myChart.setOption(o),console.log("图形初始化成功")}),(function(t){console.log(t)}))}},props:["loadLine","taskNum","trainNum"],mounted:function(){this.getRadarGraph()},watch:{trainNum:function(){this.trainNum&&this.getRadarGraph()}}},st=lt,ut=Object(h["a"])(st,it,ot,!1,null,null,null),dt=ut.exports,ct={name:"CarriageList",data:function(){return{carriageData:[],innerVisible:!1,queryTrainNum:""}},methods:{getCarriageList:function(){var t=this,e="http://localhost:8082/queryCarriage?loadLine="+this.loadLine+"&taskNum="+this.taskNum;this.$http.post(e).then((function(e){var n=e.body;console.log(n),t.carriageData=n}),(function(t){console.log(t)}))},getRadarData:function(t){this.loadLine=t.loadLine,this.taskNum=t.taskNum;var e=t.trainNum;this.innerVisible=!0,this.queryTrainNum=e}},mounted:function(){this.getCarriageList()},destroyed:function(){},props:["loadLine","taskNum"],components:{"v-radar":dt},watch:{taskNum:function(){this.taskNum&&this.getCarriageList()}}},ht=ct,mt=Object(h["a"])(ht,at,rt,!1,null,null,null),pt=mt.exports,ft={methods:{queryCarriageList:function(t){this.dialogVisible=!0,this.queryLoadLine=t.loadLine,this.queryTaskNum=t.taskNum},showTaskLoadNow:function(){var t=this,e="http://localhost:8082/taskList";this.$http.get(e).then((function(e){var n=e.body;t.tableData=n}),(function(t){console.log(t)}))}},data:function(){return{tableData:[],dialogVisible:!1,queryLoadLine:"",queryTaskNum:""}},components:{"v-carrige-list":pt},mounted:function(){this.showTaskLoadNow()}},vt=ft,bt=Object(h["a"])(vt,et,nt,!1,null,null,null),gt=bt.exports,yt=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"tasksyn"}},[t._v(t._s(t.msg))])},_t=[],Lt={name:"Home",data:function(){return{msg:""}},mounted:function(){this.taskSyn()},methods:{taskSyn:function(){var t=this;this.msg="正在同步 请等待。。。。。";var e="http://localhost:8082/syncTask";this.$http.get(e).then((function(e){var n=e.body;t.msg=n.msg}),(function(t){console.log(t)}))}}},xt=Lt,kt=Object(h["a"])(xt,yt,_t,!1,null,"dbc26bce",null),wt=kt.exports;a["default"].prototype.GLOBAL=$,a["default"].prototype.$echarts=P.a,a["default"].use(k["a"]),a["default"].use(S.a),a["default"].use(N["a"]),a["default"].use(P.a);var St=[{path:"/screen/:loadLine",component:H},{path:"/singlePointWrite/:loadLine",component:tt},{path:"/realTimeRadarData/:loadLine",component:U},{path:"/taskNowLoad",component:gt},{path:"/taskSyn",component:wt}],Nt=new N["a"]({routes:St});a["default"].config.productionTip=!1,new a["default"]({render:function(t){return t(x)},router:Nt}).$mount("#app")},d56a:function(t,e,n){"use strict";var a=n("29c6"),r=n.n(a);r.a}});
//# sourceMappingURL=app.add9a34c.js.map