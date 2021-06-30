/**
 * Examination Information Components
 * Prevent {{}} splash screen of vue, put all operations into the component
 */
"use strict";
Vue.config.devtools = true;
var VueConfig = {
    data: {
        "comprehensive": {},
        'comprehensiveTemplate': {},
        'search': {
            pageNo: 1
        }
    },
    mounted: function () {
        var _this = this;
        layer.ready(function () {
            _this.doSearch();
        });
    },
    methods: {
        doSearch: function (classId) {
            var _this = this;
            var condition = _this.getParam(_this.ifEmpty(classId));
            var index = layer.load(3, {
                shade: [0.2, '#000'], //0.1透明度的白色背景
                zIndex: 30
            });
            // 查询分页
            _this.turnPage(condition, this);
            $.post(Report.queryTestInfoListUrl, condition, function (data) {
                if (data.data.length > 0) {
                    _this.comprehensive.testInfoList = data.data;
                }else {
                    _this.comprehensive.testInfoList = [];
                }
                layer.close(index);
            });
        },
        turnPage: function (condition, _this) {   //翻页
            $.ajaxSettings.async = false;
            $.post(Report.totalUrl, condition, function (result) {
                var total = result.data;
                if (total > 0) {
                    $("#noTestInfo").hide();
                } else {
                    $("#noTestInfo").show();
                }
                _this.search.count = total;
                _this.initPageNum(_this.search, 10, total);
                $("#pageOne").initPage(_this.search.count, _this.search.pageNo, function (pageNum) {//1、所有数据条数（自动每页十条）2、初次加载显示的页数 3、所执行函数
                    _this.search.pageNo = pageNum;
                    _this.doSearch();
                });
            });
            $.ajaxSettings.async = true;
        },
        getParam: function (classId) {
            return {
                userId: this.ifEmpty(Report.userId),
                gradeCode: this.ifEmpty(Report.gradeCode),
                subjectCode: this.ifEmpty(Report.subjectCode),
                classId: this.ifEmpty(classId),
                testName: this.ifEmpty(Report.testName),
                offset: (this.search.pageNo - 1) * 10,
                rows: 10
            };
        },
        initPageNum: function (search, rows, total) {
            if (rows == 0) {
                search.pageNum = (total % 10 > 0) ? (parseInt(total / 10) + 1) : parseInt(total / 10);
            } else {
                search.pageNum = (total % rows > 0) ? (parseInt(total / rows) + 1) : parseInt(total / rows);
            }
        },
        ifEmpty: function (arg, defaultStr) {
            if (defaultStr == undefined) {
                defaultStr = '';
            }
            if (arg == undefined || arg == null) {
                return defaultStr;
            }
            return arg;
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
    }
};

var Report = window.Report = {
    vm: null,
    comprehensive: {},
    classList:[],
    testInfoList: [],
    init: function (){
        this.initComprehensive();
        this.initVue();
        this.initEvent();
    },
    initVue: function (){
        VueConfig.data.comprehensive = this.comprehensive;
        this.vm = new Vue(VueConfig);
        this.vm.$mount("#report");
    },
    initComprehensive: function (){
        var _this = this;
        $(".navLi").removeClass("activeLi");
        $("#comprehensive").addClass("activeLi");
        _this.comprehensive.testInfoList = _this.testInfoList;
    },
    initEvent: function (){
        var _this = this;
        $("#classMap").change(function (){
            var classId = $("#classMap option:selected").val();
            if (classId != "all"){
                _this.vm.doSearch(classId);
            }else {
                _this.vm.doSearch();
            }
        });
    },
    getTestInfoList: function (data){
        var _this = this;
        var testInfo = {};
        $.ajax({
            url:_this.queryTestInfoListUrl,
            type: "post",
            contentType:"application/json",
            data: JSON.stringify(data),
            dataType: "json",
            async: false,
            success: function (result){
                testInfo = result.data;
            }
        })
        return testInfo;
    },
    getTotal: function (data){
        var _this = this;
        var total = 0;
        $.ajax({
            url:_this.totalUrl,
            type: "post",
            contentType:"application/json",
            data: JSON.stringify(data),
            dataType: "json",
            async: false,
            success: function (result){
                total = result.data;
            }
        })
        return total;
    },
    viewRePort: function (event){
        var _this = this;
        var url =  _this.viewRePortUrl + "?stepId={0}&fileId={1}&classId={2}";
        var stepId = $(event.target).attr("stepId");
        var fileId = $(event.target).attr("fileId");
        var classId = $(event.target).attr("classId");
        var groupId = $(event.target).attr("groupId");
        if (classId){
            url = CommUtils.formatStr(url,
                _this.vm.ifEmpty(stepId),
                _this.vm.ifEmpty(fileId),
                _this.vm.ifEmpty(classId));
        }else {
            url = CommUtils.formatStr(url,
                _this.vm.ifEmpty(stepId),
                _this.vm.ifEmpty(fileId),
                _this.vm.ifEmpty(groupId));
        }

        window.open(url,"_blank");
    }
}