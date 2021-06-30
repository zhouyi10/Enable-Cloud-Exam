/**
 * Examination Information Components
 * Prevent {{}} splash screen of vue, put all operations into the component
 */
"use strict";
Vue.config.devtools = true;
var VueConfig = {
    data: {
        "diagnosis": {},
        'diagnosisTemplate': {}
    },
    computed: {
    },
    methods: {
        ifEmpty: function (arg, defaultStr) {
            if (defaultStr == undefined) {
                defaultStr = '';
            }
            if (arg == undefined || arg == null) {
                return defaultStr;
            }
            return arg;
        }

    }
};

var paperInfo = window.paperInfo = {
    vm: null,
    diagnosis: {},
    classList:[
        {
            classId: "0",
            className: "全部班级"//i18n['classAll'] //
        }
    ],
    testInfoList: [],
    reportVO: {
        termId: "",
        gradeId: "",
        subjectId: "",
        testType: "",
        offset: 0,
        rows: 0
    },
    init: function (){
        /*this.initVue();
        this.initDiagnosis();*/

    },
    initVue: function (){
        VueConfig.data.diagnosis = CommUtils.clone(this.diagnosis);
        this.vm = new Vue(VueConfig);
        this.vm.$mount("#paperInfo");

    },
    initDiagnosis: function (){
        var _this = this;
        var loading = layer.load(1,{
            shadeClose: false,
            shade: [0.5,'#000']
        });

    },
    getTestInfoList: function (data){

    },
    getTotal: function (data){

    },
    comPaper: function (event){
        var _this = this;
        //var comp  =  "http://192.168.118.44:9567/manager/package/ppr/preedit"
        var userId = _this.userId;
        //console.log(userId);
        var url = _this.comp + "?userId=" + userId;
        window.location.href = url;
    },
    editPaper:function (paperId){
        var _this = this;
        if (paperId != null && paperId !="" && paperId !=undefined){
            var userId =  _this.userId;
            var url = _this.comp + "?userId=" + userId+ "&paperId=" + paperId;
            window.location.href = url;
        }else {
            layer.msg('试卷不存在！', { icon: 7, time: 1000, shade: [0.6, '#000', true] });
        }
    },

    viewAnswerCard: function(paperId){
        var _this = this;
        if (paperId != null && paperId !="" && paperId !=undefined){
            var userId = this.userId;
            var url = _this.comp + "?paperId=" + paperId+ "&userId=" + userId;
            this.frame("答题卡", url, '92%', '96%');
        }else {
            layer.msg('试卷不存在！', { icon: 7, time: 1000, shade: [0.6, '#000', true] });
        }
    },
    delPaper:function(paperId){

    },

    frame: function (title, url, height, width) {
            layer.open({
                type: 2,
                title: title,
                shadeClose: false,
                scrollbar: false,
                shade: 0.6,
                area: [width, height],
                content: url //iframe的url
            });
    },


    /*	function editPaper(paperId){

			if (paperId != null && paperId !="" && paperId !=undefined){
				var comp  =  "/manager/package/ppr/preedit"
				var userId = paperList[0].user.id;
				var url = comp + "?userId=" + userId+ "&paperId=" + paperId;
				window.location.href = url;
			}else {
				layer.msg('试卷不存在！', { icon: 7, time: 1000, shade: [0.6, '#000', true] });
			}
		}*/

    /*function viewAnswerCard(paperId){
        if (paperId != null && paperId !="" && paperId !=undefined){
            var comp  =  "/manager/package/ppr/answercard/preedit"
            var userId = paperList[0].user.id;
            var url = comp + "?paperId=" + paperId+ "&userId=" + userId;
            //this.frame(i18n['answer_card'], url, '92%', '96%');
            layer.open({
                type: 2,
                title: "答题卡",
                shadeClose: false,
                scrollbar: false,
                shade: 0.6,
                area: ['96%', '92%'],
                content: url //iframe的url
            });
            //window.location.href = url;
        }else {
            layer.msg('试卷不存在！', { icon: 7, time: 1000, shade: [0.6, '#000', true] });
        }
    }*/

    /* var paperQueryUrl = [[${_contextPath} + @{'/paper/query'}]];
     function myPaper(){
         var schoolPaperId = document.getElementById("schoolPaperId");
         schoolPaperId.style.color= "black";
         var myPaperId = document.getElementById("myPaperId");
         myPaperId.style.color= "Blue";
         $.ajax({
             type:'GET',
             url:paperQueryUrl+"?providerCode=R00",
             async:true,
             success:function(result){
                 //location.reload();
                 console.log('data:' + JSON.stringify(result.data));
             },error:function (r){
             }
         });
     }

     function schoolPaper(){
         var schoolPaperId = document.getElementById("schoolPaperId");
         schoolPaperId.style.color= "Blue";
         var myPaperId = document.getElementById("myPaperId");
         myPaperId.style.color= "black";
         document.getElementById("myForm").submit()
         $.ajax({
             type:'GET',
             url:paperQueryUrl+"?providerCode=R02",
             async:true,
             success:function(result){
                 //location.reload();
                 console.log('data:' + JSON.stringify(result.data));
             },error:function (r){
             }
         });
     }*/
}
